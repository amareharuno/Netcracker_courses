import dao.IDaoFactory;
import dao.entitiesdao.ICourseDao;
import dao.mysql.MySqlDaoFactory;
import entities.Course;
import entities.Teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IDaoFactory daoFactory = new MySqlDaoFactory();
        List<Course> list = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()){
            ICourseDao dao = daoFactory.getCourseDao(connection);
            list = dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Course course : list) {
            System.out.println(course);
        }

       /* Teacher teacher = new Teacher("Eric", "Cat", "Gerald");
        Course course = new Course("Math", "Magic Numbers", 32, 75, teacher);
        teacher.setTrainingCourse(course);

        System.out.println(course);
        System.out.println();
        System.out.println(teacher);*/
    }
}
