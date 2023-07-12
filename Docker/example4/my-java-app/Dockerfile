#FROM maven
#COPY . .
#RUN mvn compile
#CMD mvn exec:java -Dexec.mainClass=com.cdac.CreatePdf

FROM openjdk:17-alpine
COPY target/my-java-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar .
CMD java -jar my-java-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar
