#Dokerrise mySQL

## step 1. 
### Подключаем через композ
```
services:
    db:
        image: mysql
        volumes:
            - "./.data/db:/var/lib/mysql"
        environment:
            MYSQL_ROOT_PASSWORD: root
            MYSQL_DATABASE: mydb
            MYSQL_USER: user
            MYSQL_PASSWORD: pass
        ports:
            42333:3306
```
------------------------------------------------------------------
### Подключение через Dokerfile
>В нашем случае
``` docker run -d -p 13306:3306 --name=docker-mysq2 --env="MYSQL_ROOT_PASSWORD=123456" --env="MYSQL_PASSWORD=31323334" --env="MYSQL_DATABASE=book_manager" --env="MYSQL_USER=evad" mysql  ```

-------------------------------------------------------------------
## step 2 
Перезапустите Docker-контейнер и выполните следующие команды, чтобы перейти к оболочке bash в MySQL-контейнере.

``` docker ps ```
``` docker exec -it <mysql container name> /bin/bash ```

>В нашем случае
``` docker exec -it docker-mysql  /bin/bash ```

## step 3
Внутри контейнера для подключения к типу командной строки mysql,

``` mysql -u root -p ```

Используйте MYSQL_ROOT_PASSWORD, как указано в docker-compose.yml. Выполните следующие команды, чтобы создать нового пользователя. В нашем случае  

``` mysql -u root -p 123456```

Используйте MYSQL_ROOT_PASSWORD, как указано в docker-compose.yml. Выполните следующие команды, чтобы создать нового пользователя.

``` create user 'user'@'%' identified by 'pass'; ```
*
```  grant all privileges on *.* to 'user'@'%' with grant option; ```
*
``` flush privileges;```

>В нашем случае
----------------------------------------------------
CREATE USER 'evad'@'%' IDENTIFIED BY '123456';
grant all privileges on *.* to 'evad'@'%' with grant option
flush privileges;