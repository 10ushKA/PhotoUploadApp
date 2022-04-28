package by.niitzi.byshylo.service;

import by.niitzi.byshylo.dao.UserPhotoUploadDAO;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.exception.ServiceException;

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

    private final UserPhotoUploadDAO userPhotoUploadDAO = UserPhotoUploadDAO.getInstance();

    public Optional<UserPhoto> uploadPhotoFile(UserPhoto user) throws ServiceException {
        try{
            return userPhotoUploadDAO.uploadPhotoFile(user);
        }catch (Exception e){
            throw new ServiceException("FileUpload DAO provides exception in service: " + e.getMessage());
        }
    }
}
////Exception-ы прописать: sqlexception(из ДАО)
//сервлет, отсылаться на Сервис , а не на ДАО