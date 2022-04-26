package by.niitzi.byshylo.dao;

import by.niitzi.byshylo.entity.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileUploadDAO {
//    private final String url = "jdbc:postgresql://localhost:8080/FinalTaskDatabase";
//    private final String login = "postgres";
//    private final String password = "root";
//    private final String driver  = "org.postgresql.Driver";

    private final String url = "jdbc:mysql://localhost:3306/userfile?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//[host]:[port]/[db]
    private final String login = "root";
    private final String password = "root";
    private final String driver  = "com.mysql.jdbc.Driver";


    //private final String sql = "insert into \"userfile\"(firstName, lastName, photo) values (?, ?, ?)";//postgresql
    private final String sql = "insert into user_photo (firstName, lastName, photo) values (?, ?, ?)";//mysql

    public int uploadFile(String firstName, String lastName, InputStream file){
        int row  = 0;
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
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

    public User uploadPhotoFile(User user){
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());


//            if(user.getFile() != null){
//                ///statement.setBlob(3,user.getFile());
//                statement.setBlob(3,user.getFile());
//            }
            statement.setBlob(3,user.getPhoto());
            /////statement.set(3,user.getPh());
            if(user.getPhoto() != null){
                ///statement.setBlob(3,user.getFile());
                statement.setBlob(3,user.getPhoto());
            }

            statement.execute();
            connection.commit();
            return user;

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
