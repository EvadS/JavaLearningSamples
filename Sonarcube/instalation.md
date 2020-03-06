# Sonar cude how to install on ubuntu 

```bash 
./sonar.sh start
```
* user : sonar
* pwd  : 123456
--------------------------------
sudo tail -f /opt/sonarqube/logs/sonar.log
------------------------

 default administrator account username and password as admin / admin
 
 --- 
 token 
 evad 
 2d162d130ff570affe461033972cb62b8ec07e6a
 ------
 mvn sonar:sonar \
   -Dsonar.host.url=http://localhost:9000 \
   -Dsonar.login=2d162d130ff570affe461033972cb62b8ec07e6a
   ------

mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=2d162d130ff570affe461033972cb62b8ec07e6a

## Use on maven 

```xml
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.sonarsource.scanner.maven</groupId>
                <artifactId>sonar-maven-plugin</artifactId>
                <version>3.4.0.905</version>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```

### execute 
```bash
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 
  -Dsonar.login=the-generated-token
```

### sample 
https://github.com/SonarSource/sonar-scanning-examples/tree/master/sonarqube-scanner-maven/maven-basic

## Install Java
SonarQube is written in Java language, so you will need to install Java to your system. First, add the Java repository with the following command:
```bash
sudo add-apt-repository ppa:webupd8team/java
```

Next, update the repository and install Java with the following command:
```bash
sudo apt-get update -y
sudo apt-get install oracle-java8-installer -y
```
Once the Java is installed, check the Java version using the following command:
```bash
java -version
```
Output:

openjdk version "10.0.2" 2018-07-17
OpenJDK Runtime Environment (build 10.0.2+13-Ubuntu-1ubuntu0.18.04.3)
OpenJDK 64-Bit Server VM (build 10.0.2+13-Ubuntu-1ubuntu0.18.04.3, mixed mode)

# Install and Configure PostgreSQL
## DELETE postgress 

###Step 1: List the PostgreSQL Packages
Use the dpkg tool to list packages pertaining to the PostgreSQL setup.
```bash
dpkg -l | grep postgres
```

### Step 2: Delete the PostgreSQL Packages
```bash
sudo apt-get --purge remove pgdg-keyring postgresql-10 postgresql-client-10 postgresql-client-common postgresql-common
```

### Step 3:  Verifying the Deletion of PostgreSQL

```bash
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
```
```bash
sudo apt-get update -y
sudo apt-get install postgresql postgresql-contrib
```
check the status of PostgreSQL with the following command:
```bash
sudo systemctl status postgresql
```
Next, switch to the postgres user with the following command:
```bash
su - postgres
```

------------------------------------------
## Install
By default, the latest version of PostgreSQL is not available in the Ubuntu 18.04 default repository. So you will need to add the PostgreSQL repository to your system.

You can do this with the following command:
```bash
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
```
Next, update the repository and install PostgreSQL with the following command:
```bash
sudo apt-get update -y
sudo apt-get install postgresql postgresql-contrib
```
Once the installation is completed, check the status of PostgreSQL with the following command:

```bash
sudo systemctl status postgresql
sudo systemctl enable postgresql
```

```bash
 sudo -u postgres psql
```

```bash
createuser sonar
```
```bash
psql
```

ALTER USER sonar WITH ENCRYPTED password 'password';
CREATE DATABASE sonar OWNER sonar;

-----------------------------------
sudo mkdir /opt/sonar


sudo chown -R evgeniyskiba:evgeniyskiba /opt/sonar


Install SonarQube

Step 1: Navigate to directory /opt/sonar that you created for SonarQube.

# cd /opt/sonar
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-6.7.6.zip

unzip 
## Create and Configure Database
Step 1: Change the password for postgres user and switch to postgres user. To change password execute the command.
```bash 
 sudo passwd postgres
```
Now execute the command below to switch to postgres user.
```bash
su - postgres
```
Step 2: Now create new user by executing the following command.
```bash 
 createuser sqube
```
Step 3: Now open Postgres shell for executing queries. 
To open, execute the command.
```bash 
 psql
```
Step 4: Execute the following queries. First query will create password for user, second query will create database and assign database privileges to user and the third query will exit from MySQL server.
```bash
ALTER USER sqube WITH ENCRYPTED password '654321Ab';
CREATE DATABASE sqube OWNER sqube;
\q
```
Step 5: Execute the following command to switch back to sudo user.
``` bash 
# exit
```
-------------------------------------

## Configure SonarQube
configure username and password for database and tell about driver to be used by SonarQube for database connection
```bash
cd /opt/sonar
sudo nano sonarqube-6.7.6/conf/sonar.properties

sudo gedit sonarqube-6.7.6/conf/sonar.properties
```

sonar.jdbc.username=sqube
sonar.jdbc.password=654321Ab


sonar.jdbc.url
sonar.web.host

After making changes, press Ctrl + X, type Y and hit Enter key to save the settings


###Configure Reverse Proxy for SonarQube 
Configure Reverse Proxy for SonarQube
SonarQube listens to port 9000 by default on localhost. To access it via standard HTTP 80 port, you will need to setup reverse proxy.

Follow the steps below for configurations.

Try installing Apache first.
```bash
sudo apt-get install apache2
```
Step 1: Enable proxy mode by executing commands.
```bash
 sudo a2enmod proxy
 sudo a2enmod proxy_http
``` 

Step 2: Proceed to set up a virtual host. Execute the following command to proceed towards creation of virtual host.

```bash
 sudo nano /etc/apache2/sites-available/softpedia.xyz.conf
```

Step 3: Add the following text in opened file, then press Ctrl + X, type Y and hit Enter key to save the file.


```xml
ProxyRequests Off
ProxyPreserveHost On
<VirtualHost *:80>
    ServerName www.softpedia.xyz
    ServerAdmin admin@softpedia.xyz
    ProxyPreserveHost On
    ProxyPass / http://localhost:9000/
    ProxyPassReverse / http://www.softpedia.xyz/

</VirtualHost>
```
Step 4: Now you will have to enable your newly created virtual host and then start and enable your apache server. To do so, execute the command.
```bash
 sudo a2ensite softpedia.xyz.conf
 sudo systemctl start apache2
 sudo systemctl enable apache2
```
Step 5: Add a non-root user named sonar.

```bash
sudo adduser sonar
``` 
Assign permissions to sonar user for directory /opt/sonar
```bash
 sudo chown -R sonar:sonar /opt/sonar
```
Now open the bash file to assign RUN_AS_USER.

```bash
 sudo nano /opt/sonar/sonarqube-6.7.8/bin/linux-x86-64/sonar.sh
```

Locate RUN_AS_USER in opened file, remove # sign to uncomment the line and add value as sonar, then press Ctrl + X, type Y and hit Enter key to save the file.

To **start SonarQube **, execute the command below.

```bash 
opt/sonar/sonarqube-6.7.8/bin/linux-x86-64/sonar.sh start
```
To start SonarQube, execute the command below.

# /opt/sonar/sonarqube-6.7.8/bin/linux-x86-64/sonar.sh stop
Here you go! 


## Additional 
change user pwd in ubuntu 
```bash
 sudo passwd <user_name>
```
