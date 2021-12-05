package buuhq.java.learning.j2eenotes.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

public abstract class BaseServlet extends HttpServlet {
    protected Connection _connection;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init method");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        _connection = (Connection)session.getAttribute("dbConnection");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy method");
    }
}
