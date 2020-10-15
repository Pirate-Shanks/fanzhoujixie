package com.baogong.pojo;

import java.util.Comparator;

//返回到查询或者审核页面的表单
public class CompleteTable implements Comparable {
    private int id;
    private String user_id;
    private String user_name;
    private String workType;			//报工单单别
    private String workId;
    private String workNum;
    private String reportType;			//工单单别
    private String reportId;
    private String macName;				//机器名称
    private String macId;				//机器编号
    private String proId;
    private String proName;			//产品名称
    private String proSize;			//产品规格
    private String workTec;				//工艺
    private String workProcedure;		//工序
    private Double failNum;			//转移类型
    private Double transferNum;			//转移数量
    private int  calType;				//计算类型
    private int state;         //审核码
    private String date;
    private Double work_hour;
    private Double mac_hour;
    private String workSection;
    private String primaryId;
    private String workTecId;
    private String workSectionName;
    private String user_local_name;
    private String info;
    private String back_info;
    private String workTime;

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getBack_info() {
        return back_info;
    }

    public void setBack_info(String back_info) {
        this.back_info = back_info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUser_local_name() {
        return user_local_name;
    }

    public void setUser_local_name(String user_local_name) {
        this.user_local_name = user_local_name;
    }

    public String getWorkTecId() {
        return workTecId;
    }

    public void setWorkTecId(String workTecId) {
        this.workTecId = workTecId;
    }

    public String getWorkSectionName() {
        return workSectionName;
    }

    public void setWorkSectionName(String workSectionName) {
        this.workSectionName = workSectionName;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public Double getMac_hour() {
        return mac_hour;
    }

    public void setMac_hour(Double mac_hour) {
        this.mac_hour = mac_hour;
    }

    public String getWorkSection() {
        return workSection;
    }

    public void setWorkSection(String workSection) {
        this.workSection = workSection;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getMacName() {
        return macName;
    }

    public void setMacName(String macName) {
        this.macName = macName;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public String getWorkTec() {
        return workTec;
    }

    public void setWorkTec(String workTec) {
        this.workTec = workTec;
    }

    public String getWorkProcedure() {
        return workProcedure;
    }

    public void setWorkProcedure(String workProcedure) {
        this.workProcedure = workProcedure;
    }

    public Double getFailNum() {
        return failNum;
    }

    public void setFailNum(Double failNum) {
        this.failNum = failNum;
    }

    public Double getTransferNum() {
        return transferNum;
    }

    public void setTransferNum(Double transferNum) {
        this.transferNum = transferNum;
    }

    public int getCalType() {
        return calType;
    }

    public void setCalType(int calType) {
        this.calType = calType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getWork_hour() {
        return work_hour;
    }

    public void setWork_hour(Double work_hour) {
        this.work_hour = work_hour;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "CompleteTable{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", workType='" + workType + '\'' +
                ", workId='" + workId + '\'' +
                ", workNum='" + workNum + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportId='" + reportId + '\'' +
                ", macName='" + macName + '\'' +
                ", macId='" + macId + '\'' +
                ", proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", proSize='" + proSize + '\'' +
                ", workTec='" + workTec + '\'' +
                ", workProcedure='" + workProcedure + '\'' +
                ", failNum=" + failNum +
                ", transferNum=" + transferNum +
                ", calType=" + calType +
                ", state=" + state +
                ", date='" + date + '\'' +
                ", work_hour=" + work_hour +
                ", mac_hour=" + mac_hour +
                ", workSection='" + workSection + '\'' +
                ", primaryId='" + primaryId + '\'' +
                ", workTecId='" + workTecId + '\'' +
                ", workSectionName='" + workSectionName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return -(this.getDate().compareTo (((CompleteTable)o).getDate()));
    }
}
