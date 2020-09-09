# User Management
## Overview

The goal of the project is to provide a simple interface to manage users. 
The main functionalities are : creating users, modifying users, deleting users and listing users.

## Project setup

The project uses RabbitMQ to send updates. To have a simple RabbitMQ server running on the default port run :

```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

To build the java part just run :

```
mvn install
```

To build the client you have to run this command :

```
In the path src/main/resources/static/client/usermgt
ng build
```

To launch the API server run : 

```
mvn spring-boot:run
```

The server runs on port 8080

The base url of the REST API is :

```
http://localhost:8080/user
```

A minimal angular client that connects to the API is available at :

```
http://localhost:8080/home
```
