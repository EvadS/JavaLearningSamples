# Getting Started

### Reference Documentation

```
<springProfile name="dev | staging">
	<!-- configuration to be enabled when the "dev" or "staging" profiles are active --
</springProfile>
```

```
mvn spring-boot:run 
  -Dspring-boot.run.arguments=--logging.level.org.springframework=TRACE,--logging.level.com.baeldung=TRACE
  ```
  
  <?xml version="1.0" encoding="UTF-8"?>
  <configuration>
  
      <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
          <encoder>
              <pattern>
                  %d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}.%M - %msg%n
              </pattern>
          </encoder>
      </appender>
  
      <root level="info">
          <appender-ref ref="STDOUT"/>
      </root>
  
  
  
  </configuration>
  
  
  https://www.codingame.com/playgrounds/4497/configuring-logback-with-spring-boot
  
  A Guide to Logging in Spring Boot - HowToDoInJava