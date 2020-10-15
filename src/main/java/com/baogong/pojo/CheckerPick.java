package com.baogong.pojo;

import java.util.Arrays;

public class CheckerPick {
    private String user_id;
    private String[] date;
    private String proName;
    private String employeeName;
    private String workSection;
    private int pageNum;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getWorkSection() {
        return workSection;
    }

    public void setWorkSection(String workSection) {
        this.workSection = workSection;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CheckerPick{" +
                "user_id='" + user_id + '\'' +
                ", date=" + Arrays.toString(date) +
                ", proName='" + proName + '\'' +
                '}';
    }
}

