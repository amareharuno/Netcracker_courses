package by.netcracker.bsuir.pz2.mysql;

import by.netcracker.bsuir.pz2.connectionPool.ConnectionPool;
import by.netcracker.bsuir.pz2.constantString.ExceptionMessage;
import by.netcracker.bsuir.pz2.constantString.UserTable;
import by.netcracker.bsuir.pz2.daoInterface.UserDao;
import by.netcracker.bsuir.pz2.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum MySqlUserDao implements UserDao{

    INSTANCE;

    private ConnectionPool connectionPool = ConnectionPool.INSTANCE;

    @Override
    public boolean create(User user) {
        boolean isCreated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserTable.CREATE_USER)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setBoolean(3, user.isTeacher());
                preparedStatement.executeUpdate();
                isCreated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.USER_CREATE_SQL_EXCEPTION);
            e.printStackTrace();
            isCreated = false;
        }
        return isCreated;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserTable.GET_USER_BY_ID)) {
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    user = new User(
                            resultSet.getInt(UserTable.USER_ID),
                            resultSet.getString(UserTable.LOGIN),
                            resultSet.getString(UserTable.PASSWORD),
                            resultSet.getBoolean(UserTable.IS_TEACHER));
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.USER_GET_BY_ID_SQL_EXCEPTION);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByLoginInfo(String login, String password){
        User user = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserTable.GET_USER_BY_LOGIN_INFO)){
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    user = new User(
                            resultSet.getInt(UserTable.USER_ID),
                            resultSet.getString(UserTable.LOGIN),
                            resultSet.getString(UserTable.PASSWORD),
                            resultSet.getBoolean(UserTable.IS_TEACHER));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean isUpdated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserTable.UPDATE_USER)) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setBoolean(4, user.isTeacher());
                preparedStatement.executeUpdate();
                isUpdated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.USER_UPDATE_SQL_EXCEPTION);
            isUpdated = false;
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int userId) {
        boolean isDeleted;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserTable.DELETE_USER)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();
                isDeleted = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.USER_DELETE_SQL_EXCEPTION);
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserTable.GET_USERS)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt(UserTable.USER_ID));
                    user.setLogin(resultSet.getString(UserTable.LOGIN));
                    user.setPassword(resultSet.getString(UserTable.PASSWORD));
                    user.setIsTeacher(resultSet.getBoolean(UserTable.IS_TEACHER));
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.COURSE_GET_ALL_SQL_EXCEPTION);
            e.printStackTrace();
        }

        return list;
    }
}
