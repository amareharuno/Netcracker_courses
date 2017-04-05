package dao.entitiesdao;

import entities.Course;

import java.sql.SQLException;
import java.util.List;

public interface ICourseDao {
    public Course create() throws SQLException;
    public Course read(int key) throws SQLException;
    public boolean update(Course course) throws SQLException;
    public boolean delete(Course course) throws SQLException;

    public List<Course> getAll() throws SQLException;
}
