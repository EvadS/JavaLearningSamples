# Getting Started

./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar

### Reference Documentation
For further reference, please consider the following sections:

Собираем образ:

```docker build -t spring-docker-sample . ```

Проверяем:
``` docker images ```

Запускаем работать в бекграунде:


```$ docker run -p 18080:10000 -d spring-docker-sample ```

Проверяем:

```$ docker ps```

Смотрим логи 
```$ docker logs -f {CONTAINER_NAME}```

http://localhost:18080/swagger-ui.html


### debug
//-----------------------------

$ docker build -t  spring-docker-sample . && docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 18080:10000 -p 5005:5005 -t spring-docker-sample

******************************

export RW_DEV=dev

---------------------
docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" --name rest-api dockerImage:latest



