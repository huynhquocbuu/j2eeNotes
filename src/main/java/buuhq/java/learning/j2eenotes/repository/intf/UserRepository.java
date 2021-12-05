package buuhq.java.learning.j2eenotes.repository.intf;

import buuhq.java.learning.j2eenotes.model.entity.User;

import java.sql.Connection;

public interface UserRepository {
    User login(String loginName, String password);
}
