#!/usr/bin/env sh

/usr/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Xmx256m -Xss512k -XX:MetaspaceSize=100m -jar /apps/app.jar

