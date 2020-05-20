# kafka-java-app
44517 Module 3 Group 3: repository for a Kafka Java Application

**Reference Information**
- groupId: *edu.nwmissouri.bigdata3*
- artifactId: *kafka-java-app*

## Group Members
**Eli Ross (Lead)**
<br />My [Github (eliross84)](https://github.com/eliross84) Profile
<br />My [LinkedIn](https://www.linkedin.com/in/eli-ross-4b409616b) Profile
- I have created the Consumer for the program so that any input from the producer may be displayed. 

**Manideep Chamala** 
My Linkedin profile [https://www.linkedin.com/in/chamala-manideep-7a7425177/](https://www.linkedin.com/in/chamala-manideep-7a7425177/)
My Github profile [https://github.com/manideepchamala](https://github.com/manideepchamala)
- I have created a custom producer with the name manideepProducer.java . Here i have written some code where a String is taken and the first word is returned by considering the spaces.

**Michael Baumli**  
My [Github (MichaelJBaumli)](https://github.com/MichaelJBaumli/) Profile.  
My [Linked In (Michael Baumli)](https://www.linkedin.com/in/michael-baumli-70a51b4/) Profile.

**Venkat Prudhvi Dommaraju** -
My GithubProfile - [https://github.com/prudhvi15](https://github.com/prudhvi15)
My Linkedin profile - [https://www.linkedin.com/in/venkat-prudhvi-dommaraju-188720186/](https://www.linkedin.com/in/venkat-prudhvi-dommaraju-188720186/)
- I have created a custom producer named PrudhviProducer.java in which I used a simple logic to return length of the string.
1. To start zookeeper service I have used ```.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties```
1. To start kafka service I have used ```.\bin\windows\kafka-server-start.bat .\config\server.properties```
1. To compile and build jar file I have used ```mvn clean compile assembly:single```
1. To start consumer I have used ```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata3.simple.Consumer test group1```
1. To start producer I have used ```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata3.simple.PrudhviProducer test```

