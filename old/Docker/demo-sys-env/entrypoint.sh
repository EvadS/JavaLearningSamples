#!/usr/bin/env sh

echo "HELLO WOLRD"

cd apps
ls -la
cd ..

#/usr/bin/java  -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Xmx256m -Xss512k -XX:MetaspaceSize=100m -jar /apps/app.jar

/usr/bin/java   -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005  -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar   /apps/app.jar