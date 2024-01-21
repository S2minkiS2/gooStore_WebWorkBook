<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hi-servlet">Hi! Servlet. Click here you can see the details!</a><br>
<a href="my">MyServlet클래스 객체에 대해서 알아보자</a><br>
<a href="calculator/input">계산 페이지로 이동하자</a><br>
<a href="sample?name=raphael&name=arthur&age=33&hobby=computer&hobby=develop&merried=false">HttpServletRequest와 HttpServletResponse 주요명령어를 알아보자</a>

<hr><hr>

<a href="todo/register">입력화면으로 바로가기</a><br>
<a href="/todo/list">TodoList 객체 보러가기</a><br>
<a href="/todo/read?tno=1004">read?tno=1004 doGet()보러가기</a><br>


<p>여기는 메인 페이지</p>
</body>
</html>