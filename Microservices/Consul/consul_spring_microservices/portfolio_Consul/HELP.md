# Getting Started

--- 
 В этой статье мы создадим простое приложение для управления портфелем на фондовом рынке, которое клиенты могут вызывать для оценки своего портфеля акций (биржевые тикеры и величины). Микросервис портфеля будет извлекать портфель клиента, отправлять его в микросервис ценообразования для применения последних цен, а затем возвращать полностью оцененный и субтотализированный портфель, демонстрируя все это посредством rest-вызова.

---

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-jersey)
* Hashicorp  [Consul](www.consul.io/downloads.html)  

### Consul 

запусктие Consul в режиме dev:

``` consul agent -dev ```

 убедиться, что он запущен, перейдите в браузер и получите доступ к интерфейсу консула http://localhost:8500.
---
``` mvn spring-boot:run ```

### step 2

Теперь мы должны увидеть этот сервис в Consul, поэтому давайте вернемся к нашему браузеру, загрузите 
``` http://localhost:8500/ui/#/dc1/services  `` `(или обновите, если вы уже там).

sudo kill -9 `sudo lsof -t -i:57116`