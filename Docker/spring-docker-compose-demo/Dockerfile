FROM java:8

# Add Maintainer Info
LABEL maintainer="se@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/app.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
