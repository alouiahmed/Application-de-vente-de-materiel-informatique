FROM java:8
EXPOSE 8762
ADD /target/gateway-0.0.1-SNAPSHOT.war gateway.jar
ENTRYPOINT ["java", "-jar", "gateway.jar"]