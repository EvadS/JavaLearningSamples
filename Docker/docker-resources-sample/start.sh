#! /bin/bash


java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Djava.security.egd=file:/dev/./urandom -jar   target/app.jar

