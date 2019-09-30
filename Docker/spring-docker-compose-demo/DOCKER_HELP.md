# Getting Started

## шаг 1 
Добавили базовый докер файл и пробуем запустить  
## шаг 2
создаем image c именем my_fdocker_img 
точка в конце означает что мы хотим взять докер файл из текущей директории
``` docker build -t my_fdocker_img . ```
** 
``` Dockerfile.mvn_alpine ```
**
``` docker build -t my_fdocker_img -f Dockerfile.mvn . ```

посписок текущих имеджей можем просмотреть

``` docker images ``` 
## шаг 3 
после того как имадж создан можем запусить его в контейнере 
слева порт во внешний мир справа внутренний порт 

``` docker run -p 9009:9000 -t my_fdocker_img ```

для дебага 

``` docker run -p 9009:9000 -t my_fdocker_img ```
### c указанием профиля

``` docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 9005:9000 -t my_fdocker_img ```


запустить баш консоль в РАБОЧЕМ контейнере(не получится если сервис рестартится )
 docker exec -it  [имя контейнера] sh 

 пример 

 docker exec -it   flamboyant_engelbart  sh
 


### после того как убедились что все работает 
docker ps 

нашли нужный контейнер 
docker stop [имя ]
docker rm [container_name]

docker images ps 
docker rmi [имя контейнера ]

***************************

 Kill all running containers.
``` docker container kill $(docker ps -q) ``` 

Delete all containers that are not running.
``` docker container rm $(docker ps -a -q) ```

Delete the specified image. 
``` docker image rm my_image ```



### последний шаг 


docker container run -i -t -p 1000:8000 --rm my_image

Замечания 

sudo service postgresql stop
sudo service postgresql start

## docker hub 
Login with your Docker Id

