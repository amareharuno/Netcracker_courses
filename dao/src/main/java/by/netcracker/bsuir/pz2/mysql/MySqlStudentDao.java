package by.netcracker.bsuir.pz2.mysql;

import by.netcracker.bsuir.pz2.connectionPool.ConnectionPool;
import by.netcracker.bsuir.pz2.constantString.ExceptionMessage;
import by.netcracker.bsuir.pz2.constantString.StudentTable;
import by.netcracker.bsuir.pz2.daoInterface.StudentDao;
import by.netcracker.bsuir.pz2.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlStudentDao implements StudentDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private MySqlStudentDao(){
    }

    private static class Handler {
        private static final MySqlStudentDao INSTANCE = new MySqlStudentDao();
    }

    public static MySqlStudentDao getInstance() {
        return Handler.INSTANCE;
    }

    @Override
    public boolean create(Student student) throws SQLException {
        boolean isCreated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(StudentTable.CREATE_STUDENT)) {
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setString(3, student.getMiddleName());
                preparedStatement.executeUpdate();
                isCreated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.STUDENT_CREATE_SQL_EXCEPTION);
            e.printStackTrace();
            isCreated = false;
        }
        return isCreated;
    }

    @Override
    public Student getStudentById(int studentId) {
        Student student = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(StudentTable.GET_STUDENT)) {
                preparedStatement.setInt(1, studentId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    student = new Student(resultSet.getInt(StudentTable.STUDENT_ID),
                            resultSet.getString(StudentTable.FIRST_NAME),
                            resultSet.getString(StudentTable.LAST_NAME),
                            resultSet.getString(StudentTable.MIDDLE_NAME));
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.STUDENT_GET_BY_ID_SQL_EXCEPTION);
            e.printStackTrace();
        }
        return student;
    }


    @Override
    public boolean update(Student student) {
        boolean isUpdated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(StudentTable.UPDATE_STUDENT)) {
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2, student.getFirstName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setString(4, student.getMiddleName());
                preparedStatement.executeUpdate();
                isUpdated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.STUDENT_UPDATE_SQL_EXCEPTION);
            isUpdated = false;
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Student student) {
        boolean isDeleted;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(StudentTable.DELETE_STUDENT)) {
                preparedStatement.setInt(1, student.getId());
                preparedStatement.executeUpdate();
                isDeleted = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.STUDENT_DELETE_SQL_EXCEPTION);
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(StudentTable.GET_STUDENTS)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Student teacher = new Student(resultSet.getInt(StudentTable.STUDENT_ID),
                            resultSet.getString(StudentTable.FIRST_NAME),
                            resultSet.getString(StudentTable.LAST_NAME),
                            resultSet.getString(StudentTable.MIDDLE_NAME));
                    list.add(teacher);
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.STUDENT_GET_ALL_SQL_EXCEPTION);
            e.printStackTrace();
        }
        return list;
    }
}
