package by.niitzi.byshylo.service;

import by.niitzi.byshylo.dao.UploadDownloadPhotoDAO;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.exception.ServiceException;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class UserPhotoService {
    public UserPhotoService(){
    }

    private static UserPhotoService userPhotoService;

    public static UserPhotoService getInstance(){
        if(userPhotoService == null){
            userPhotoService = new UserPhotoService();
        }
        return userPhotoService;
    }

    private final UploadDownloadPhotoDAO uploadDownloadPhotoDAO = UploadDownloadPhotoDAO.getInstance();

    public Optional<UserPhoto> uploadPhotoFile(UserPhoto user) throws ServiceException {
        try{
            return uploadDownloadPhotoDAO.uploadPhotoFile(user);
        }catch (Exception e){
            throw new ServiceException("UploadDownloadPhoto DAO provides exception in service: " + e.getMessage());
        }
    }

    public List<UserPhoto> showAllToDownloadPhoto() throws ServiceException {
        try{
            return uploadDownloadPhotoDAO.showAllToDownloadPhoto();
        }catch (Exception e){
            throw new ServiceException("UploadDownloadPhoto DAO provides exception in service: " + e.getMessage());
        }
    }

    public InputStream getDbFileInputStreamById(String id) throws ServiceException {
        try {
            return uploadDownloadPhotoDAO.getDbFileInputStreamById(id);
        }catch (Exception e){
            throw new ServiceException("UploadDownloadPhoto DAO provides exception in service: " + e.getMessage());
        }
    }
}