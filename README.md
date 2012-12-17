Deployment Instructions.
1. Stop Tomcat.
2. Delete existing deployment. If you have previously deployed "Weather.war" in TOMCAT_HOME/webapps, then it has been unpacked into
   webapps/Weather/... You must delete this directory and all its contents.

3. Copy WAR file to TOMCAT_HOME/webapps/.
4. Start Tomcat. 
5. Access following url http://127.0.0.1:8080/Weather/getwether.jsp