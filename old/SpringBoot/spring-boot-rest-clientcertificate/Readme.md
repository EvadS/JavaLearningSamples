Generating a server CA certificate
Let’s see what has to be done on the server’s side with regards to creating the certificate:

openssl genrsa -aes256 -out serverprivate.key 2048


Generating a server CA certificate
openssl req -x509 -new -nodes -key serverprivate.key -sha256 -days 1024 -out serverCA.crt

keytool -import -file serverCA.crt -alias serverCA -keystore truststore.jks

imports our server CA certificate to our Java truststore. The stored password in this case is changeit.

openssl pkcs12 -export -in serverCA.crt -inkey serverprivate.key -certfile serverCA.crt -out keystore.p12

keytool -importkeystore -srckeystore keystore.p12 -srcstoretype pkcs12 -destkeystore keystore.jks -deststoretype JKS

Generating a client certificate
openssl genrsa -aes256 -out clientprivate.key 2048

openssl req -new -key clientprivate.key -out client.csr

Client sends the CSR to the CA

openssl x509 -req -in client.csr -CA serverCA.crt -CAkey serverprivate.key -CAcreateserial -out client.crt -days 365 -sha256
