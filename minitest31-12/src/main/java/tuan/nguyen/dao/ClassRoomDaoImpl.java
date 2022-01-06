package tuan.nguyen.dao;

import tuan.nguyen.model.ClassRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomDaoImpl implements IClassRoomDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/minitestquanlyhocvien?characterEncoding=UTF8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";
    public static String SELECT_ALL_CLASSROOM = "select * from classroom ;";
    public static String SELECT_CLASSROOM = "select * from classroom where id = ?;";
    public ClassRoomDaoImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<ClassRoom> selectAll() throws SQLException {
        List<ClassRoom> classRooms = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSROOM)){
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classRooms.add(new ClassRoom(id,name));
            }
        }catch (SQLException sqlException){
            printSQLException(sqlException);
        }
        return classRooms;
    }

    @Override
    public ClassRoom selectById(int id) throws SQLException {
        ClassRoom classRoom = null;
        ResultSet resultSet;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASSROOM)){
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int classRoomId = resultSet.getInt("id");
                String classRoomName = resultSet.getString("name");
                classRoom = new ClassRoom(classRoomId,classRoomName);
            }
        }catch (SQLException sqlException){
            printSQLException(sqlException);
        }
        return classRoom;
    }

    @Override
    public void insert(ClassRoom classRoom) throws SQLException {

    }

    @Override
    public boolean update(ClassRoom classRoom) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
