package by.netcracker.bsuir.pz2.factory;

import by.netcracker.bsuir.pz2.daoInterface.CourseDao;
import by.netcracker.bsuir.pz2.daoInterface.StudentDao;
import by.netcracker.bsuir.pz2.daoInterface.TeacherDao;
import by.netcracker.bsuir.pz2.daoInterface.UserDao;
import by.netcracker.bsuir.pz2.enumeration.SourceType;

public abstract class DaoFactory {
    public abstract CourseDao getCourseDao();
    public abstract TeacherDao getTeacherDao();
    public abstract StudentDao getStudentDao();
    public abstract UserDao getUserDao();

    public static DaoFactory getDaoFactory(SourceType whichFactory) {
        switch (whichFactory) {
            case MY_SQL: return MySqlDaoFactory.getInstance();
            default: return null;
        }
    }
}
