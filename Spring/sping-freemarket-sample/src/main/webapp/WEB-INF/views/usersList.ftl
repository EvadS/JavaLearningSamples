<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>



</head>
<body class="container">

<#include "templates/header.ftl"/>

<h2>users list</h2>
<div class="row">
    <table class="table">
        <tr>
            <th>id</th>
            <th>name</th.Glory - Feel The Fire>
            <th>email</th>
            <th>age</th>
        </tr>
    <#list users as user>
    <tr>
        <td><a href="/user/${user.id}">${user.id}</a></td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.age}</td>
        <td><a href="/delete/${user.id}">Delete</a></td>
        <td><a href="/update/${user.id}">Update</a></td>
    </tr>

    </#list>
    </table>
</div>


<div class="row">
    <a href="/addUser">Create user</a>
</div>

</body>
</html>