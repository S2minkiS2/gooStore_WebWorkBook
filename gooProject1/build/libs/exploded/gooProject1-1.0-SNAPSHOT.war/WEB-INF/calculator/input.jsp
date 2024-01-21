<%--
  Created by IntelliJ IDEA.
  User: smk
  Date: 12/15/23
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산기 어플리케이션 : 입력 페이지</title>

    <style>
        .form {
            display: flex;
            flex-wrap: wrap;
            gap: 0.5rem;
        }
        .name {
            flex: 1 0 10rem;
        }
        .email {
            flex: 1 0 10rem;
        }
        .num {
            flex : 1 0 10rem;
        }
        .button {
            flex: 1 0 5rem;
            background-color: #c0b9a5;
        }
        .form1 {
            color: blueviolet;
        }
        .form2 {
            color: cornflowerblue;
        }

    </style>
</head>
<body>
    <div>
        <div>
            <h3>여기는 Input 페이지 입니다.</h3>
            <hr>
            <p class="form1">@/calculator/input 의 post로 가는 form</p>
            <form action="/calculator/input" method="post" class="form">
                <input type="text" name="name" placeholder="이름 입력" class="name" />
                <input type="email" name="email" placeholder="이메일 주소 입력" class="email">
                <input type="number" name="num1" placeholder="첫번째 숫자" class="num">
                <input type="number" name="num2" placeholder="두번째 숫자" class="num">
                <button type="submit" class="button">제출하기</button>
            </form>

            <hr>
            <p class="form2">@/calculator/makeResult 의 post로 가는 form</p>
            <form action="/calculator/makeResult" method="post" class="form">
                <input type="text" name="name" placeholder="이름 입력" class="name" />
                <input type="email" name="email" placeholder="이메일 주소 입력" class="email">
                <input type="number" name="num1" placeholder="첫번째 숫자" class="num">
                <input type="number" name="num2" placeholder="두번째 숫자" class="num">
                <button type="submit" class="button">제출하기</button>
            </form>
        </div>
        <div>


        </div>

    </div>
</body>
</html>
