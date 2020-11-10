<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user page</title>
</head>
<body class="container">
<#include "templates/header.ftl"/>
<form name="user" action="/addUser" method="post" class="form-vertical">
    <p>Name</p>
    <input title="Name" type="text" name="name">
    <p>Email</p>
    <input title="Email" type="text" name="email">
    <p>Age</p>
    <input title="Age" type="text" name="age">
    <div class="row">
    <input type="submit" value="OK">
    </div>
</form>

</body>
</html>