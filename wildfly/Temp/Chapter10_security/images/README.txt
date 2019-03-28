Setting up your first login module

application-users.properties: This contains the list of usernames and passwords
application-roles.properties: This contains the mapping between the users and
their roles

add a new user via the add-user.sh/add-user.bat script

Once the user is added, the application-users.properties file will contain the
username and the MD5 encoding of the password, shown as follows:
demouser=9e21f32c593ef5248e7d6b2aab28717b

Conversely, the application-roles.properties file will contain the roles granted to the
demouser username once logged in:
demouser=Manager