In this tutorial I'll explain how to:

* Get an SSL certificate
    - Generate a self-signed SSL certificate
    - Use an existing SSL certificate
* Enable HTTPS in Spring Boot
* Redirect HTTP requests to HTTPS
* Distribute the SSL certificate to clients.

**I**'ll use the following technologies and tools:

* Java JDK 8 (1.8.0_152)
* Spring Boot 1.5.8.RELEASE
* keytool
* Spring Security 4.2.3.RELEASE (not required)

--------------
 if you have the JDK installed, you should already have keytool available
` _keytool --help_`

step 1 
generate public and private key 

Use an existing SSL certificate

keytool -import -alias tomcat -file miner_cer_X509.cer -keystore keystore.p12 -storepass password


