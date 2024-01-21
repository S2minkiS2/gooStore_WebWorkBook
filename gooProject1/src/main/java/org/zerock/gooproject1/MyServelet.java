package org.zerock.gooproject1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet", urlPatterns = "/my")
public class MyServelet extends HttpServlet {

    private String message;

    public void init(){
        message = "메인 페이지로 돌아갑니다.";
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        writer.println("<h1>이 문장은 &lt;h1&gt;을 적용한 문장입니다. </h1>");
        writer.println("<h2>WebServelt 어노테이션은 브라우저의 경로와 해당 서블릿을 연결하는 설정을 위해서 사용됩니다요.</h2>");
        writer.println("<p>doGet() 은 브라우저의 주소를 직접 변경해서 접근하는 경우에 호출되는 메소드입니다요.</p>");
        writer.println("<p>서블릿에서는 PrintWriter 라는 객체를 이용해서 브라우저쪽으로 출력을 처리합니다. == 브라우저로 무언가를 출력하기 위한 용도!</p>");
        writer.println("<p><a href='index.jsp'>" + message + "</a></p>");
    }
}
