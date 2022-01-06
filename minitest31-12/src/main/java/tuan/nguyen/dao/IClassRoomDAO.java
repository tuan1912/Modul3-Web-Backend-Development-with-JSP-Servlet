package tuan.nguyen.dao;

import tuan.nguyen.model.ClassRoom;
import tuan.nguyen.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IClassRoomDAO {
    List<ClassRoom> selectAll() throws SQLException;
    ClassRoom selectById(int id) throws SQLException;
    void insert(ClassRoom classRoom) throws SQLException;
    boolean update(ClassRoom classRoom) throws SQLException;
    boolean delete(int id) throws SQLException;
}
