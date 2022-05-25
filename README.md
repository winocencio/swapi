# SWAPI People with recomendation

Java Spring boot API Rest, using https://swapi.dev/ or https://swapi.py4e.com/

## Features

- GET People by ID
- GET Peoples by Names
- Similars Peoples by Species

> the API was designed to query characters 
> from the Star Wars movie series,
> bringing their main information with relationship ids
> and recommendation of characters of the same species

## Tech

That project was used:

- [Java](https://www.java.com/) - Object-oriented programming language that is designed to have as few implementation dependencies as possible
- [Spring Boot](https://spring.io/) - Spring based Applications that you can "just run"
- [Redis](https://redis.io/) - Redis is an open source (BSD licensed), in-memory data structure store.
- [Docker](https://www.docker.com/) - Is a set of platform as a service (PaaS) products that use virtualization to deliver software in packages called containers.

## Installation

Install the dependencies and devDependencies and start the server.

```sh
./mvnw clean package
docker image build -t willinocencio/swapi .
docker-compose up
```

If you don't want build locally, the application is available on [dockerhub](https://hub.docker.com/r/willinocencio/swapi), you can use only:

```sh
docker-compose up
```

## Using

You can see and test endpoints locally in:
http://localhost:8080/swagger-ui/
