FROM maven

COPY rest-api /rest-api
WORKDIR /rest-api

CMD ["mvn", "clean", "install", "tomcat7:run"]
