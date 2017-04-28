package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    boolean create(Course course);
    Course getCourseById(int key);
    boolean update(Course course);
    boolean delete(int courseId);

    List<Course> getAll() throws SQLException;
}
