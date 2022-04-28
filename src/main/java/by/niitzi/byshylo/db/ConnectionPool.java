package by.niitzi.byshylo.db;

import by.niitzi.byshylo.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {
    private final ConcurrentLinkedQueue<Connection> availableConnection = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Connection> usedConnection = new ConcurrentLinkedQueue<>();

    private final int initSize = ApplicationProperties.APPLICATION_PROPERTIES.getInitSize();
    private final int maxSize = ApplicationProperties.APPLICATION_PROPERTIES.getMaxSize();
    
    private final String dbUrlPostgres = ApplicationProperties.APPLICATION_PROPERTIES.getDbUrlPostgres();
    private final String loginPostgres = ApplicationProperties.APPLICATION_PROPERTIES.getLoginPostgres();
    private final String passwordPostgres = ApplicationProperties.APPLICATION_PROPERTIES.getPasswordPostgres();
    private final String dbDriverPostgres = ApplicationProperties.APPLICATION_PROPERTIES.getDbDriverPostgres();

    private final String dbUrlMysql = ApplicationProperties.APPLICATION_PROPERTIES.getDbUrlMysql();
    private final String loginMysql = ApplicationProperties.APPLICATION_PROPERTIES.getLoginMysql();
    private final String passwordMysql = ApplicationProperties.APPLICATION_PROPERTIES.getPasswordMysql();
    private final String dbDriverMysql = ApplicationProperties.APPLICATION_PROPERTIES.getDbDriverMysql();
    
    private ConnectionPool(){}
    
    public final static ConnectionPool CONNECTION_POOL = new ConnectionPool();
    
    public Connection getConnection(){
        Connection connection;
        if(availableConnection.isEmpty() && (usedConnection.size() + usedConnection.size() + 5 < maxSize)){
            for (int i = 0; i < 5; i++) {
                addConnectionMysql();
                //addConnectionPostgres();
            }
        }
            connection = availableConnection.poll();
            usedConnection.add(connection);
        return connection;
    }
    
    public void init() throws ClassNotFoundException {
        Class.forName(dbDriverMysql);
       // Class.forName(dbDriverPostgres);

        for (int i = 0; i < initSize; i++) {
            addConnectionMysql();
            //addConnectionPostgres();
        }
    }
    
    private Connection addConnectionMysql(){
        Connection connection = null;
        try{
            connection = new ConnectionProxy(DriverManager.getConnection(dbUrlMysql, loginMysql, passwordMysql));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        availableConnection.add(connection);
        return connection;
    }
    private Connection addConnectionPostgres(){
        Connection connection = null;
        try{
            connection = new ConnectionProxy(DriverManager.getConnection(dbUrlPostgres, loginPostgres, passwordPostgres));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        availableConnection.add(connection);
        return connection;
    }
    
    public void returnConnection(Connection connection){
        usedConnection.remove(connection);
        availableConnection.add(connection);
    }
    
    public void closeAll() throws SQLException {
        for (Connection connection:availableConnection) {
            ((ConnectionProxy)connection).realClose();
        }

        for (Connection con : usedConnection) {
            ((ConnectionProxy)con).realClose();
        }
    }
}
