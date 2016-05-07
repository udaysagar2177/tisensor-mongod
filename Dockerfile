FROM maven:3.3.9-jdk-8

COPY rest-api /rest-api
WORKDIR /rest-api

CMD ["mvn", "clean", "install", "tomcat7:run"]