
simple test project for demostrate working with spring boot and my sql data base
--
Spring Initializer -можно генерить проект в консоле
$ spring help init
spring init --name=blog-sample --dependencies=web,data-jpa,mysql,devtools,thymeleaf --package-name=com.blogsample BlogSample

-- как альтернатива http://start.spring.io
-----------------------------

Предполагается что база  notes_app создана

## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:3306/notes_app?useSSL=false
spring.datasource.username = root
spring.datasource.password = 123456

$ mvn spring-boot:run
--
$ gradle

-----

/swagger-ui.html
http://localhost:8080/swagger-ui.html#/note-controller