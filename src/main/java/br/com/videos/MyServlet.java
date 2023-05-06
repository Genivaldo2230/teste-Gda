package br.com.videos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("index/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Exemplo de servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body></html>");
    }
}
