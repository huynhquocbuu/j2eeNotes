package com.example.j2eenotes.filter;

import com.example.j2eenotes.util.UrlConstants;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "sitemeshFilter", urlPatterns = UrlConstants.Welcome)
public class SiteMesh extends SiteMeshFilter {
    /*
    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) rq;
        HttpServletResponse resp = (HttpServletResponse) rs;

        String action = req.getServletPath();
        if(!action.contains("/assets/")){
            super.doFilter(rq, rs, chain);
        }else{
            chain.doFilter(req,resp);
        }

    }
    */
}
