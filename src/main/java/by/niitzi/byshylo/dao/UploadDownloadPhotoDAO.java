package by.niitzi.byshylo.dao;

import by.niitzi.byshylo.db.ConnectionPool;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.util.ApplicationProperties;

import javax.xml.registry.infomodel.User;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UploadDownloadPhotoDAO {

    private static UploadDownloadPhotoDAO uploadDownloadPhotoDAO;
    private static final String UPLOAD_PHOTO_MSQL = "insert into user_photo (firstName, lastName, photoName, photo) values (?, ?, ?, ?)";//mysql
    private static final String SHOW_ALL_TO_DOWNLOAD_MSQL = "select id, firstName, lastName, photoName, added_date from user_photo";
    private static final String GET_ID = "select photo from user_photo where id=?";
   // private static final String UPLOAD_PHOTO_PSQL = "insert into \"userfile\"(firstName, lastName, photo) values (?, ?, ?)";//postgresql

    public UploadDownloadPhotoDAO(){}

    public UploadDownloadPhotoDAO(UploadDownloadPhotoDAO uploadDownloadPhotoDAO) {

    }

    public static UploadDownloadPhotoDAO getInstance(){
        if(uploadDownloadPhotoDAO == null){
            uploadDownloadPhotoDAO = new UploadDownloadPhotoDAO();
        }
        return uploadDownloadPhotoDAO;
    }

//    public int uploadFile(String firstName, String lastName, InputStream file) throws ClassNotFoundException {//if the structure of the project without Entity
//        int row  = 0;
//        try {
//            ConnectionPool.CONNECTION_POOL.init();
//            Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
//            connection.setAutoCommit(false);
//            PreparedStatement statement = connection.prepareStatement(UPLOAD_PHOTO_MSQL);
//            statement.setString(1,firstName);
//            statement.setString(2,lastName);
//
//            if(file != null){
//                statement.setBlob(3,file);
//            }
//            row = statement.executeUpdate();
//
//            connection.commit();
//        }catch (SQLException e) {
//            printSqlException(e);
//        }
//        return row;
//    }

    public Optional<UserPhoto> uploadPhotoFile(UserPhoto user) throws ClassNotFoundException {
        try {
            Class.forName(ApplicationProperties.APPLICATION_PROPERTIES.getDbDriverMysql());

            Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();

            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPLOAD_PHOTO_MSQL);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());

            if(user.getFile() != null){
                statement.setString(3, user.getPhotoName());
                statement.setBlob(4,user.getFile());
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

    private UserPhoto parseUsers(ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        //Blob photo = rs.getBlob("photoName");
        String photoName = rs.getString("photoName");
        Timestamp addedDate = rs.getTimestamp("added_date");
        return new UserPhoto(id, firstName, lastName, photoName, addedDate);
    }

    public List<UserPhoto> showAllToDownloadPhoto(){
        List<UserPhoto> users = new ArrayList<>();
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement  statement = connection.prepareStatement(SHOW_ALL_TO_DOWNLOAD_MSQL)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                users.add(parseUsers(rs));
            }
        }catch (SQLException e){
            printSqlException(e);
        }
        return users;
    }

    public InputStream getDbFileInputStreamById(String id){
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_ID)){
            //UserPhoto userPhoto = null;
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               // System.out.println(parseUsers(statement.getResultSet()).getPhotoName());
                return resultSet.getBinaryStream(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
///посмотреть где, в каком месте используется destroy, куда его вставить вместе с closeAll