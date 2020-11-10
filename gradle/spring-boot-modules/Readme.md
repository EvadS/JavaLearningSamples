# Base multi module sceleton 
Require gradle 6 
Запускаемый поект application, который в качестве билиблиотечного использует library
----
``` bash 
 gradle projects
``` 

```shell

> Task :projects

------------------------------------------------------------
Root project
------------------------------------------------------------

Root project 'spring-boot-modules'
+--- Project ':application'
\--- Project ':library'
```

2 спринговых проекта 
app зависит от libary

## настройка

в settings.gradle
указываем базовый (рут ) проекта и модули

rootProject.name = 'spring-boot-modules'

include 'library'
include 'application'
----------------------------

в каждом модуле  в settings-gradle 
указываем
 rootProject.name = 'spring-boot-modules'
 явно указываем что проект не спринг приложение 
 
 bootJar {
	enabled = false
}

jar {
	enabled = true
}
 






