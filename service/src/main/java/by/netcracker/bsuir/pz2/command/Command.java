package by.netcracker.bsuir.pz2.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    public String execute(HttpServletRequest request);
}
