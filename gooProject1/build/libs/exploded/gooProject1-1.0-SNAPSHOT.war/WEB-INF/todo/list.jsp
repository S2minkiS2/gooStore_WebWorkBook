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
    <title>todoList</title>
</head>
<body>
    <h1>List 페이지</h1>

    ${list}

    <h3>지시자 선언으로 JSTL, c:forEach 사용</h3>
    <ul>
        <li>var : EL에서 사용될 변수 이름</li>
        <li>items : 불러올(넘겨받은) 컬렉션</li>
    </ul>

    <ul>
        <c:forEach var="dto" items="${list}">
        <li>
            ${dto}
        </li>
        </c:forEach>
    </ul>

    <h3>EL로 첫번째 객체 요소만 호출하기 : 자동 get() 사용</h3>
    tno = ${list[0].tno} <br>
    title = ${list[0].title} <br>

    <h3>begin/end 이용해보기 (begin="1", end="5")</h3>
    <ul>
        <c:forEach var="number" begin="0" end="5">
            <li>숫자 ${number}</li>
        </c:forEach>
    </ul>

    <h3>c:if 그리고 c:choose 제어문</h3>
    list.size()는?
    <br>

    <c:if test="${list.size() % 2 == 0}">
        짝수
    </c:if>
    <c:if test="${list.size() % 2 != 0}">
        홀수
    </c:if>

    <br>
<%--    c:if를 c:choose로 바꿔보기--%>
    <c:choose>
        <c:when test="${list.size() % 2 == 0}">
            짝수
        </c:when>
        <c:when test="${list.size() % 2 != 0}">
            홀수
        </c:when>
    </c:choose>

    <h3>c:set 새로운 변수 만들기</h3>
    <c:set var="myName" value="RaphaelShin"/>
    변수 myName의 값 = ${myName}



</body>
</html>
