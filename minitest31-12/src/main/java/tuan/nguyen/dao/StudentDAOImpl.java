package tuan.nguyen.dao;

import tuan.nguyen.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/minitestquanlyhocvien?characterEncoding=UTF8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_STUDENT_SQL = "INSERT INTO student" + "  (name, dateOfBirh, address,phoneNumber,email,classRoomId) VALUES " +
            " (?, ?, ?,?,?,?);";

    private static final String SELECT_STUDENT_BY_ID = "select * from student where id =? "+" join classroom on classroom.id= student.classRoomId;";
    private static final String SELECT_ALL = "select * from student";
    private static final String DELETE_STUDENT_SQL = "delete from student where id = ?;";
    private static final String UPDATE_STUDENT_SQL = "update student set name = ?,dateOfBirth= ?, address =? , phoneNumber = ?, email= ?, classRoomId = ? where id = ?;";

    public StudentDAOImpl() {
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
    public List<Student> selectAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        ResultSet resultSet;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("dateOfBirth"));
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int classRoomId = resultSet.getInt("classRoomId");
                students.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classRoomId));

            }
        }catch (SQLException sqlException){
            printSQLException(sqlException);
        }
        return students;
    }

    @Override
    public Student selectById(int id) throws SQLException{
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("dateOfBirth"));
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int classRoomId = resultSet.getInt("classRoomId");
                student = new Student(id, name, dateOfBirth, address, phoneNumber, email, classRoomId);
            }
        }catch (SQLException  sqlException){
            printSQLException(sqlException);
        }
        return student;
    }

    @Override
    public void insert(Student student) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getDateOfBirh().toString());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getClassRoomId());
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            printSQLException(sqlException);
        }
    }

    @Override
    public boolean update(Student student) throws SQLException {
        boolean rowUpdate = false;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getDateOfBirh().toString());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getClassRoomId());
            preparedStatement.setInt(7,student.getId());
            rowUpdate = preparedStatement.executeUpdate()>0;
        }catch (SQLException sqlException){
            printSQLException(sqlException);
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            System.out.println(DELETE_STUDENT_SQL);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate()>0;
        }catch (SQLException sqlException){
            printSQLException(sqlException);
        }
        return rowDeleted;
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
