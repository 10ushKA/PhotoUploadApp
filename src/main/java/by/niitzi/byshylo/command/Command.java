package by.niitzi.byshylo.command;

import by.niitzi.byshylo.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Command {
    CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, ServletException, IOException;
}
