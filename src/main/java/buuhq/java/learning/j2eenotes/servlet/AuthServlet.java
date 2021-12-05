package buuhq.java.learning.j2eenotes.servlet;

import buuhq.java.learning.j2eenotes.model.entity.User;
import buuhq.java.learning.j2eenotes.service.AuthService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = {"/auth/login", "/auth/logout"})
public class AuthServlet extends HttpServlet {
    private String _action;
    private String _uri;
    private AuthService _authService;

    @Override
    public void init() throws ServletException {
        System.out.println("init of auth servlet");
        _authService = new AuthService();
        super.init();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        _action = req.getServletPath();
        _uri = req.getContextPath();
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (_action) {
            case "/auth/login":
                doGetLogin(req, resp);
                break;
            case "/auth/logout":
                doLogout(req, resp);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (_action) {
            case "/auth/login":
                doPostLogin(req, resp);
                break;
            default:
                break;
        }
    }

    //--------------
    public void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/views/auth/login.jsp")
                .forward(req, resp);
    }

    public void doPostLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");

        User user =  _authService.login(loginName, password);
        if(user != null){
            //Set cookies
            Cookie ck_roleId = new Cookie("ck_roleId", String.valueOf(user.getRoleId()));
            ck_roleId.setPath(_uri);

            Cookie ck_userId = new Cookie("ck_userId", String.valueOf(user.getId()));
            ck_userId.setPath(_uri);

            resp.addCookie(ck_roleId);
            resp.addCookie(ck_userId);


            _authService.closeDbConnection();
        }else{
            _authService.closeDbConnection();
            doPostLogin(req, resp);
        }
    }
    public void doLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //Delete cookie
        Cookie ck_roleId = new Cookie("ck_roleId", null);
        ck_roleId.setPath(_uri);
        ck_roleId.setMaxAge(0);

        Cookie ck_userId = new Cookie("ck_userId", null);
        ck_userId.setPath(_uri);
        ck_userId.setMaxAge(0);

        resp.addCookie(ck_roleId);
        resp.addCookie(ck_userId);

        resp.sendRedirect(_uri+ "/auth/login");
    }
}
