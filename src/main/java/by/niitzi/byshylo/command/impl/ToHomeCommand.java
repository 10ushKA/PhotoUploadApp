package by.niitzi.byshylo.command.impl;

import by.niitzi.byshylo.command.Command;
import by.niitzi.byshylo.command.CommandResult;
import by.niitzi.byshylo.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ToHomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException {
        return new CommandResult("WEB-INF/jsp/homePage.jsp", CommandResult.ResponseType.FORWARD);
    }
}
