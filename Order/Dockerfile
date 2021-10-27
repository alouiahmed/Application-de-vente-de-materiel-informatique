FROM java:8
EXPOSE 8084
ADD target/Order-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java","-jar","order-service.jar"]