#FROM openjdk:8-jdk-alpine
#COPY target/FinAK-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM maven:3.8.2-jdk-8

WORKDIR /demo
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run