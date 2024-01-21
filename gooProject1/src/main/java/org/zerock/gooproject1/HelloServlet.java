package org.zerock.gooproject1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hi-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String message2;
    private String message3;


    public void init() {
        message = "안녕 구멍가게 코딩강의에 온걸 환영해!";
        message2 = "2월 2일까지 400페이지까지 진도 나가자!";
        message3 = "메인 페이지로 돌아갑니다.";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + message2 + "</h2>");
        out.println("<h2><a href= 'index.jsp'>" + message3 + "</a></h2>");
        out.println("</body></html>");
    }

}