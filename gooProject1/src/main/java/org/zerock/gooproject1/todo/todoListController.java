package org.zerock.gooproject1.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zerock.gooproject1.todo.dto.TodoDTO;
import org.zerock.gooproject1.todo.service.TodoService;

import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", urlPatterns="/todo/list")
public class todoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        System.out.println("@/todo/list -> doGET() 실행");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        req.setAttribute("list", dtoList);
        //HttpServletRequest의 setAttribute()는 키와 값의 형식으로 HttpServletRequest에 데이터를 보관하고, 얘네를 jsp에서 꺼내서 사용해요.

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);

    }
}
