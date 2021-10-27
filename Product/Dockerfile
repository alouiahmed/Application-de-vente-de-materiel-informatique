FROM java:8
EXPOSE 8010
ADD target/Product-0.0.1-SNAPSHOT.jar product-service.jar
ENTRYPOINT ["java","-jar","product-service.jar"]