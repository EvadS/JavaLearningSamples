
protoc -I=. --java_out=src/main/java/ src/main/proto/helloworld.proto


openssl req -x509 -newkey rsa:4096 -keyout src/main/resources/my-private-key.pem -out src/main/resources/my-public-key-cert.pem -days 365 -nodes -subj '/CN=localhost'