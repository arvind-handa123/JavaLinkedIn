# LinkedIn Profiles Evaluation

##This code evaluates LinkedIn profiles based on an input text file.

+ Input: txt file separeted by pipes with public LinkedIn profiles information.
+ Output: Best LinkedIn profiles based on Recommendations, Connections, Nacionality and TN Visa 

Input file must have the next strucutre (values separated by pipes):  
<b>PublicProfileURL | Name | LastName | Title | GeographicArea | NumberOfRecommendations | NumberOfConnections | CurrentRole | Industry | Country </b>


Tech Used:
+ Spring Boot
+ Java 1.8
+ JPA
+ H2 (The information is loaded in memory)
+ Thymeleaf
+ MVC
+ JUnit + Mockito
+ JQuery
+ Bootstrap
+ Maven

How to launch the application:

1. Go to root directory (Where the pom.xml file is located)
2. mvn clean  
3. mvn install
4. Go to the target folder
5. java -jar demo-0.0.1-SNAPSHOT.jar
6. http://localhost:8080/
7. Upload a valid file
8. Click on "Load LinkedIn Profiles"

You can find a sample file [here](https://github.com/gustavoponce7/JavaLinkedIn/blob/master/demo/src/main/resources/PeopleToRate2.txt)

![Alt text](https://github.com/gustavoponce7/JavaLinkedIn/blob/master/demo/src/main/resources/captures/Capture1.PNG)

![Alt text](https://github.com/gustavoponce7/JavaLinkedIn/blob/master/demo/src/main/resources/captures/Capture2.PNG)

![Alt text](https://github.com/gustavoponce7/JavaLinkedIn/blob/master/demo/src/main/resources/captures/Capture3.PNG)

Unit test has been implemented for the service layer

1. Go to root directory (Where the pom.xml file is located)
2. mvn test

![Alt text](https://github.com/gustavoponce7/JavaLinkedIn/blob/master/demo/src/main/resources/captures/Capture4.PNG)

Possible enhancements:
+ Use the LinkedIn API to generate a session and send automatically email notifications to the users.
+ Generate a responsive design
+ Improve the UI
+ Use filters in the tables (JQuery DataTables can be an option)

Contact: gustavo.poce.ch@gmail.com
