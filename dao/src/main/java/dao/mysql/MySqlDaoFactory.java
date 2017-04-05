package dao.mysql;

import dao.entitiesdao.ICourseDao;
import dao.entitiesdao.IStudentDao;
import dao.entitiesdao.ITeacherDao;
import dao.IDaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements IDaoFactory {

    private String user = "root";
    private String password = "SQL174";
    private String url = "jdbc:mysql://localhost:3306/courses";
    private String driver = "com.mysql.jdbc.Driver";

    public MySqlDaoFactory() {
        try {
            Class.forName(driver); //Регистрируем драйвер
            // forName(s) - Returns the Class object associated with the class or interface with the given string name.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public ICourseDao getCourseDao(Connection connection) {
        return new MySqlCourseDao(connection);
    }

    @Override
    public ITeacherDao getTeacherDao(Connection connection) {
        return new MySqlTeacherDao(connection);
    }

    @Override
    public IStudentDao getStudentDao(Connection connection) {
        return new MySqlStudentDao(connection);
    }

}
