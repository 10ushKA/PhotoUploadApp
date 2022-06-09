package by.niitzi.byshylo.command;

import by.niitzi.byshylo.command.impl.*;

public enum CommandType {
    TO_HOME(new ToHomeCommand()),
    TO_DOWNLOAD(new ToDownloadPhotoCommand()),
    TO_UPLOAD(new ToUploadPhotoCommand()),
    DOWNLOAD_PHOTO(new DownloadPhotoCommand()),
    UPLOAD_PHOTO(new UploadPhotoCommand()),
    TO_MESSAGE_PAGE(new ToMessagePageCommand())
    ;

    private final Command command;

    CommandType(Command command){
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
