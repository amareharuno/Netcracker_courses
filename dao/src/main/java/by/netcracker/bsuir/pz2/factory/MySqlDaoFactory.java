package by.netcracker.bsuir.pz2.factory;

import by.netcracker.bsuir.pz2.daoInterface.CourseDao;
import by.netcracker.bsuir.pz2.daoInterface.StudentDao;
import by.netcracker.bsuir.pz2.daoInterface.TeacherDao;
import by.netcracker.bsuir.pz2.daoInterface.UserDao;
import by.netcracker.bsuir.pz2.mysql.MySqlCourseDao;
import by.netcracker.bsuir.pz2.mysql.MySqlStudentDao;
import by.netcracker.bsuir.pz2.mysql.MySqlTeacherDao;
import by.netcracker.bsuir.pz2.mysql.MySqlUserDao;

public class MySqlDaoFactory extends DaoFactory {

    private static MySqlDaoFactory instance = null;
    private MySqlDaoFactory() {
    }

    public static synchronized MySqlDaoFactory getInstance() {
        if (instance == null) {
            instance = new MySqlDaoFactory();
        }
        return instance;
    }

    @Override
    public UserDao getUserDao() {
        return MySqlUserDao.INSTANCE;
    }

    @Override
    public CourseDao getCourseDao() {
        return MySqlCourseDao.INSTANCE;
    }

    @Override
    public TeacherDao getTeacherDao() {
        return MySqlTeacherDao.INSTANCE;
    }

    @Override
    public StudentDao getStudentDao() {
        return MySqlStudentDao.INSTANCE;
    }
}
