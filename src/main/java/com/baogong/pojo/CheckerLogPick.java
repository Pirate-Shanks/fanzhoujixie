package com.baogong.pojo;

public class CheckerLogPick {
   private String date[];
   private String workSection;
   public  int pageNum;

   public int getPageNum() {
      return pageNum;
   }

   public void setPageNum(int pageNum) {
      this.pageNum = pageNum;
   }

   public String[] getDate() {
      return date;
   }

   public void setDate(String[] date) {
      this.date = date;
   }

   public String getWorkSection() {
      return workSection;
   }

   public void setWorkSection(String workSection) {
      this.workSection = workSection;
   }
}
