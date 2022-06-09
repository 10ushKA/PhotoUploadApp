package by.niitzi.byshylo.command.impl;

import by.niitzi.byshylo.command.Command;
import by.niitzi.byshylo.command.CommandResult;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.exception.ServiceException;
import by.niitzi.byshylo.service.UserPhotoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToDownloadPhotoCommand implements Command {

    private UserPhotoService userPhotoService = UserPhotoService.getInstance();

    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException {
        List<UserPhoto> allUserPhoto = userPhotoService.showAllToDownloadPhoto();

        CommandResult commandResult = new CommandResult("WEB-INF/download-table.jsp", CommandResult.ResponseType.FORWARD);
        commandResult.addAttribute("users", allUserPhoto);
        return commandResult;
    }
}
