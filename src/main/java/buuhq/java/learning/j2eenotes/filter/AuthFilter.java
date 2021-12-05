package buuhq.java.learning.j2eenotes.filter;

import buuhq.java.learning.j2eenotes.util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;


public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String action = req.getServletPath();
        HttpSession session = req.getSession();

        boolean allowAnonymous = action.equals("/auth/login") ||
                action.equals("/auth/logout") ||
                action.contains("/assets/");

        if(allowAnonymous){
            chain.doFilter(req, resp);
        }else{
            System.out.printf("2-Authenticate filter %s \n", action);
            String roleId = null;
            String userId = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies) {
                    if(cookie.getName() == "ck_roleId") {
                        roleId = cookie.getValue();
                    }
                    if(cookie.getName() == "ck_userId") {
                        userId = cookie.getValue();
                    }
                }
            }

            boolean isAuthenticated = userId != null && userId != "";
            if(isAuthenticated){
                req.setAttribute("roleId", roleId);
                req.setAttribute("userId", userId);

                if(session.getAttribute("dbConnection") == null){
                    Connection connection = DbUtil.getConnection();
                    session.setAttribute("dbConnection", connection);
                }
                System.out.printf("2-1 Authenticated %s \n", action);
                chain.doFilter(req, resp);
            }else{
                System.out.printf("2-2 NOT Authenticated %s \n", action);
                resp.sendRedirect(req.getContextPath() +"/auth/login");
            }
        }

    }
}
