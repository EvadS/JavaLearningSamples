# Getting Started


## Run 

```bash
 gradle bootRun
```


/swagger-ui.html



//
**securedEnabled**: It enables the @Secured annotation using which you can protect your controller/service methods like so -

@Secured("ROLE_ADMIN")
public User getAllUsers() {}

@Secured({"ROLE_USER", "ROLE_ADMIN"})
public User getUser(Long id) {}

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
public boolean isUsernameAvailable() {}

//------------
POST
http://localhost:8000/api/polls

http://localhost:8000/api/polls/1