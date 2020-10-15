package com.baogong.pojo;

import java.util.Arrays;

public class PublicUserTaskPick {
    private String userName;
    private String date[];
    private String proName;
    private String workTec;
    private int pageNum;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getWorkTec() {
        return workTec;
    }

    public void setWorkTec(String workTec) {
        this.workTec = workTec;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    @Override
    public String toString() {
        return "PublicUserTaskPick{" +
                "UserName='" + userName + '\'' +
                ", date=" + Arrays.toString(date) +
                ", proName='" + proName + '\'' +
                ", workTec='" + workTec + '\'' +
                '}';
    }
}
