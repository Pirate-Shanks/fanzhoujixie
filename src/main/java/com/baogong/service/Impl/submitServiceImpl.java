package com.baogong.service.Impl;

import com.baogong.Utils.IdCreator;
import com.baogong.Utils.PrimaryGenerater;
import com.baogong.dao.TaskDao;
import com.baogong.dao.UserDao;
import com.baogong.dao.WorkSectionDao;
import com.baogong.dao.fzjx.fzjxDao;
import com.baogong.pojo.CompleteTable;
import com.baogong.pojo.Table;
import com.baogong.pojo.TaskItem;
import com.baogong.pojo.User;
import com.baogong.service.submitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class submitServiceImpl implements submitService {

    @Autowired
   private fzjxDao fzjx;

    @Autowired
    private  TaskDao taskDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private WorkSectionDao workSectionDao;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public int submit(Table table) {
        TaskItem taskItem = new TaskItem();
        if(table.getDate().length()==9) {
            StringBuffer sb = new StringBuffer(table.getDate());
            sb.insert(8,"0");
            table.setDate(sb.toString());
        }else if(table.getDate().length()==8){
            StringBuffer sb = new StringBuffer(table.getDate());
            sb.insert(5,"0");
            sb.insert(8,"0");
            table.setDate(sb.toString());
        }
        taskItem.setTE001(table.getWorkType());
        String workSectionId = table.getWorkSection();
        taskItem.setTE004(table.getUser_id());
        taskItem.setTE005(table.getMacId());
        taskItem.setTE006(table.getReportType());
        taskItem.setTE007(table.getReportId());
//        taskItem.setTE007(IdCreator.getId2(11));
        taskItem.setTE008(table.getWorkProcedure());
        taskItem.setTE009(table.getWorkTecId());
        taskItem.setTE010(table.getFailNum());
        taskItem.setTE011(table.getTransferNum());
        User user = userDao.findById(table.getUser_id());
        String user_local_name=userDao.findLocalNameById(user.getUser_local());
        taskItem.setUser_local_name(user_local_name);
        if(taskDao.findIsHavaChcker(user_local_name)==0){
            taskItem.setTE014(6);
        }else {
            taskItem.setTE014(0);
        }
        String productId = table.getProId();
        taskItem.setTE015(table.getInfo());
        taskItem.setTE017(productId);
        taskItem.setTE018(table.getProName());
        taskItem.setTE019(table.getProSize());
        taskItem.setTE020("PCS");
        taskItem.setTE021("箱");
        taskItem.setTE030(Integer.parseInt(table.getCalType()));
//        long l = System.currentTimeMillis();
//        Date date = new Date(l);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

        taskItem.setDate(table.getDate());
        taskItem.setWork_section(workSectionId);
        taskItem.setWork_section_name(table.getWorkSectionName());
        taskItem.setUser_name(table.getUser_name());
        taskItem.setMac_name(table.getMacName());
        taskItem.setWork_tec_name(table.getWorkTec());
        taskItem.setWork_hour(table.getWork_hour());
        taskItem.setMac_hour(table.getMac_hour());
        taskItem.setCreatDate(PrimaryGenerater.getCreatDate());
//        PrimaryGenerater.getInsertCreatDate()
        String uuid = UUID.randomUUID().toString().replace("-", "");
        taskItem.setPrimaryId(uuid);
        //插入序号开始
//        List<TaskItem> toDaySize=taskDao.findTodayTaskItemSize(table.getDate(),workSectionId,table.getWorkType());
//        int AlltodaySize = taskDao.findAllToday(table.getDate());
//        String date = table.getDate().replace("-", "");
//        String workId="";
//        if(toDaySize.size()==0||toDaySize==null) {
//            if(AlltodaySize==0){
////                workId = PrimaryGenerater.getId(table.getDate(),0);
//                workId=date+"001";
//            }else {
//                String maxWorkIdToday= taskDao.findTodayMaxWorkId(table.getDate()).substring(8);
//                String t = Integer.parseInt(maxWorkIdToday)+1+"";
//                int tlength=t.length();
//                for(int i=tlength;i<3;i++){
//                    t="0"+t;
//                }
//                workId=date+t;
//            }
//        }else {
//            workId =toDaySize.get(0).getTE002();
//        }
//        taskItem.setTE002(workId);
//        // taskItem.setTE003('0'+IdCreator.getId(11).substring(8));
//        //toDaySize.size()+1+"";
//        int XuhaoSize= taskDao.findToDayXuhaoByWorkId(workId);
//        String Xuhao;
//        if(XuhaoSize==0){
//            Xuhao="1";
//        }else {
//            String XuHaoId=taskDao.findToDayMaxXuhaoByWorkId(workId);
//            Xuhao = Integer.parseInt(XuHaoId)+1+"";
//        }
//        int m=Xuhao.length();
//        for(int i=m;i<4;i++){
//            Xuhao="0"+Xuhao;
//        }
//        taskItem.setTE003(Xuhao);
        taskItem.setWork_time(table.getWorkTime());
        int length=taskDao.taskInsert(taskItem);

        return length;
    }

    @Override
    public int updateTask(CompleteTable table) {
        TaskItem taskItem =taskDao.queryDataByPrimaryId(table.getPrimaryId());
        if(taskItem.getTE014()==6||taskItem==null){
            return 0;
        }
        User user = userDao.findById(table.getUser_id());
        String user_local_name=userDao.findLocalNameById(user.getUser_local());
        String workSectionId = table.getWorkSection();
        taskItem.setTE001(table.getWorkType());
        // taskItem.setTE003('0'+IdCreator.getId(11).substring(8));
//        taskItem.setTE003('0'+PrimaryGenerater.getId().substring(8));
        taskItem.setTE005(table.getMacId());
        taskItem.setTE006(table.getReportType());
        taskItem.setTE007(table.getReportId());
//        taskItem.setTE007(IdCreator.getId2(11));
//        taskItem.setTE007(PrimaryGenerater.getId());
        taskItem.setTE008(table.getWorkProcedure());
        taskItem.setTE009(table.getWorkTecId());
        taskItem.setTE010(table.getFailNum());
        taskItem.setTE011(table.getTransferNum());
        if(taskDao.findIsHavaChcker(user_local_name)==0){
            taskItem.setTE014(6);
        }else {
            taskItem.setTE014(0);
        }
        taskItem.setUser_local_name(user_local_name);
        String productId = table.getProId();
        taskItem.setTE015(table.getInfo());
        taskItem.setTE017(productId);
        taskItem.setTE018(table.getProName());
        taskItem.setTE019(table.getProSize());
        taskItem.setTE020("PCS");
        taskItem.setTE021("箱");
        taskItem.setTE030(table.getCalType());
        long l = System.currentTimeMillis();
        Date date1 = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        taskItem.setDate(dateFormat.format(date1));
        taskItem.setWork_section(table.getWorkSection());
        taskItem.setWork_section_name(table.getWorkSectionName());
        taskItem.setDate(table.getDate());
        taskItem.setMac_name(table.getMacName());
        taskItem.setWork_tec_name(table.getWorkTec());
        taskItem.setWork_hour(table.getWork_hour());
        taskItem.setMac_hour(table.getMac_hour());
        //插入报工
//        List<TaskItem> toDaySize=taskDao.findTodayTaskItemSize(table.getDate(),workSectionId,table.getWorkType());
//        int AlltodaySize = taskDao.findAllToday(table.getDate());
//        String date = table.getDate().replace("-", "");
//        String workId="";
//        if(toDaySize.size()==0||toDaySize==null) {
//            if(AlltodaySize==0){
//                workId=date+"001";
//            }else {
//                String maxWorkIdToday= taskDao.findTodayMaxWorkId(table.getDate()).substring(8);
//                String t = Integer.parseInt(maxWorkIdToday)+1+"";
//                int tlength=t.length();
//                for(int i=tlength;i<3;i++){
//                    t="0"+t;
//                }
//                workId=date+t;
//            }
//        }else {
//            workId =toDaySize.get(0).getTE002();
//        }
//        taskItem.setTE002(workId);
//        int XuhaoSize= taskDao.findToDayXuhaoByWorkId(workId);
//        String Xuhao;
//        if(XuhaoSize==0){
//            Xuhao="1";
//        }else {
//            String XuHaoId=taskDao.findToDayMaxXuhaoByWorkId(workId);
//            Xuhao = Integer.parseInt(XuHaoId)+1+"";
//        }
//        int m=Xuhao.length();
//        for(int i=m;i<4;i++){
//            Xuhao="0"+Xuhao;
//        }
//        taskItem.setTE003(Xuhao);
        taskItem.setWork_time(table.getWorkTime());
        int length=taskDao.taskUpdate(taskItem);
        return length;
    }
}
