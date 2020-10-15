package com.baogong.pojo;

public class SystemInfo {
    private String iscontrol;
    private String start_time1;
    private String end_time1;
    private String start_time2;
    private String end_time2;

    public String getIscontrol() {
        return iscontrol;
    }

    public void setIscontrol(String iscontrol) {
        this.iscontrol = iscontrol;
    }

    public String getStart_time1() {
        return start_time1;
    }

    public void setStart_time1(String start_time1) {
        this.start_time1 = start_time1;
    }

    public String getEnd_time1() {
        return end_time1;
    }

    public void setEnd_time1(String end_time1) {
        this.end_time1 = end_time1;
    }

    public String getStart_time2() {
        return start_time2;
    }

    public void setStart_time2(String start_time2) {
        this.start_time2 = start_time2;
    }

    public String getEnd_time2() {
        return end_time2;
    }

    public void setEnd_time2(String end_time2) {
        this.end_time2 = end_time2;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "iscontrol='" + iscontrol + '\'' +
                ", start_time1='" + start_time1 + '\'' +
                ", end_time1='" + end_time1 + '\'' +
                ", start_time2='" + start_time2 + '\'' +
                ", end_time2='" + end_time2 + '\'' +
                '}';
    }
}
