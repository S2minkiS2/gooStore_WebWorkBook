package org.zerock.gooproject1.calculator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/calculator/input")
public class inputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("inputController의 doGet() 실행됨");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calculator/input.jsp");

        dispatcher.forward(req, resp);
        //RequestDispatcher 객체는 서블릿에 전달된 요청을 다른 쪽으로 전달, 배포 합니다. 마치 버스 정류장을 경유하는 것처럼~
    }
    //index에서 링크를 누르면 어노테이션을 타고 이 doGet으로 오게되고, input.jsp를 포워딩하게 되어 input.jsp로 접속하게 된다.

    @Override //Post용으로 다른 컨트롤러를 하나 더 만들던(CalcController) 아니면 inputController에 이처럼 Post를 만들던 입맛대로~
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf(" name: %s", name);
        System.out.printf(" email: %s", email);
        System.out.printf(" num1: %s", num1);
        System.out.printf(" num2: %s", num2);

    }
}
