
FROM java:8

MAINTAINER  Author Name <evad@email.com>


#Set app home folder
ENV APP_HOME /app


#Create base app folder
RUN mkdir $APP_HOME

#Create folder with application logs
RUN mkdir $APP_HOME/logs

VOLUME $APP_HOME/logs
COPY ./ /$APP_HOME

WORKDIR $APP_HOME

EXPOSE 8080

#FOR Test

ADD /target/spring-boot-docker-demo.jar  $APP_NOME/app.jar

RUN sh -c 'touch $APP_NOME/app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]