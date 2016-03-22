#TiSensor-MongoDB

This is a REST API using Java Spring. It collects data from TiSensor and stores it into a MongoDB database.

## How To Run:

### REST API
Use tomcat7-maven-plugin. The dependency is included in the pom.xml. For IntelliJ, add a new 'Run Configuration' of type 'Maven' with the command `tomcat7:run`

### Loading Tool
To simulate the data pumping from TiSensor, execute `rest-api/src/main/java/com/load/SimulatedTiSensor.java`