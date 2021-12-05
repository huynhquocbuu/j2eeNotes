package buuhq.java.learning.j2eenotes.repository.impl;

import buuhq.java.learning.j2eenotes.model.entity.User;
import buuhq.java.learning.j2eenotes.repository.intf.UserRepository;

import java.sql.Connection;

public class UserRepositoryImpl implements UserRepository {
    private Connection _connection;
    public UserRepositoryImpl(Connection connection){
        _connection = connection;
    }

    public User login(String loginName, String password){
         return null;
    }
}
