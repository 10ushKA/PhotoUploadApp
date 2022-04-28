package by.niitzi.byshylo.dao;

import by.niitzi.byshylo.db.ConnectionPool;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.util.ApplicationProperties;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserPhotoUploadDAO {
    //преписать ДАО уровень, сервис,

    private static UserPhotoUploadDAO userPhotoUploadDAO;
    private static final String UPLOAD_PHOTO_MSQL = "insert into user_photo (firstName, lastName, photo) values (?, ?, ?)";//mysql
   // private static final String UPLOAD_PHOTO_PSQL = "insert into \"userfile\"(firstName, lastName, photo) values (?, ?, ?)";//postgresql

    public UserPhotoUploadDAO(){}

    public static UserPhotoUploadDAO getInstance(){
        if(userPhotoUploadDAO == null){
            userPhotoUploadDAO = new UserPhotoUploadDAO();
        }
        return userPhotoUploadDAO;
    }


    //private final String sql = "insert into \"userfile\"(firstName, lastName, photo) values (?, ?, ?)";//postgresql
    //private final String sql = "insert into user_photo (firstName, lastName, photo) values (?, ?, ?)";//mysql

    public int uploadFile(String firstName, String lastName, InputStream file) throws ClassNotFoundException {//if the structure of the project without Entity
        int row  = 0;
        try {
            ConnectionPool.CONNECTION_POOL.init();
            Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPLOAD_PHOTO_MSQL);
            statement.setString(1,firstName);
            statement.setString(2,lastName);

            if(file != null){
                statement.setBlob(3,file);
            }
            row = statement.executeUpdate();

            connection.commit();
        }catch (SQLException e) {
            printSqlException(e);
        }
        return row;
    }

    public Optional<UserPhoto> uploadPhotoFile(UserPhoto user) throws ClassNotFoundException {
        try {
            Class.forName(ApplicationProperties.APPLICATION_PROPERTIES.getDbDriverMysql());

            Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();

            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPLOAD_PHOTO_MSQL);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());


            if(user.getFile() != null){
                statement.setBlob(3,user.getFile());
            }
            statement.execute();
            connection.commit();
            return Optional.of(user);

        }catch (SQLException e) {
            printSqlException(e);
        }
        return null;
        //мб и не user надо возвращать???!!!/ изменить название entity? userInfo? userPortfolio ? userFile? userPhoto
    }


    private void printSqlException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SqlState: " + ((SQLException) e).getSQLState());
                System.err.println("Error code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }}
