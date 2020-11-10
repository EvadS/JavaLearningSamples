docker-compose --version


* ``` docker-compose up ```
* or
* ```$ docker-compose up -d ```

-d for “detached” mode


$ docker-compose stop


///////////////////////////////////////////
To see running containers, run 
```docker container list -a```


 ##docker container inspect  
 delete the container 
 * ```docker container rm my_container``` — Delete one or more containers.
 * ```docker container rm $(docker ps -a -q)``` — Delete all containers that are not running
 
 
 
 ------------------------------------
 docker build -t hola-manual-build .
 	
docker run -p 8000:8080 hola-manual-build
 
 
 docker-compose up
 
 docker-compose build, which will build all the services but not run them.
 docker-compose up --build, which will build all the services and then run them
 
 
 /// step one 
 docker-compose build
 // step 2
 docker-compose up
 
 
 Accessing the source code
 
 -----------------------------------------
 docker-compose --file docker-compose-dev.yml up --build
 
 пробуем перейти на профили 
 docker run -d -p 10005:10000 -e "SPRING_PROFILES_ACTIVE=dev" --name rest-api dockerImage:latest