#FROM java:8u111-jre-alpine
#

#MAINTAINER vaneetkataria54@gmail.com
#COPY target/demo-sys-env-0.0.1-SNAPSHOT.jar /App.jar
#EXPOSE 8080
#VOLUME /tmp
#
#
#ENTRYPOINT ["java", "-jar" ,  "/App.jar"]


FROM openjdk:8-jdk-alpine

ENV JAVA_OPTS -Djava.security.egd=file:/dev/./urandom
ENV My_JAVA_OPTS -Djava.security.egd=file:/dev/./urandom

ENV APP_HOME /app

EXPOSE 8080
ARG JAR_FILE

RUN mkdir -p /apps

COPY ./target/app.jar /apps/app.jar

COPY ./entrypoint.sh /apps/entrypoint.sh

RUN chmod +x /apps/entrypoint.sh
CMD ["/apps/entrypoint.sh"]