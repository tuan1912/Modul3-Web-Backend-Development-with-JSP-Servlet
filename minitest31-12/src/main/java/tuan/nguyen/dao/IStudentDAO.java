package tuan.nguyen.dao;

import tuan.nguyen.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    List<Student> selectAll() throws SQLException;
    Student selectById(int id) throws SQLException;
    void insert(Student student) throws SQLException;
    boolean update(Student student) throws SQLException;
    boolean delete(int id) throws SQLException;
}
