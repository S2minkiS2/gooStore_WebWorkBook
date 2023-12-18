package org.zerock.gooproject1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String message2;


    public void init() {
        message = "안녕 구멍가게 코딩강의에 온걸 환영해 가즈아!";
        message2 = "한달안에 스프링부트까지 가즈아!";

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + message2 + "</h2>");
        out.println("</body></html>");
    }

}