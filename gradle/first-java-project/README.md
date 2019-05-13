This is an example application of my blog post:

* [Getting Started with Gradle: Our First Java Project](http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-our-first-java-project/)

You can package the application by running one of the following commands at command prompt:

    gradle assemble (runs only the tasks required to create the jar file)
    gradle build (runs the full build)

Both commands create a jar file called _first-java-project.jar_ to the _build/libs_ directory.
    
You can run the application by running the following command at command prompt:

    java -jar first-java-project.jar


--------------------------
Getting Started with Gradle: Creating a Runnable Binary Distribution
You can package the application by running one of the following commands at command prompt:

gradle assemble (runs only the tasks required to create the jar file)
gradle build (runs the full build)
You can can run the application by the following command at command prompt:

gradle run
You create runnable binary distribution by running one of the following commands at command prompt:

gradle distZip (creates a runnable binary distribution that is packaged into a .zip file)
gradle distTar (creates a runnable binary distribution that is packaged into a .tar file)
Both of the commands creates the packaged binary distribution to the build/distributions directory.

You can run the application by following these steps:

Unpackage the binary distribution.
Run the application by invoking the correct startup script found from the bin directory.
