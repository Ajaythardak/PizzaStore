FROM openjdk

#this command refers to the working directory of your image
WORKDIR usr/lib

#Please copy paste the url & database name from application.properties
ENV MYSQL_DATABASE=microservice
ENV MYSQL_URL=jdbc:mysql://localhost:3306/microservice

#copy executable file and put it your working directory
#add source destination
ADD ./target/user-0.0.1-SNAPSHOT.jar /usr/lib/user-0.0.1-SNAPSHOT.jar

#run the jar file
ENTRYPOINT ["java","-jar","user-0.0.1-SNAPSHOT.jar"]
