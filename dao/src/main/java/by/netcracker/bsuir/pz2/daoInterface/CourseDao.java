package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    public boolean create(Course course);
    public Course getCourseById(int key);
    public boolean update(Course course);
    public boolean delete(int courseId);

    public List<Course> getAll() throws SQLException;
}
