FROM java:8

# Add Maintainer Info
LABEL maintainer="se@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp


VOLUME /home/server
COPY   . / /home/server/
WORKDIR /home/server

#чтобы обновить его время модификации (по умолчанию Docker создает все файлы-контейнеры в «неизмененном» состоянии)
RUN sh -c 'touch app.jar'



# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]
