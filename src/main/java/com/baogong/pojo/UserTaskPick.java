package com.baogong.pojo;

import java.util.Arrays;

public class UserTaskPick {
    private String user_id;
    private String date[];
    private String proName;
    private int pageNum;
    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

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

    @Override
    public String toString() {
        return "UserTaskPick{" +
                "user_id='" + user_id + '\'' +
                ", date=" + Arrays.toString(date) +
                ", proName='" + proName + '\'' +
                ", pageNum=" + pageNum +
                '}';
    }
}
