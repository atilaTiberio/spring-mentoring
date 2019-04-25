<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <link href="css/jquery-ui.css" rel="stylesheet">
    <link href="css/jquery-ui.structure.css" rel="stylesheet">
    <link href="css/jquery-ui.theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>

</head>
<body>

<table class="w3-table w3-striped w3-border">
    <tr><th>Employee no</th><th>birthdate</th><th>firstname</th><th>lastName</th><th>gender</th><th>hireDate</th></tr>
    <tr><td>${employee.empNo}</td><td>${employee.birthDate}</td><td>${employee.firstName}</td><td>${employee.lastName}</td><td>${employee.gender}</td><td>${employee.hireDate}</td></tr>
</table>

<h3>Salary history</h3>

<div id="accordion">

<c:forEach var="ite" items="${employee.salariesByEmpNo}" >
    <h3>Salary $ ${ite.salary}</h3>
    <div> From: ${ite.fromDate} To: ${ite.toDate}</div>

</c:forEach>
</div>





    <script>

        $( "#accordion" ).accordion();


    </script>

</body>
</html>