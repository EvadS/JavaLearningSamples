FROM openjdk:10-jre-slim
COPY ./target/docker-global-env-0.0.1-SNAPSHOT.jar /usr/src/hola/
WORKDIR /usr/src/hola
EXPOSE 8000
CMD ["java", "-jar", "docker-global-env-0.0.1-SNAPSHOT.jar"]