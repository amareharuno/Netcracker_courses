package dao;

import dao.entitiesdao.ICourseDao;
import dao.entitiesdao.IStudentDao;
import dao.entitiesdao.ITeacherDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDaoFactory {
    public Connection getConnection() throws SQLException;
    public ICourseDao getCourseDao(Connection connection);
    public ITeacherDao getTeacherDao(Connection connection);
    public IStudentDao getStudentDao(Connection connection);
}
