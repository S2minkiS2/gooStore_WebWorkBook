package org.zerock.gooproject1.calculator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() 실행 ..." + this);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //-----------------------------------------------------------------------
        out.println("<h1> HttpServletRequest의 주요기능 </h1>");

        Enumeration<String> headerNames = req.getHeaderNames();
        out.println("headerNames : " + headerNames + "<br>");

        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAdder : " + remoteAddr);
        out.println("remoteAdder : " + remoteAddr + "<br>");

        String method = req.getMethod();
        System.out.println("method : " + method);
        out.println("method : " + method + "<br>");

        String requestURI = req.getRequestURI();
        System.out.println("requestURI : " + requestURI);
        out.println("requestURI : " + requestURI + "<br>");

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL : " + requestURL);
        out.println("requestURL : " + requestURL + "<br>");

        String parameterName = req.getParameter("name");
        System.out.println("parameterName : " + parameterName);
        out.println("parameterName : " + parameterName + "<br>");

        String parameterAge = req.getParameter("age");
        System.out.println("parameterAge : " + parameterAge);
        out.println("parameterAge : " + parameterAge + "<br>");


        String[] parameterValues = req.getParameterValues("name"); //같은 name의 모든 값 얻기
        System.out.println("parameterValues : " + parameterValues);
        out.print("<h3> 키 값이 name인 요소들의 모든 값(values)얻기 <ul>");
        if (parameterValues != null) {
            for (String paramValue : parameterValues) {
                out.println("<li>" + paramValue + "</li>");
            }
        }
        out.print("</ul></h3>");


        Enumeration<String> parameterNames = req.getParameterNames(); //모든 매개변수의 이름 얻기
        System.out.println("parameterNames : " + parameterNames);
        out.println("<h3> 모든 매개변수 이름 얻기 : getParameterNames() <ul>");
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            out.println("<li>" + paramName + "</li>");
        }
        out.print("</ul></h3>");

        Cookie[] cookies = req.getCookies();
        System.out.println("cookies : " + cookies + "<br>");
        out.println("cookies : " + cookies + "<br>");

        //RequestDispatcher requestDispatcher = req.getRequestDispatcher();
        //requestDispatcher.forward(req, resp);
        //현재의 요청(req)를 다른 서버의 자원(서블릿 혹은 JSP)에게 전달하는 용도로 사용합니다. 주로 forward()를 사용합니다.

        //req.setAttribute(); JSP로 전달할 데이터를 추가할 때 사용합니다.


        //-----------------------------------------------------------------------------------
        out.println("-----------------------------------------------------------------------------------");
        out.println("<h1> HttpServletResponse의 주요기능 </h1>");
        out.println("<h2>HttpServletResponse는 주로 JSP에서 처리되기 때문에 서블릿에서 직접 사용되는 일은 많지 않고 주로 sendRedirect()를 이용함</h2><br> ");

        out.println("<p>resp.setContentType() : 응답 데이터의 종류를 지정(이미지, HTML, XML 등)</p><br>");
        out.println("<p>resp.setHeader() : 특정 이름의 HTTP 헤더 지정</p><br>");
        out.println("<p>resp.setStatus() : 404, 200, 500 등의 응답 상태 코드 지정</p><br>");
        out.println("<p>resp.getWriter() : PrintWriter를 이용해서 응답 메시지 작성 </p><br>");
        out.println("<p>resp.addCookie() : 응답 시에 특정 쿠키 추가</p><br>");
        out.println("<p>resp.sendRedirect() : 브라우저에 이동을 지시</p><br>");


    }

    @Override
    public void destroy(){
        System.out.println("[서버종료] 톰캣종료 : destroy() 실행 ...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("[서버시작] 서블릿 초기화 작업 수행 : init(ServletConfig) 실행 ...");
    }
}
