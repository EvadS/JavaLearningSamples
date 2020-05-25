#Gradle multi module project 

### download gradle 
```bash
gradle.bat wrapper 
```
## Multi modules 
 Our **settings.gradle** file looks as follows:
 ```groovy
 include 'app'
 include 'core'
```
## Show project projects  
```bash
gradle projects
```

```
Root project
------------------------------------------------------------
Root project 'Sceleton'
+--- Project ':app'
\--- Project ':core'
----------------------------------------------------
 ```
where
 * app is java application with main () and logger as a dependency
 * core is lib project 

 ##  subprojects - dublicate should be removed 
 If we want to add common configuration to the subprojects of our
  root project, we have to add the following snippet to the build.gradl
  e file of our root project:
 
 ```groovy
 subprojects {
     //Add common configuration here
 }
```
 
 ## build projects 
 ```bash
    gradle clean build  
```
## build jar with **dependencies** 
```bash
    gradle fatJar 
```

## Run 
```bash
    java -jar build/libs/app-all.jar
```