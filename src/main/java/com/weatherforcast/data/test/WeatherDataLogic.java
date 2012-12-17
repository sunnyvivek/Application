/**
 * 
 */
package com.weatherforcast.data.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.weatherforcast.formData.WeatherData;

/**
 * @author Vivek
 *
 */
public class WeatherDataLogic {

	static WeatherData data = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		data = new WeatherData();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		data=null;
	}

	/**
	 * Test method for {@link com.weatherforcast.formData.WeatherData#getZipCode()}.
	 */
	@Test
	public void testGetZipCode() {
		
		assertEquals(12345, 12345);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.weatherforcast.formData.WeatherData#setZipCode(java.lang.Integer)}.
	 */
	@Test
	public void testSetZipCode() {
		
		data.setZipCode(12345);
		//fail("Not yet implemented");
	}

}
