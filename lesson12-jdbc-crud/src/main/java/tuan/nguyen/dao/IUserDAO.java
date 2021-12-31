package tuan.nguyen.dao;

import tuan.nguyen.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;
    List<User> selectAllUsers();
    User selectUser(int id);
    boolean updateUser(User user)throws SQLException;
    boolean deleteUser(int id) throws SQLException;
}
