#Gradle base 

## Task
The **assemble** task compiles the source code of our application and packages it to a jar file. This task doesn’t run the unit tests.
The **build** task performs a full build of the project.
The **clean** task deletes the build directory.
The **compileJava** task compiles the source code of our application.

### All tasks 
``` bash
gradle tasks
```

step 1
apply plugin: 'java'
 
jar {
    manifest {
        attributes 'Main-Class': 'net.petrikainulainen.gradle.HelloWorld'
    }
}
-------------------------
## Subprojects 
   command lists the subprojects (app and core) of our root project. 
 ``` bash
gradle projects
```


use specify gradle version


```bash
 gradle.bat wrapper --gradle-version 6.4.1
```