package com.baogong.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdCreator {
//    yyyyMMddHHmmssSSS
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    /**
     * 获取主键
     * @param length 长度
     * @return 返回17位时间戳+3位递增数
     */
    public synchronized static String getId(int length) {
        //获取时间部分字符串
        Date now = new Date();
        String nowStr = sdf.format(now);
        String result = nowStr.substring(0,8)+nowStr.substring(14);
        return result;
    }
    public synchronized static String getId2(int length) {
        //获取时间部分字符串
        Date now = new Date();
        String nowStr = sdf.format(now);
        String result = nowStr.substring(0,9)+nowStr.substring(15);
        return result;
    }
}
