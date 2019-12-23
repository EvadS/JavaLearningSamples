### Cтандартные возможности Spring Cloud (Netflix OSS).


#Используемые технологии 
* Eureka Server(User-Service)
* Feign Client (User-Service,RestTemplate, Feign Client,  WebClient)
* Hystrix
* MongoDB 
----------------
* Zuul API Gateway 
* Ribbon
* Load Balancer
* Config Service 
* Config Сlient
* JWT Security
-------------------
* Elastic Search Kibana


### уточнения 

### Компоненты системы 
Eureka Server - Discovery server 
User-Service  - Discovery client 


## Запуск всего этого 
1. Eureka Server      http://localhost:8761 
2. gallery-service    http://localhost:8766
3. user-service       http://localhost:8082
4. zuul-service       http://localhost:8766
5. security-service.  http://localhost:9100

Тестируем:
-------------------------------------
POST
localhost:8766/auth
{
	"username":"admin",
	"password":"admin"
}

При условии что у вас установлено
Content-Type — application/json Accept — application/json

В ответе в Headers вы получите сгенерированный токен.
Скопируйте и вставьте его в Authorization — и выберите там Bearer token

localhost:8766/my-gallery-path/show






##Дополнительные материалы 

* [Spring Cloud Netflix: Hystrix по-русски + Feign Client](https://medium.com/@kirill.sereda/spring-cloud-netflix-hystrix-%D0%BF%D0%BE-%D1%80%D1%83%D1%81%D1%81%D0%BA%D0%B8-e60e91a6770f)

* [статья Reactive](https://medium.com/@kirill.sereda/reactive-programming-reactor-%D0%B8-spring-webflux-3f779953ed45)

* [статья Feign Client](https://medium.com/@kirill.sereda/spring-cloud-netflix-feign-%D0%BF%D0%BE-%D1%80%D1%83%D1%81%D1%81%D0%BA%D0%B8-7b8272e8e110)




запросы на Gallery service 
RestTemplate, Feign Clientи WebClient
user-service будет получать данные из БД через gallery-service. В случае выхода из строя БД или gallery-service мы будем использовать библиотеку Hystrix

Gallery-Service
http://localhost:8081/

https://medium.com/@kirill.sereda/spring-cloud-netflix-microservices-start-project-%D1%81%D0%B5%D1%80%D0%B8%D1%8F-%D1%81%D1%82%D0%B0%D1%82%D0%B5%D0%B9-%D1%87%D0%B0%D1%81%D1%82%D1%8C-1-7a892ad5f16

Запуск проекта.



