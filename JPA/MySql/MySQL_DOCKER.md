create and run an image of the MySQL database

наша база буде крутится на порту 6033

```docker run -d -p 6033:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=book_manager" mysql```
-----------------------------------------------------------------------------
проверяем 

``` docker image ls ```
``` docker container ls  ```
-----------------------------------------------------------------------------
Now we can check by logging in to MySQL.

заходим в контейнер 
 ``` docker exec -it docker-mysql bash; ```

авторизация 
пароль мы указали пир запуске контейнера : root
``` mysql -uroot -p ``` 

текущие базы

``` show databases; ```
-----------------------
Создаем book_manager  за пределами контейнера. простоты эксперимента запускать комманду там 
где лежит book_manager.sql файл


docker exec -i docker-mysql mysql -uroot -proot book_manager <book_manager.sql

--------------------------------------
заходим в контейнер 
docker exec -it  docker-mysql sh 

опять авторизация 
mysql -uroot -p
