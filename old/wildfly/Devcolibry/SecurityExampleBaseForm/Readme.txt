Реализация с помощью сервера приложений

Здесь используется стандартная форма ввода данных для аутентификации

в web.xml
--
<login-config>
        <auth-method>BASIC</auth-method>
</login-config>
---
для пункта 2.4 :
<security-role>
        <role-name>MANAGER</role-name>
</security-role>


2. Настройка сервера приложений
 Теперь добавим пользователя, у которого будет право на просмотр скрытой информации.
 Для этого используем консольное приложение которое находиться в директории
  bin/add-user.sh (Linux),
  bin/add-user.bat (Windows).

2.1  b - Application user
2.2  user : demouser
2.3  pwd  : 123456
2.4  What group do you want this user to belong to : MANAGER

3. mvn clean install