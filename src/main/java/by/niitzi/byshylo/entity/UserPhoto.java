package by.niitzi.byshylo.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

public class UserPhoto {
    String firstName;
    String lastName;
    Blob photo;
    InputStream file;
    ByteArrayInputStream ph;


    public UserPhoto(){}

    public UserPhoto(String firstName, String lastName, Blob photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }
    public UserPhoto(String firstName, String lastName, InputStream file ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.file = file;
    }

    public UserPhoto(String firstName, String lastName, ByteArrayInputStream ph ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ph = ph;
    }

    public ByteArrayInputStream getPh() {
        return ph;
    }

    public void setPh(ByteArrayInputStream ph) {
        this.ph = ph;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
