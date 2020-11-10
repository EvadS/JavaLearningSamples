<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User INfo</title>
</head>
<body class="container">
<#include "templates/header.ftl"/>
<h1>User info</h1>
<table class="table">
    <tr>
        <td>Id</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${user.age}</td>
    </tr>
</table>

<br>
<a href="/users">Back</a>
</body>
</html>