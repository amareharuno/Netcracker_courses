package by.netcracker.bsuir.pz2.factory;

import by.netcracker.bsuir.pz2.entitydaointerface.CourseDao;
import by.netcracker.bsuir.pz2.entitydaointerface.StudentDao;
import by.netcracker.bsuir.pz2.entitydaointerface.TeacherDao;
import by.netcracker.bsuir.pz2.enumeration.SourceType;

public abstract class DaoFactory {
    public abstract CourseDao getCourseDao();
    public abstract TeacherDao getTeacherDao();
    public abstract StudentDao getStudentDao();

    public static DaoFactory getDaoFactory(SourceType whichFactory) {
        switch (whichFactory) {
            case MY_SQL: return MySqlDaoFactory.getInstance();
            default: return null;
        }
    }
}
