package org.zerock.gooproject1.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/todo/register")
public class todoRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("Get방식으로 호출됨 : 입력(등록) 화면을 볼 수 있도록 구성");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("Post방식으로 호출됨 : 입력을 처리하고 목록 페이지로 이동");

        //반복적인 POST 요청을 막기 위해서 sendRedirect() 적용
        //브라우저가 호출해야 하는 주소 =
        resp.sendRedirect("/todo/list");

        System.out.println("sendRedirect()로 인해 todoListController.java로 이동");
    }


}
