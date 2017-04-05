package dao.mysql;

import entities.Course;
import dao.entitiesdao.ICourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCourseDao implements ICourseDao{

    private final Connection connection;

    public MySqlCourseDao(Connection connection) {
        this.connection = connection;
    }

    public Course create() throws SQLException {
        return null;
    }

    public Course read(int key) throws SQLException{
        String sql = "SELECT * FROM courses.course WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, key);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return new Course(resultSet.getInt("courseID"),
                resultSet.getString("subject"),
                resultSet.getString("courseName"),
                resultSet.getInt("lessonsCount"),
                resultSet.getInt("lessonDuration"));
    }

    public boolean update(Course course) throws SQLException {
        return false;
    }

    public boolean delete(Course course) throws SQLException {
        return false;
    }

    public List<Course> getAll() throws SQLException {
        String sql = "SELECT * FROM courses.course;";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        List<Course> list = new ArrayList<Course>();
        while (resultSet.next()){
            Course course = new Course();

            course.setId(resultSet.getInt("courseID"));
            course.setSubject(resultSet.getString("subject"));
            course.setCourseName(resultSet.getString("courseName"));
            course.setLessonsCount(resultSet.getInt("lessonsCount"));
            course.setLessonDuration(resultSet.getInt("lessonDuration"));
            course.setCourseDuration(resultSet.getInt("courseDuration"));
            course.setTeacherId(resultSet.getInt("teacher_teacherId"));
            list.add(course);
        }

        return list;
    }
}
