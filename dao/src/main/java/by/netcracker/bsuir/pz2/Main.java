package by.netcracker.bsuir.pz2;

import by.netcracker.bsuir.pz2.entity.Teacher;
import by.netcracker.bsuir.pz2.enumeration.SourceType;
import by.netcracker.bsuir.pz2.factory.DaoFactory;
import by.netcracker.bsuir.pz2.factory.MySqlDaoFactory;
import by.netcracker.bsuir.pz2.entity.Course;
import by.netcracker.bsuir.pz2.mysql.MySqlCourseDao;
import by.netcracker.bsuir.pz2.mysql.MySqlStudentDao;
import by.netcracker.bsuir.pz2.mysql.MySqlTeacherDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Eric", "Cat", "Gerald");
        Course course = new Course("Math", "Magic Numbers", 2, 75, teacher);

        try {
            MySqlDaoFactory mySqlDaoFactory = (MySqlDaoFactory) DaoFactory.getDaoFactory(SourceType.MY_SQL);
            MySqlStudentDao mySqlStudentDao = (MySqlStudentDao) mySqlDaoFactory.getStudentDao();
            MySqlCourseDao mySqlCourseDao = (MySqlCourseDao) mySqlDaoFactory.getCourseDao();
            MySqlTeacherDao mySqlTeacherDao = (MySqlTeacherDao) mySqlDaoFactory.getTeacherDao();
            mySqlCourseDao.create(course);

            ArrayList<Course> arrayList = (ArrayList<Course>) mySqlCourseDao.getAll();
            for (Course item: arrayList) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println("Connection не закрылся (Main)");
        }
    }
}
