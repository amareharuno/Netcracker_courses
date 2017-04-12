package by.netcracker.bsuir.pz2.factory;

import by.netcracker.bsuir.pz2.entitydaointerface.CourseDao;
import by.netcracker.bsuir.pz2.entitydaointerface.StudentDao;
import by.netcracker.bsuir.pz2.entitydaointerface.TeacherDao;
import by.netcracker.bsuir.pz2.mysql.MySqlCourseDao;
import by.netcracker.bsuir.pz2.mysql.MySqlStudentDao;
import by.netcracker.bsuir.pz2.mysql.MySqlTeacherDao;

public class MySqlDaoFactory extends DaoFactory {

    private MySqlDaoFactory() {
    }

    private static class Handler {
        private static final MySqlDaoFactory INSTANCE = new MySqlDaoFactory();
    }

    static MySqlDaoFactory getInstance() {
        return Handler.INSTANCE;
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
