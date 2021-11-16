package com.example.toife;

public class UserHelperClass_Therapy {
    String Name1, email1, pass1, Uid ,type;

    public UserHelperClass_Therapy() {
    }

    public UserHelperClass_Therapy(String name1, String email1, String pass1, String uid , String type) {
        this.Name1 = name1;
        this.Uid = uid;
        this.email1 = email1;
        this.pass1 = pass1;
        this.type = type;


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
}