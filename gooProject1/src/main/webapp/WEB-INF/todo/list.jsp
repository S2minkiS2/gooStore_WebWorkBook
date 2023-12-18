<%--
  Created by IntelliJ IDEA.
  User: smk
  Date: 12/16/23
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${list}

    <ul>
        <c:forEach var="dto" items="${list}">
        <li>
            ${dto}
        </li>
        </c:forEach>
    </ul>

</body>
</html>
