FROM openjdk:8-jdk-alpine
MAINTAINER kratos
ADD target/service-hello-1.0.jar service-hello-1.0.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "service-hello-1.0.jar"]