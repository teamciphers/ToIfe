package com.example.toife;

public class UserHelperClass {
    String Name1,email1, pass1,Uid ,type , bio_user;

    public UserHelperClass() {
    }

    public UserHelperClass(String name1,String email1, String pass1 , String uid , String type , String bio_user) {
        this.Name1 = name1;
        this.Uid = uid;
        this.email1 = email1;
        this.pass1 = pass1;
        this.type = type;
        this.bio_user = bio_user;


    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }


    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getuid() {
        return Uid;
    }

    public void setuid(String uid) {
        Uid = uid;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getbio_user() {
        return bio_user;
    }

    public void setbio_user(String bio_user) { this.bio_user = bio_user;}

}
