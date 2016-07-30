### Description

Litte sample spring boot application demonstrating amqp messaging over RabbitMQ.

The application contains code for sending and receiving messages via a queue.

Instances of the application can be started as sender, receiver or both.

The message payload consists of a simple Java Object (MyMessage) and gets serialized as JSON-String for messaging.

### Prerequisites

A running RabbitMQ instance listening on its standard port (5672).
If you have Docker installed the fasted way to get this might be to run:
```
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
(This will install a Management-Gui in addition)

Application has to be built (via IDE or mvn, e.g. "mvn clean package")

#### Running the sender process
```
java -jar -Dspring.profiles.active=sender target/spring-boot-with-amqp-1.0-SNAPSHOT.jar
```
(by appending "--send.rate=<value>" you can modify the rate in ms for sending messages)

#### Running one or more receiver processes
```
java -jar -Dspring.profiles.active=receiver target/spring-boot-with-amqp-1.0-SNAPSHOT.jar
```
(by appending "--processing.time=<value>" you can modify the (faked) processing time for consuming a message)

#### Examine the state of your queue
Login to http://localhost:15672 in your browser (credentials guest/guest)
