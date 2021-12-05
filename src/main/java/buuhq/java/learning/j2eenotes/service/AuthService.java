package buuhq.java.learning.j2eenotes.service;

import buuhq.java.learning.j2eenotes.model.entity.User;
import buuhq.java.learning.j2eenotes.repository.impl.UserRepositoryImpl;
import buuhq.java.learning.j2eenotes.repository.intf.UserRepository;
import buuhq.java.learning.j2eenotes.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthService {
    private UserRepository _userRepository;
    private Connection _connection;
    public AuthService(){
        _connection = DbUtil.getConnection();
        _userRepository = new UserRepositoryImpl(_connection);
    }


    public User login(String loginName, String password){
        return _userRepository.login(loginName, password);
    }

    public void closeDbConnection(){
        try {
            if(!_connection.isClosed()) {
                _connection.close();
                System.out.println("Connection closed !!!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
