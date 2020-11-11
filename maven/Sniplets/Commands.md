
console generator 

 mvn archetype:generate -DgroupId=com.example.grpc \
 -DartifactId=grpc-hello-server \
 -DarchetypeArtifactId=maven-archetype-quickstart \
 -DinteractiveMode=false

----------------------
## Если не задан main class 
собираем 
```bash
mvn compile
```
запустить проект

```bash
mvn exec:java -Dexec.mainClass="com.app.HelloWorld"
```

Задать параметры командной строки 
```xml
<plugin>
   <groupId>org.codehaus.mojo</groupId>
   <artifactId>exec-maven-plugin</artifactId>
   <version>1.1.1</version>
   <executions>
      <execution>
         <phase>test</phase>
         <goals>
            <goal>java</goal>
         </goals>
         <configuration>
            <mainClass>com.app.HelloWorld</mainClass>
            <arguments>
               <argument>arg0</argument>
               <argument>arg1</argument>
            </arguments>
         </configuration>
      </execution>
   </executions>
</plugin>
```

 плагин versions-maven-plugin

 mvn versions:display-dependency-updates
 
