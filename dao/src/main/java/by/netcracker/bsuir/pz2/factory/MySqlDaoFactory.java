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

    private MySqlDaoFactory() {
    }

    private static class Handler {
        private static final MySqlDaoFactory INSTANCE = new MySqlDaoFactory();
    }

    public static MySqlDaoFactory getInstance() {
        return Handler.INSTANCE;
    }

    @Override
    public UserDao getUserDao() {
        return MySqlUserDao.getInstance();
    }

    @Override
    public CourseDao getCourseDao() {
        return MySqlCourseDao.getInstance();
    }

    @Override
    public TeacherDao getTeacherDao() {
        return MySqlTeacherDao.getInstance();
    }

    @Override
    public StudentDao getStudentDao() {
        return MySqlStudentDao.getInstance();
    }
}
