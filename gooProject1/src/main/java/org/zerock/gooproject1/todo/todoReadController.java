package org.zerock.gooproject1.todo;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zerock.gooproject1.todo.dto.TodoDTO;
import org.zerock.gooproject1.todo.service.TodoService;

import java.io.IOException;

@WebServlet("/todo/read")
public class todoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        System.out.println("/todo/read 의 doGet() 실행");

        // 예시 : /todo/read?tno=123
        Long tno = Long.parseLong(req.getParameter("tno")); //문자형을 Long 자료형으로 강제변환

        TodoDTO dto = TodoService.INSTANCE.getOne(tno);
        System.out.println("dto : " + dto);

        req.setAttribute("dto", dto);

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);


    }
}
