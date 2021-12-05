package buuhq.java.learning.j2eenotes.util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class AppSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("Session created !!!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        try {
            if(se.getSession().getAttribute("dbConnection") != null){
                Connection connection = (Connection)se.getSession().getAttribute("dbConnection");
                if(!connection.isClosed()) {
                    connection.close();
                    System.out.println("Connection closed !!!");
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
