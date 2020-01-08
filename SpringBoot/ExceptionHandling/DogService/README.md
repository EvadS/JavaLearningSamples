#dog-service

## This is a Spring Boot backed Dogs Service which provides default CRUD operations for DOG

server port :  8080

## Technologies 
* Spring Boot 
* gradle 

## Rest api 
###  Get All Dogs

Open the browser and execute (GET)
http://localhost:8080/dogs
----
### Get Dog by Id
http://localhost:8080/dogs/3
{
   "id":3,
   "name":"Brinkley",
   "age":8
}

### Add New Dog

curl -X POST \
  http://localhost:8080/dogs \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: c6813aea-146c-49cd-9eba-1370aad4bff9' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 6,
    "name": "Hooch",
    "age": 11
  }'
  
### Delete a Dog
curl -X DELETE \
  http://localhost:8080/dogs/5 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: b4b93304-7ee7-45c2-917b-c3bc2985a250' \
  -H 'cache-control: no-cache'


### Troubleshouting 

Error:(15, 29) java: cannot find symbol
  symbol:   method of(int,java.lang.String,int)
  location: class com.se.sample.repo.Dog
  
  
  File -> settings -> [buuild execution ...] -> compiler -> Annotation processors -> Enable annotation processor
  

