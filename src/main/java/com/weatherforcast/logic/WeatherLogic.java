package com.weatherforcast.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.weatherforcast.formData.WeatherData;

/**
 * @author vivek.mehra
 *
 */
@Component
public class WeatherLogic {

	private String line = "";
	private String line1;
	DocumentBuilder db = null;
	InputSource is = null;	
	Document doc = null;
	NodeList nodes = null;
	NodeList nodes2 = null;

	public void getDetails(String zip, WeatherData wetherForm) throws Exception {

		URL url = new URL(
				"http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/"
						+ zip + ".xml");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream()));

		while ((line1 = reader.readLine()) != null) {

			line = line + line1;
		}
		line = line.replaceAll("\\s+", "");
		//System.out.println(line);

		db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		is = new InputSource();
		is.setCharacterStream(new StringReader(line));
		doc = db.parse(is);
		nodes = doc.getElementsByTagName("display_location");
		nodes2 = doc.getElementsByTagName("current_observation");

		if (nodes.getLength() > 0 && nodes2.getLength() > 0) {

			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				NodeList city = element.getElementsByTagName("city");
				Element line2 = (Element) city.item(0);
				//System.out.println("City : "+ getCharacterDataFromElement(line2));
				wetherForm.setCity(getCharacterDataFromElement(line2));

				NodeList stateName = element.getElementsByTagName("state_name");
				line2 = (Element) stateName.item(0);
				//System.out.println("State Name : "+ getCharacterDataFromElement(line2));
				wetherForm.setState(getCharacterDataFromElement(line2));

			}

			for (int i = 0; i < nodes2.getLength(); i++) {
				Element element = (Element) nodes2.item(i);

				NodeList temp = element.getElementsByTagName("temp_f");
				Element line3 = (Element) temp.item(0);
				//System.out.println("Temprature in farh : "+ getCharacterDataFromElement(line3));
				wetherForm.setTemp(getCharacterDataFromElement(line3));

			}
		}else{
			wetherForm.setErrorMessage("Invalid Zip Code.");
		}
		line = "";
		reader.close();

	}

	private static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

}
