package com.baogong.Utils;

import com.baogong.dao.ManagerControlDao;
import com.baogong.pojo.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class IsAllowedUtils {
    @Autowired
    private ManagerControlDao managerControlDao;

   private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Boolean isAllowedLogin(){
        Date beginDate=null;
        Date endDate=null;
        Date nowDate=new Date();//获取当前时间
        //获取当前日期
        Date date = new Date();
        String pre = sdf.format(date);
        SystemInfo info = managerControlDao.getSystemInfo();
        if(!info.getStart_time1().equals("")&&!info.getEnd_time1().equals("")){
            try{
                beginDate = sdf2.parse(pre+" "+info.getStart_time1()+":00");
                endDate = sdf2.parse(pre+" "+info.getEnd_time1()+":00");
            }catch (Exception e){
                System.out.println(e);
            }
            Calendar ndate = Calendar.getInstance();
            ndate.setTime(nowDate);
            Calendar begin = Calendar.getInstance();
            begin.setTime(beginDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            if (ndate.after(begin) && ndate.before(end)) {
                return false;
            }
        }
        if(!info.getStart_time2().equals("")&&!info.getEnd_time2().equals("")){
            try{
                beginDate = sdf2.parse(pre+" "+info.getStart_time2()+":00");
                endDate = sdf2.parse(pre+" "+info.getEnd_time2()+":00");
            }catch (Exception e){
                System.out.println(e);
            }
            Calendar ndate = Calendar.getInstance();
            ndate.setTime(nowDate);
            Calendar begin = Calendar.getInstance();
            begin.setTime(beginDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            if (ndate.after(begin) && ndate.before(end)) {
                return false;
            }
        }
        return  true;

    }
    public Boolean isAllowedSubmit(String date){
        if(isNewzt(date, 3* 24 * 60 * 60 * 1000)){
            return true;
        }else {
            return false;
        }
    }
    private  boolean isNewzt(String theStrTime, long beforeDays)
   {
       boolean flag = false;
       if("0".equals(theStrTime))
       {
           return flag;
       }
       try {
           Date tDat = StrToDate(theStrTime, "");
           long thm = tDat.getTime();
           long chm=System.currentTimeMillis();
           if(thm + beforeDays >=chm) {
               flag = true;
           }
       } catch(Exception e) {
           e.printStackTrace();
       }
       return flag;
   }
    private static Date StrToDate(String str, String formatStr)
   {
       if (null == formatStr || "".equals(formatStr)) {
           formatStr = "yyyy-MM-dd";
       }
       SimpleDateFormat format = new SimpleDateFormat(formatStr);
       Date date = null;
       try {
           date = format.parse(str);
       } catch(Exception e) {
           e.printStackTrace();
       }
       return date;
   }



}
