package com.baogong.Utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimaryGenerater {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private volatile static int prenum=0;
   // private AtomicInteger myNum = new AtomicInteger(0);
//    public synchronized static String getId() {
//        //获取时间部分字符串
//        Date now = new Date();
//        String nowStr = sdf.format(now);
//        int nowNum = (prenum+1000)%2000+1000+1;
//        prenum=nowNum;
//        String str = (nowNum+"").substring(1);
//        return nowStr+str;
//    }
    public synchronized static String getId(String date,int AlltodaySize) {
//        prenum=AlltodaySize;
        String nowStr = date.replace("-","");
        int nowNum = (AlltodaySize+1000)%2000+1000+1;
        prenum=nowNum;
        String str = (nowNum+"").substring(1);
        return nowStr+str;
    }
    public synchronized static String getCreatDate() {
        //获取时间部分字符串
        Date now = new Date();
        String nowStr = sdf2.format(now);
        return nowStr;
    }
    public synchronized static String getInsertCreatDate() {
        //获取时间部分字符串
        Date now = new Date();
        String nowStr = sdf3.format(now);
        return nowStr;
    }
    public  static String getToday(){
        Date now = new Date();
        String nowStr = sdf.format(now);
        return nowStr;
    }
    public synchronized static String getNewDayId(String date) {
        //获取时间部分字符串
        prenum=0;
        String nowStr = date.replace("-","");
        int nowNum = (prenum+1000)%2000+1000+1;
        prenum=nowNum;
        String str = (nowNum+"").substring(1);
        return nowStr+str;
    }

    public static String getAddOrDelDate(){
        Date now = new Date();
        String nowStr = sdf4.format(now);
        return nowStr;
    }
}

