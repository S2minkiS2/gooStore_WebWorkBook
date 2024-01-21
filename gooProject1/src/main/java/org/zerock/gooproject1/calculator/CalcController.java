package org.zerock.gooproject1.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calcController" , urlPatterns = "/calculator/makeResult")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("CalcController의 doPost() 실행");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf(" name: %s", name);
        System.out.printf(" email: %s", email);
        System.out.printf(" num1: %s", num1);
        System.out.printf(" num2: %s", num2);

        resp.sendRedirect("/sample");

    }

}
