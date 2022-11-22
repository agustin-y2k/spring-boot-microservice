# Microservice with Spring Boot

## Documentation

### Service Registration and Discovery

https://spring.io/projects/spring-cloud-netflix

Eureka is a rest service that allows register other microservices. This is very important, is not Eureka that registers the microservices, but the microservices that request to register with Eureka.

When a microservice registered with Eureka starts up, it sends a message to Eureka indicating that it is available. The Eureka server will store the information of all the registered microservices as well as their state.

Ingress on http://localhost:8761 to see Eureka dashboard

<img src="/home/agustin/Documentos/Universidad/ingenieria de software/project-por-partes/11 - dockerize/microservices/docs/discovery-server.jpg"/>

### API Gateway

API Gateway pattern allows to implement a solution to centralize and route all requests from the outside to each microservice, acts as a proxy or single point that routes a request that arrives to the corresponding microservices
https://spring.io/projects/spring-cloud-gateway


<img src="/home/agustin/Documentos/Universidad/ingenieria de software/project-por-partes/11 - dockerize/microservices/docs/api-gateway.jpg"/>


### Authentication

Keycloak

https://www.keycloak.org/documentation

1 - Execute next docker command

    docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:19.0.2 start-dev

2 - Ingress on http://localhost:8181 User: admin Password: admin

3 - Endpoints: http://localhost:8181/realms/spring-boot-microservices-realm/.well-known/openid-configuration


<img src="/home/agustin/Documentos/Universidad/ingenieria de software/project-por-partes/11 - dockerize/microservices/docs/auth.jpg"/>


### Actuator


### Circuit Breaker

https://spring.io/projects/spring-cloud-circuitbreaker

Resilience4J



### Tracing

Sleuth
https://spring.io/projects/spring-cloud-sleuth


Zipkin

1 - Execute next docker command 

    docker run -d -p 9411:9411 openzipkin/zipkin

2 - Ingress on http://localhost:9411/zipkin/

Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures. Features include both the collection and lookup of this data.
https://zipkin.io/

### Kafka

https://developer.confluent.io/quickstart/kafka-docker/

    docker-compose build

    docker-compose up -d

https://spring.io/projects/spring-kafka


