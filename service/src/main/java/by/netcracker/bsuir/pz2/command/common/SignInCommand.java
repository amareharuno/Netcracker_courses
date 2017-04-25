package by.netcracker.bsuir.pz2.command.common;

import by.netcracker.bsuir.pz2.command.Command;
import by.netcracker.bsuir.pz2.constantString.HttpRequestParameter;
import by.netcracker.bsuir.pz2.entity.User;
import by.netcracker.bsuir.pz2.enumeration.PageLocationKey;
import by.netcracker.bsuir.pz2.enumeration.SourceType;
import by.netcracker.bsuir.pz2.factory.DaoFactory;
import by.netcracker.bsuir.pz2.factory.MySqlDaoFactory;
import by.netcracker.bsuir.pz2.propertyManager.PageLocation;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    public SignInCommand() {
    }

    public String execute(HttpServletRequest request) {
        String pathToPage;
        boolean withErrorMessage;

        String login = request.getParameter(HttpRequestParameter.LOGIN);
        String password = request.getParameter(HttpRequestParameter.PASSWORD);

        DaoFactory mySqlDaoFactory = MySqlDaoFactory.INSTANSE;

        User user = mySqlDaoFactory.getUserDao().getUserByLoginInfo(login, password);

        if (user == null) {
            withErrorMessage = true;
            pathToPage = PageLocation.INSTANCE.getPageLocation(PageLocationKey.SIGN_IN_PAGE);
            // такого пользователя не существует (поменять signInPage.html на signInPage.jsp)
        } else {
            withErrorMessage = false;
            pathToPage = PageLocation.INSTANCE.getPageLocation(PageLocationKey.STUDENT_PROFILE);
            // связать user с teacher & student. Узнать, чей профиль открывать
        }

        return pathToPage;
    }
}
