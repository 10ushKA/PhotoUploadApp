package by.niitzi.byshylo.util;

import java.util.ResourceBundle;

public class ApplicationProperties {
    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();

    private String dbUrlPostgres;
    private String loginPostgres;
    private String passwordPostgres;
    private String dbDriverPostgres;

    private String dbUrlMysql;
    private String loginMysql;
    private String passwordMysql;
    private String dbDriverMysql;

    private int initSize;
    private int maxSize;

    public ApplicationProperties(){
        init();
    }

    private void init(){
        ResourceBundle pr = ResourceBundle.getBundle("config");
        dbUrlPostgres = pr.getString("db.url.postgres");
        loginPostgres = pr.getString("db.login.postgres");
        passwordPostgres = pr.getString("db.password");
        dbDriverPostgres = pr.getString("db.driver.postgres");

        dbUrlMysql = pr.getString("db.url.mysql");
        loginMysql = pr.getString("db.login.mysql");
        passwordMysql = pr.getString("db.password");
        dbDriverMysql = pr.getString("db.driver.mysql");

        initSize = Integer.parseInt(pr.getString("cp.init.size"));
        maxSize = Integer.parseInt(pr.getString("cp.max.size"));

    }

    public String getDbUrlPostgres() {
        return dbUrlPostgres;
    }

    public String getLoginPostgres() {
        return loginPostgres;
    }

    public String getPasswordPostgres() {
        return passwordPostgres;
    }

    public String getDbDriverPostgres() {
        return dbDriverPostgres;
    }

    public String getDbUrlMysql() {
        return dbUrlMysql;
    }

    public String getLoginMysql() {
        return loginMysql;
    }

    public String getPasswordMysql() {
        return passwordMysql;
    }

    public String getDbDriverMysql() {
        return dbDriverMysql;
    }

    public int getInitSize() {
        return initSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
