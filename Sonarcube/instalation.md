
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
```

Next, switch to the postgres user with the following command:
```bash
su - postgres
```

