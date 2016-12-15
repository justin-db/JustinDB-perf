# Load testing
Lets put simulated demand on JustinDB!

## Tools
This project as a load testing tool uses great [Gatling](http://gatling.io) library.
They official doc states that
```
Gatling is a highly capable load testing tool. It is designed for ease of use, maintainability and high performance.

Out of the box, Gatling comes with excellent support of the HTTP protocol that makes it a tool of choice for load testing any HTTP server.
```

Since JustinDB's default protocol communication is HTTP this makes whole testing environment even
more pleasurable to work with.

Gatling also comes with great reports which allows us to reason better about system behavior and its capabilities.

## Assumptions
This project assume there is already running JustinDB cluster with the following properties:

- cluster consists of 5 physical nodes (e.g. JVM instance) with open HTTP ports: 9000, 9001, 9002, 9003, 9004
- every single data is replicated to 3 distinct physical nodes