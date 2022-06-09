package by.niitzi.byshylo.exception;

public class ServiceException extends Exception{//when the service is not accessible or not defined properly and has some errors
    public ServiceException(){
    }

    public ServiceException(String message){super(message);}
}
