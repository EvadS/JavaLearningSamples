#FROM java:8
#
## Add Maintainer Info
#LABEL maintainer="se@gmail.com"
#
## Add a volume pointing to /tmp
#VOLUME /tmp
#
#
#VOLUME /home/server
#COPY   . / /home/server/
#WORKDIR /home/server
#
##чтобы обновить его время модификации (по умолчанию Docker создает все файлы-контейнеры в «неизмененном» состоянии)
#RUN sh -c 'touch app.jar'
#
## Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]


FROM openjdk:8-jdk-alpine

RUN ls -lh /

ARG JAR_FILE

RUN mkdir -p /apps
COPY ./target/${JAR_FILE} /apps/app.jar
COPY ./entrypoint.sh /apps/entrypoint.sh

CMD echo Hello world
RUN ls -lh /

RUN chmod +x /apps/entrypoint.sh
CMD ["/apps/entrypoint.sh"]