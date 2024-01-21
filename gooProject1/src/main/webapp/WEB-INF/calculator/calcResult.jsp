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
    <title>계산기 어플리케이션 : 결과 페이지</title>
</head>
<body>
    <h1>name : ${param.name}</h1>
    <h2>email : ${param.email}</h2>
    <h3>firstNumber : ${param.num1}</h3>
    <h3>SecondNumber : ${param.num2}</h3>

    <h1>SUM : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)} </h1>
    <%-- EL은 출력이 문자형이다. --%>
</body>
</html>
