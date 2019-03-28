
mvn archetype:generate

выведет все типы проектов
для начала фильтруем по webapp :
1. 
2.

мой выбор
 (webapp) многавато
 (javaee7) -> Archetype for a web application using Java EE 7. (был номер 8)

собрать mvn package

------------
используется 
wildfly-maven-plugin
сервер приложений должен быть запущен.
--
поскольку есть JBOSS_HOME
standalone.sh
Ожидаем, когда сервер стартует. Нам напишут, что он started in и укажут время

mvn clean package wildfly:deploy

