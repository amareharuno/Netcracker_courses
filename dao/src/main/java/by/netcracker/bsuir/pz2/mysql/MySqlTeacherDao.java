package by.netcracker.bsuir.pz2.mysql;

import by.netcracker.bsuir.pz2.connectionpool.ConnectionPool;
import by.netcracker.bsuir.pz2.constantstring.ExceptionMessage;
import by.netcracker.bsuir.pz2.constantstring.TeacherTable;
import by.netcracker.bsuir.pz2.entitydaointerface.TeacherDao;
import by.netcracker.bsuir.pz2.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTeacherDao implements TeacherDao {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private MySqlTeacherDao() {
    }

    private static class Handler {
        private static final MySqlTeacherDao INSTANCE = new MySqlTeacherDao();
    }

    public static MySqlTeacherDao getInstance() {
        return Handler.INSTANCE;
    }

    @Override
    public boolean create(Teacher teacher) throws SQLException {
        boolean isCreated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(TeacherTable.CREATE_TEACHER)) {
                preparedStatement.setString(1, teacher.getFirstName());
                preparedStatement.setString(2, teacher.getLastName());
                preparedStatement.setString(3, teacher.getMiddleName());
                preparedStatement.executeUpdate();
                isCreated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.TEACHER_CREATE_SQL_EXCEPTION);
            e.printStackTrace();
            isCreated = false;
        }
        return isCreated;
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws SQLException {
        Teacher teacher = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(TeacherTable.GET_TEACHER)) {
                preparedStatement.setInt(1, teacherId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    teacher = new Teacher(resultSet.getInt(TeacherTable.TEACHER_ID),
                            resultSet.getString(TeacherTable.FIRST_NAME),
                            resultSet.getString(TeacherTable.LAST_NAME),
                            resultSet.getString(TeacherTable.MIDDLE_NAME));
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.TEACHER_GET_BY_ID_SQL_EXCEPTION);
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public boolean update(Teacher teacher) throws SQLException {
        boolean isUpdated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(TeacherTable.UPDATE_TEACHER)) {
                preparedStatement.setInt(1, teacher.getId());
                preparedStatement.setString(2, teacher.getFirstName());
                preparedStatement.setString(3, teacher.getLastName());
                preparedStatement.setString(4, teacher.getMiddleName());
                preparedStatement.executeUpdate();
                isUpdated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.TEACHER_UPDATE_SQL_EXCEPTION);
            isUpdated = false;
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int teacherId) throws SQLException {
        boolean isDeleted;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(TeacherTable.DELETE_TEACHER)) {
                preparedStatement.setInt(1, teacherId);
                preparedStatement.executeUpdate();
                isDeleted = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.TEACHER_DELETE_SQL_EXCEPTION);
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        List<Teacher> list = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(TeacherTable.GET_TEACHERS)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Teacher teacher = new Teacher(resultSet.getInt(TeacherTable.TEACHER_ID),
                            resultSet.getString(TeacherTable.FIRST_NAME),
                            resultSet.getString(TeacherTable.LAST_NAME),
                            resultSet.getString(TeacherTable.MIDDLE_NAME));
                    list.add(teacher);
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.TEACHER_GET_ALL_SQL_EXCEPTION);
            e.printStackTrace();
        }
        return list;
    }
}
