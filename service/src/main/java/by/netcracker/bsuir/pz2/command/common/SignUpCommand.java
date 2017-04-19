package by.netcracker.bsuir.pz2.command.common;

import by.netcracker.bsuir.pz2.command.Command;
import by.netcracker.bsuir.pz2.constantString.HttpRequestParameter;
import by.netcracker.bsuir.pz2.daoInterface.UserDao;
import by.netcracker.bsuir.pz2.entity.Student;
import by.netcracker.bsuir.pz2.entity.Teacher;
import by.netcracker.bsuir.pz2.entity.User;
import by.netcracker.bsuir.pz2.enumeration.PageLocationKey;
import by.netcracker.bsuir.pz2.enumeration.SourceType;
import by.netcracker.bsuir.pz2.factory.DaoFactory;
import by.netcracker.bsuir.pz2.propertyManager.PageLocation;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    public SignUpCommand() {
    }

    public String execute(HttpServletRequest request) {
        String pathToPage;

        String firstName = request.getParameter(HttpRequestParameter.FIRST_NAME);
        String lastName = request.getParameter(HttpRequestParameter.LAST_NAME);
        String middleName = request.getParameter(HttpRequestParameter.MIDDLE_NAME);
        String login = request.getParameter(HttpRequestParameter.LOGIN);
        String password = request.getParameter(HttpRequestParameter.PASSWORD);
        Boolean isTeacher = Boolean.valueOf(request.getParameter(HttpRequestParameter.IS_TEACHER)); // не забыть проверить, подходит или нет

        DaoFactory mySqlDaoFactory = DaoFactory.getDaoFactory(SourceType.MY_SQL);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setIsTeacher(isTeacher);

        UserDao userDao = mySqlDaoFactory.getUserDao();
        userDao.create(user);

        int userId = userDao.getUserByLoginInfo(login, password).getId();
        if (isTeacher) {
            Teacher teacher = new Teacher(firstName, lastName, middleName);
            teacher.setUserId(userId);
            // добавить столбец в БД (связать таблицы)
            // в метод create и запрос добавить поле userId

            mySqlDaoFactory.getTeacherDao().create(teacher);
            pathToPage = PageLocation.getInstance().getPageLocation(PageLocationKey.TEACHER_PROFILE);
        }
        else {
            Student student = new Student(firstName, lastName, middleName);
            student.setUserId(userId);
            // то же, что для учителя

            mySqlDaoFactory.getStudentDao().create(student);
            pathToPage = PageLocation.getInstance().getPageLocation(PageLocationKey.STUDENT_PROFILE);
        }

        return pathToPage;
    }
}
