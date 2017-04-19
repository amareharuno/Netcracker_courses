package by.netcracker.bsuir.pz2.mysql;

import by.netcracker.bsuir.pz2.connectionPool.ConnectionPool;
import by.netcracker.bsuir.pz2.constantString.ExceptionMessage;
import by.netcracker.bsuir.pz2.daoInterface.CourseDao;
import by.netcracker.bsuir.pz2.entity.Course;
import by.netcracker.bsuir.pz2.constantString.CourseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCourseDao implements CourseDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private MySqlCourseDao() {
    }

    private static class Handler {
        private static final MySqlCourseDao INSTANCE = new MySqlCourseDao();
    }

    public static MySqlCourseDao getInstance() {
        return Handler.INSTANCE;
    }

    public boolean create(Course course) {
        boolean isCreated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CourseTable.CREATE_COURSE)) {
                preparedStatement.setString(1, course.getSubject());
                preparedStatement.setString(2, course.getCourseName());
                preparedStatement.setInt(3, course.getLessonsCount());
                preparedStatement.setInt(4,course.getLessonDuration());
                preparedStatement.setInt(5,course.getCourseDuration());
                preparedStatement.setInt(6, course.getTeacher().getId());
                preparedStatement.executeUpdate();
                isCreated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.COURSE_CREATE_SQL_EXCEPTION);
            e.printStackTrace();
            isCreated = false;
        }
        return isCreated;
    }

    public Course getCourseById(int courseId) {
        Course course = null;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CourseTable.GET_COURSE)){
                preparedStatement.setInt(1, courseId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    course = new Course(
                            resultSet.getInt(CourseTable.COURSE_ID),
                            resultSet.getString(CourseTable.SUBJECT),
                            resultSet.getString(CourseTable.COURSE_NAME),
                            resultSet.getInt(CourseTable.LESSONS_COUNT),
                            resultSet.getInt(CourseTable.LESSON_DURATION),
                            MySqlTeacherDao.getInstance().getTeacherById(resultSet.getInt(CourseTable.TEACHER_ID)));
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.COURSE_GET_BY_ID_SQL_EXCEPTION);
            e.printStackTrace();
        }
        return course;
    }

    public boolean update(Course course) {
        boolean isUpdated;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CourseTable.UPDATE_COURSE)) {
                preparedStatement.setInt(1, course.getId());
                preparedStatement.setString(2, course.getSubject());
                preparedStatement.setString(3, course.getCourseName());
                preparedStatement.setInt(4, course.getLessonsCount());
                preparedStatement.setInt(5, course.getLessonDuration());
                preparedStatement.setInt(6, course.getCourseDuration());
                preparedStatement.setInt(7, course.getTeacher().getId());
                preparedStatement.executeUpdate();
                isUpdated = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.COURSE_UPDATE_SQL_EXCEPTION);
            isUpdated = false;
        }
        return isUpdated;
    }

    public boolean delete(int courseId) {
        boolean isDeleted;
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CourseTable.DELETE_COURSE)) {
                preparedStatement.setInt(1, courseId);
                preparedStatement.executeUpdate();
                isDeleted = true;
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.COURSE_DELETE_SQL_EXCEPTION);
            isDeleted = false;
        }
        return isDeleted;
    }

    public List<Course> getAll() throws SQLException{
        List<Course> list = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CourseTable.GET_COURSES)){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Course course = new Course();
                    course.setId(resultSet.getInt(CourseTable.COURSE_ID));
                    course.setSubject(resultSet.getString(CourseTable.SUBJECT));
                    course.setCourseName(resultSet.getString(CourseTable.COURSE_NAME));
                    course.setLessonsCount(resultSet.getInt(CourseTable.LESSONS_COUNT));
                    course.setLessonDuration(resultSet.getInt(CourseTable.LESSON_DURATION));
                    course.setCourseDuration(resultSet.getInt(CourseTable.COURSE_DURATION));
                    course.setTeacher(MySqlTeacherDao.getInstance().getTeacherById(resultSet.getInt(CourseTable.TEACHER_ID)));
                    list.add(course);
                }
            }
        } catch (SQLException e) {
            System.out.println(ExceptionMessage.COURSE_GET_ALL_SQL_EXCEPTION);
            e.printStackTrace();
        }

        return list;
    }
}
