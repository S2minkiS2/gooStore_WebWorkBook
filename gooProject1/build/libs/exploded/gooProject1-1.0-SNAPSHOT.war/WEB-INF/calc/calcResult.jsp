<%--
  Created by IntelliJ IDEA.
  User: smk
  Date: 12/18/23
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>firstNumber : ${param.number1}</h1>
    <h1>SecondNumber : ${param.number2}</h1>

    <h1>SUM : ${Integer.parseInt(param.number1) + Integer.parseInt(param.number2)} </h1>
    <%-- EL은 출력이 문자형이다. --%>
</body>
</html>
