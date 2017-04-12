package by.netcracker.bsuir.pz2.entitydaointerface;

import by.netcracker.bsuir.pz2.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    public boolean create(Course course) throws SQLException;
    public Course getCourseById(int key) throws SQLException;
    public boolean update(Course course) throws SQLException;
    public boolean delete(int courseId) throws SQLException;

    public List<Course> getAll() throws SQLException;
}
