руководство минимум для построения jar приложения на maven



Команды без пробелов
mvn compile 

Почистить и подтянуть зависимости в результирующиц jar - ник 
mvn clean compile assembly:single


Запуск 
-jar firstApp-1.0-SNAPSHOT-jar-with-dependencies.jar


Вариант 2 
Полный комплект
mvn package 

does a compile and creates the target directory, including a jar


---- хз 
java -cp target/classes som.se.company.app.App



—
mvn clean --quiet
java -cp target/firstApp-1.0-SNAPSHOT.jar som.se.company.app.App

-- плагин versions-maven-plugin
получаем  последние версии

 mvn versions:display-dependency-updates

 /*
 [INFO] artifact com.google.code.gson:gson: checking for updates from central
 [INFO] artifact junit:junit: checking for updates from central
 [INFO] The following dependencies in Dependencies have newer versions:
 [INFO]   com.google.code.gson:gson ............................. 2.8.0 -> 2.8.5
 */

 результат той же комманды если файл с правилами rules.xml пуст
 [INFO] The following dependencies in Dependencies have newer versions:
 [INFO]   com.google.code.gson:gson ............................. 2.8.0 -> 2.8.5
 [INFO]   junit:junit ............................................. 4.11 -> 4.12
 эм ну вообщем плохой пример но стоит использовать

--
mvn versions:display-plugin-updates

--
запуск без тестов
mvn package -Dskip:test



