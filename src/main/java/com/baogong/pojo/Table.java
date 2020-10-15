package com.baogong.pojo;


//用户填表提交过来的
public class Table {
    private String user_id;
    private String user_name;
    private String date;        //日期
    private String workType;			//报工单单别
    private String reportType;			//工单单别
    private String reportId;
    private String macName;				//机器名称
    private String macId;				//机器编号
    private String proName;			//产品名称
    private String proSize;			//产品规格
    private String proId;           //产品编号
    private String workTec;				//工艺
    private String workTecId;           //工艺id
    private String workProcedure;		//工序
    private Double failNum;			//转移类型  // 已经修改成报废数量
    private Double transferNum;			//转移数量
    private String  calType;	 			//计算类型
    private  Double work_hour;      //工时
    private  Double mac_hour;      //工时
    private String workSection;         //工段中心
    private String workSectionName;
    private String info;
    private String workTime;

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getMac_hour() {
        return mac_hour;
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

    public void setMac_hour(Double mac_hour) {
        this.mac_hour = mac_hour;
    }

    public String getWorkSection() {
        return workSection;
    }

    public void setWorkSection(String workSection) {
        this.workSection = workSection;
    }

    public String getReportId() {
        return reportId;
    }
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
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

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
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

    public double getWork_hour() {
        return work_hour;
    }

    public void setWork_hour(double work_hour) {
        this.work_hour = work_hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setWork_hour(Double work_hour) {
        this.work_hour = work_hour;
    }

    @Override
    public String toString() {
        return "Table{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", workType='" + workType + '\'' +
                ", reportType='" + reportType + '\'' +
                ", macName='" + macName + '\'' +
                ", macId='" + macId + '\'' +
                ", proName='" + proName + '\'' +
                ", proSize='" + proSize + '\'' +
                ", workTec='" + workTec + '\'' +
                ", workProcedure='" + workProcedure + '\'' +
                ", transferType='" + failNum + '\'' +
                ", transferNum=" + transferNum +
                ", calType='" + calType + '\'' +
                '}';
    }
}
