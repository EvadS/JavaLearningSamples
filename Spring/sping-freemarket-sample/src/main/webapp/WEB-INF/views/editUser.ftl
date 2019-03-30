<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update user page</title>
</head>
<body class="container">
<#include "templates/header.ftl"/>
<form name="user" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Name" type="text" name="id" value="${user.id}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>Email</p>
    <input title="Email" type="text" name="email" value="${user.email}">
    <p>Age</p>
    <input title="Age" type="text" name="age" value="${user.age}">
    <div class="row">
        <input type="submit" value="OK">
    </div>
</form>

</body>
</html>