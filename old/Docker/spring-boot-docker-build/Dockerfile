
#FROM openjdk:8-jdk-alpine
#
## Add Maintainer Info
#LABEL maintainer="im@gmail.com"
#
#RUN mkdir -p /app/logs/
#RUN mkdir -p /app/
#
## Add a volume pointing to /tmp
#VOLUME /tmp
#
#
## Make port 10000 available to the world outside this container
#EXPOSE 10000
#
## The application's jar file
#ARG JAR_FILE=target/app.jar
#
## Add the application's jar to the container
##ADD ${JAR_FILE} app.jar
#ADD target/app.jar /app/app.jar
#
## Run the jar file
##ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar ","/app.jar"]
#
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]

# step 2
#FROM openjdk:8-jdk-alpine
#COPY ./target/app.jar /usr/src/hola/
#WORKDIR /usr/src/hola
#EXPOSE 10001
#CMD ["java", "-jar", "app.jar"]

# maven version for continius iintegration
#FROM maven:3.5.4-jdk-10-slim
#WORKDIR /usr/src/java-code
#COPY . /usr/src/java-code/
#RUN mvn package
#
#WORKDIR /usr/src/java-app
#RUN cp /usr/src/java-code/target/*.jar ./app.jar
#EXPOSE 8080
## mvn version 1
#CMD ["java", "-jar", "app.jar"]

#TODO: USE JAVA NEED USE MVN

ENV SPRING_PROFILES_ACTIVE_CONTAINER=dev

FROM  openjdk:8-jdk-alpine
ADD target/app.jar rest-api.jar
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/rest-api.jar"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/rest-api.jar"]
