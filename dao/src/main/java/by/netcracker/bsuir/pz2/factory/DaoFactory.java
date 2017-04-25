package by.netcracker.bsuir.pz2.factory;

import by.netcracker.bsuir.pz2.daoInterface.CourseDao;
import by.netcracker.bsuir.pz2.daoInterface.StudentDao;
import by.netcracker.bsuir.pz2.daoInterface.TeacherDao;
import by.netcracker.bsuir.pz2.daoInterface.UserDao;
import by.netcracker.bsuir.pz2.enumeration.SourceType;

public interface DaoFactory {
    CourseDao getCourseDao();
    TeacherDao getTeacherDao();
    StudentDao getStudentDao();
    UserDao getUserDao();
}
