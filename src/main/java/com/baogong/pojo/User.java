package com.baogong.pojo;

public class User {
    private int id;
    private String user_id;
    private String user_name;
    private String user_local;
    private String user_local_name;
    private String password;
    private int identify;
    private String user_telephone;
    private String sex;
    private int year_old;
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_local() {
        return user_local;
    }

    public void setUser_local(String user_local) {
        this.user_local = user_local;
    }

    public String getUser_local_name() {
        return user_local_name;
    }

    public void setUser_local_name(String user_local_name) {
        this.user_local_name = user_local_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public String getUser_telephone() {
        return user_telephone;
    }

    public void setUser_telephone(String user_telephone) {
        this.user_telephone = user_telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYear_old() {
        return year_old;
    }

    public void setYear_old(int year_old) {
        this.year_old = year_old;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_local='" + user_local + '\'' +
                ", user_local_name='" + user_local_name + '\'' +
                ", password='" + password + '\'' +
                ", identify=" + identify +
                ", user_telephone='" + user_telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", year_old=" + year_old +
                '}';
    }
}
