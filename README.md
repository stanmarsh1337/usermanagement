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

Optional - To build the angular client you have to run this command :

```
In the path src/main/resources/static/client/usermgt
ng build
```

To launch the REST API server run : 

```
mvn spring-boot:run
```

The server runs on port 8080

## Features

The base url of the REST API is :

```
http://localhost:8080/user
```

Optional - A minimal angular client that connects to the API is available at :

```
http://localhost:8080/home
```

The API follows REST principles in terms of self documenting.

### List of users

To get the list of users use a GET request to the base url.

```
curl -v http://localhost:8080/user
```


Sample response :

```
{
  "_embedded" : {
    "user" : [ {
      "id" : 1,
      "email" : "test@test.com",
      "password" : "Ferrari",
      "firstName" : "Jaguar",
      "address" : "Porsche Street",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/user/1"
        },
        "user" : {
          "href" : "http://localhost:8080/user/1"
        }
      }
    },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/user"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/user"
    },
    "search" : {
      "href" : "http://localhost:8080/user/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
```

### Creation of users

To create a user use a POST request with all the fields in JSON format.

```
curl -X POST localhost:8080/user -H 'Content-type:application/json' -d '{"firstName": "Barney", "address": "Wisteria Lane", "password":"qwertz","email":"barn@ey.com"}'
```

The response will give you the generated id.

### Update of users

Two possibilities here:
- a PUT request will replace the existing values with the ones provided (using null for the missing values.
- a PATCH request will only update the values present in the JSON.

```
curl -X PUT localhost:8080/user/2 -H 'Content-type:application/json' -d '{"firstName": "Barney", "address": "Wisteria Lane", "password":"qwertz","email":"barn@ey.com"}'
```

OR

```
curl -X PATCH localhost:8080/user/2 -H 'Content-type:application/json' -d '{"address": "Wisteria Lane"}'
```

### Searchs

The possible searches are listed at :

```
http://localhost:8080/user/search
```

The API provides searches by address, by firstName and by Email.

```
{
  "_links" : {
    "findByAddress" : {
      "href" : "http://localhost:8080/user/search/findByAddress{?address}",
      "templated" : true
    },
    "findByFirstName" : {
      "href" : "http://localhost:8080/user/search/findByFirstName{?firstName}",
      "templated" : true
    },
    "findByEmail" : {
      "href" : "http://localhost:8080/user/search/findByEmail{?email}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8080/user/search"
    }
  }
}
```


