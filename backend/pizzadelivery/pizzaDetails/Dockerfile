FROM openjdk

#this command refers to the working directory of your image
WORKDIR usr/lib

#Please copy paste the url & database name from application.properties
ENV MONGO_DATABASE=customerDetailsDb
ENV MONGO_URL=mongodb://localhost:27017/customerDetailsDb

#copy executable file and put it your working directory
#add source destination
ADD ./target/CustomerDetails-0.0.1-SNAPSHOT.jar /usr/lib/CustomerDetails-0.0.1-SNAPSHOT.jar

#run the jar file
ENTRYPOINT ["java","-jar","CustomerDetails-0.0.1-SNAPSHOT.jar"]
