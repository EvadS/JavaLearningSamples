Базовый пример того как работать с Eureca Discovery 

-Server 
-client 
-feight client 

Server : http://localhost:8761 

Без Feign нам пришлось бы автоматически подключать экземпляр EurekaClient к нашему контроллеру, с помощью которого мы могли бы получать служебную информацию по служебному имени в качестве объекта приложения.

@Autowired
private EurekaClient eurekaClient;
 
public void doRequest() {
    Application application =
      eurekaClient.getApplication("spring-cloud-eureka-client");
    InstanceInfo instanceInfo = application.getInstances().get(0);
    String hostname = instanceInfo.getHostName();
    int port = instanceInfo.getPort();
    // ...
}

Feign - библиотеки для создания декларативных REST-клиентов
https://www.shortn0tes.com/2018/01/netflix-microservices-part-1-feign-ru.html
