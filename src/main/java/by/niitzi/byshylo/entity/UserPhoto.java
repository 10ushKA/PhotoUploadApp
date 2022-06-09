package by.niitzi.byshylo.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

public class UserPhoto {
    String id;
    String firstName;
    String lastName;
    String photoName;
    Blob photo;
    Timestamp addedDate;
    InputStream file;
    ByteArrayInputStream ph;


    public UserPhoto(){}

    public UserPhoto(String id, String firstName, String lastName, String photoName, Timestamp addedDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoName = photoName;
        this.addedDate = addedDate;
    }
    public UserPhoto(String firstName, String lastName, String photoName, InputStream file ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoName = photoName;
        this.file = file;
    }

    public UserPhoto(String firstName, String lastName, ByteArrayInputStream ph ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ph = ph;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
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

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
