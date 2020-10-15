package com.baogong.pojo;

public class CheckerUserPick {
    private String user_local_name;
    private String user_id;
    private String user_name;
    private int identify;
    private int pageNum;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getUser_local_name() {
        return user_local_name;
    }

    public void setUser_local_name(String user_local_name) {
        this.user_local_name = user_local_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }
}
