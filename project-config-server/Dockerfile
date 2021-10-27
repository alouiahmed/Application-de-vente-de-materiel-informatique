FROM java:8
#VOLUME /tmp
EXPOSE 8888
ADD /target/project-config-server-0.0.1-SNAPSHOT.jar config-server.jar
# Default active docker profile
#ENV DEFAULT_PROGRAM_ARGS --spring.profiles.active=docker
ENTRYPOINT ["java", "-jar", "config-server.jar"]