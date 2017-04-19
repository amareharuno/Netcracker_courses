package by.netcracker.bsuir.pz2.command.common;

import by.netcracker.bsuir.pz2.command.Command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    public EmptyCommand() {
    }

    public String execute(HttpServletRequest request) {
        String pathToPage = null;

        return null;
    }
}
