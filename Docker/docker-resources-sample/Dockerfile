FROM openjdk:8-jdk

COPY ./ /app

WORKDIR /app
EXPOSE 8087
RUN apt update
RUN apt install maven -y

RUN mvn install package
CMD ./start.sh