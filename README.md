# Offer Domain

Offer domain defines which events (with belonging markets and outcomes) will end
users see when it opens some client application (for example web or mobile).

## Prerequisites

Before running the app, make sure you have the following software installed on your machine:

- Java 17
- Maven
- Docker

## Getting Started

To get started, follow these steps:

1. Clone this repository to your local machine.

2. Copy the "files" folder on Windows C: drive as specified in application.properties so the app can save initial Market and Event data.

3. Navigate to the project directory and run the following command to build the application:

- `mvn clean package`

4. Run the following command to start kafka and zookeeper containers:

- ```docker-compose -f docker-compose.yml up -d```

5. Once the containers are up and running, you need to go into the Kafka container to manually create two topics using the following commands:

```docker exec -it kafka /bin/bash
./kafka-topics.sh --create --topic marketsTopic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
./kafka-topics.sh --create --topic eventsTopic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 2
```

6. Once the topics are created, run the following command to start the application:

- `java -jar target/betoffers-0.0.1-SNAPSHOT.jar`

This will start the application on the default port 8080.

## Project Files and Folders

- `src/main/java`: Contains the Java source code for the application.
- `src/main/resources`: Contains the application configuration files.
- `docker-compose.yml`: Contains the Docker Compose configuration for Kafka and Zookeeper.
- `pom.xml`: Contains the project configuration and dependencies.


