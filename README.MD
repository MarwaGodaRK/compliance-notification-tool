# compliance-notification-tool
This tool has been developed for bootcamp hackathon  

<b>Compliance notification tool</b> This tool can be used to notify manager if one or more of his team will not
meet compliance metrics today. Manager can configure rules thresholds from UI

Rules are stored in mongoDB and team activities are retrieved from crossover APIs

Manager should login first to the tool so that scheduler will start to track his team activities

Following are the rules that requires configurations from manage
<ul>
 <li>Maximum stop per day</li>

 <li>Notify IC if (s)he didn’t track 4 hours today and the time is: value </li>

<li> Notify IC if (s)he must start work to track minimum allowed hours which is: value </li>

<li> Notify IC if (s)he tracked 4 hours but has more than allowed percentage of time categorized as other: value </li>

 <li>Notify IC if (s)he tracked 4 hours but has more than allowed percentage of time categorized as Distraction: value </li>

 <li>Notify IC if (s)he tracked 4 hours but has development time less than : value </li>

 <li>Notify IC if (s)he tracked 4 hours but has intensity less than : value </li>

 <li>Notify IC if (s)he tracked 4 hours but has focus less than : value </li>
</ul>
## Templates
Thymeleaf has been used as template engine. Templates should be prepared as html file using thymeleaf syntax.

Template files can be found in <b>resources/templates/mail</b> folder.


## Usage of the Tool with Maven

    mvn spring-boot:run
    or mvn clean install

## Usage of the Tool with Jar File
You should kick off the jar from root for security tokens. 

    java -jar target/compliance-notification-tool-0.0.1-SNAPSHOT.jar

## API Authorization
The first time you run the application it will require login to retrieve dashboard and team activities from APIs
Team and manager IDs and authorization token will be stored in mongoDB so that the scheduler will be able to retrieve team activities
