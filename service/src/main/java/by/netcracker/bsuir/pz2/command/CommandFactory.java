package by.netcracker.bsuir.pz2.command;

import by.netcracker.bsuir.pz2.constantString.HttpRequestParameter;
import by.netcracker.bsuir.pz2.enumeration.CommandType;

import javax.servlet.http.HttpServletRequest;

public enum  CommandFactory {

    INSTANCE;

    public Command createCommand (HttpServletRequest request) {
        CommandType commandType = defineCommand(request);
        return commandType.getCommandOfThisType();
    }

    private CommandType defineCommand(HttpServletRequest request) {
        String httpRequestParameterValue = request.getParameter(HttpRequestParameter.COMMAND);

        CommandType commandType = CommandType.EMPTY;
        try {
            commandType = CommandType.valueOf(httpRequestParameterValue.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Пустой или недопустимый аргумент в HTTP запросе (CommandFactory)");
            e.printStackTrace();
        }
        return commandType;
    }
}
