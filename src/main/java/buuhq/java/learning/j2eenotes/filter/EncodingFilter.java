package buuhq.java.learning.j2eenotes.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String action = req.getServletPath();
        if (!action.contains("/assets/")) {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            System.out.printf("1-Encoding filter %s \n", action);
        }
        chain.doFilter(req, resp);

    }
}
