FROM maven:3.5.2-jdk-8-alpine

COPY /target/simpleapi-1.0.jar simpleapi-1.0.jar

ENTRYPOINT ["java","-jar","simpleapi-1.0.jar"]