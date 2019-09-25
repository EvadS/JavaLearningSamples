
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="im@gmail.com"

RUN mkdir -p /app/logs/
RUN mkdir -p /app/

# Add a volume pointing to /tmp
VOLUME /tmp


# Make port 10000 available to the world outside this container
EXPOSE 10000

# The application's jar file
ARG JAR_FILE=target/app.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} app.jar
ADD target/app.jar /app/app.jar

# Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar ","/app.jar"]

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]