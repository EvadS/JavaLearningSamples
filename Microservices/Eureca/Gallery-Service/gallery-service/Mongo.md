
#Mongo db Settings 


[Install MongoDB Community Edition on Ubuntu](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)


### Start MongoDB.
``` sudo service mongod start ```
### запуск консоли 
``` mongo ```
### Verify that MongoDB has started successfully
``` sudo service mongod status ```
### Mongodb user management:
###roles list:
* read
* readWrite
* dbAdmin
* userAdmin
* clusterAdmin
* readAnyDatabase
* readWriteAnyDatabase
* userAdminAnyDatabase
* dbAdminAnyDatabase

### create user:
```db.createUser(
{
    user: "evad",
    pwd: "31323334",
    roles: [ "root" ]
})
```
либо 
```
db.createUser({ user: "evad",
  pwd: "pass",
  roles: [
    { role: "dbAdmin", db: "database" } 
  ]
})
```

###  Создать базу 
```use gallerydb ```
### список баз данных 
``` show databases ```

### view users:
db.getUsers();

## intelij idea  ->  Mongo Explorer 
Authentication - Auth mechnizsm Scram-SHA-1 



