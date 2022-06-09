package by.niitzi.byshylo.command.impl;

import by.niitzi.byshylo.command.Command;
import by.niitzi.byshylo.command.CommandResult;
import by.niitzi.byshylo.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ToUploadPhotoCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, ServletException, IOException {
        return new CommandResult("WEB-INF/upload-file.jsp", CommandResult.ResponseType.FORWARD);
    }
}
