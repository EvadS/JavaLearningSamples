
```docker --version```

##Check images: 
```docker images```
#####Check all containers(active and inactive): 
```docker ps -a```
#####Check active containers: 
```docker ps```
#####Check container logs: 
```docker logs <container_id>```
#####Stop container: 
```docker container stop <container_id>images```
#####Remove image:
 ```docker rm <image_id>```
#####Remove container: 
```docker container rm <container_id>```

```docker build . -t spring-docker-01```

Format — `docker build <path> -t <application image name>:<tag version>`

#####Run Docker Image

docker run -p 10001:10001 --name spring-docker-01 -d spring-docker-01


Format — ‘docker run -p <machine_port>:<container_port> — name <Docker_Conainter_Name> -d <Docker_Image_Name>’


```docker stop spring-docker-01```


#####Push image to docker hub needs three simple steps:
* docker login --username <username> --password <password>
* docker tag <image_name> <username>/<your repository on docker hub>
* docker push <username>/<your repository on docker hub>

