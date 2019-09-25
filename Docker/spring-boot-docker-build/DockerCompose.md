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