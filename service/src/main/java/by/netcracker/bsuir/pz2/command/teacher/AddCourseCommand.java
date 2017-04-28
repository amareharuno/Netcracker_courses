package by.netcracker.bsuir.pz2.command.teacher;

import by.netcracker.bsuir.pz2.command.Command;
import by.netcracker.bsuir.pz2.constantString.HttpRequestParameter;
import by.netcracker.bsuir.pz2.daoInterface.CourseDao;
import by.netcracker.bsuir.pz2.entity.Course;
import by.netcracker.bsuir.pz2.enumeration.PageLocationKey;
import by.netcracker.bsuir.pz2.factory.DaoFactory;
import by.netcracker.bsuir.pz2.factory.MySqlDaoFactory;
import by.netcracker.bsuir.pz2.propertyManager.PageLocation;

import javax.servlet.http.HttpServletRequest;

public class AddCourseCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String pathToPage;

        DaoFactory mySqlDaoFactory = MySqlDaoFactory.INSTANSE;
        String courseName = request.getParameter(HttpRequestParameter.COURSE_NAME);
        String subject = request.getParameter(HttpRequestParameter.SUBJECT);
        int lessonsCount = Integer.parseInt(request.getParameter(HttpRequestParameter.LESSONS_COUNT));
        int lessonDurstion = Integer.parseInt(request.getParameter(HttpRequestParameter.LESSON_DURATION));
        int courseDurstion = Integer.parseInt(request.getParameter(HttpRequestParameter.COURSE_DURATION));

        Course course = new Course();
        course.setCourseName(courseName);
        course.setLessonsCount(lessonsCount);
        course.setLessonDuration(lessonDurstion);
        course.setSubject(subject);
        course.setCourseDuration(courseDurstion);

        CourseDao courseDao = mySqlDaoFactory.getCourseDao();
        courseDao.create(course);

        pathToPage = PageLocation.INSTANCE.getPageLocation(PageLocationKey.INDEX);

        return pathToPage;
    }
}
