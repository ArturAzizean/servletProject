package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter;

        String aa = req.getParameter("a");
        String bb = req.getParameter("b");

        if (aa != null && bb != null) {

            int a = Integer.parseInt(aa);
            int b = Integer.parseInt(bb);

            respWriter = resp.getWriter();

            respWriter.write("<h1>First number</h1> = " + a);
            respWriter.write("<h2>Second number</h2> = " + b);
        } else {
            respWriter = resp.getWriter();
            respWriter.write("<h1>nothing</h1>");

        }
    }
}
