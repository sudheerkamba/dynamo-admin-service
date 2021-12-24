FROM openjdk:latest
EXPOSE 8081
ADD target/flight-admin.jar api.jar
ENTRYPOINT ["sh","-c","java -jar /api.jar"]