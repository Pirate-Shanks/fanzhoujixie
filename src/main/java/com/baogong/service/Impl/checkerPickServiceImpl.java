package com.baogong.service.Impl;

import com.baogong.dao.CheckerPickDao;
import com.baogong.dao.TaskDao;
import com.baogong.dao.WorkSectionDao;
import com.baogong.pojo.CheckerItem;
import com.baogong.pojo.CheckerPick;
import com.baogong.pojo.CompleteTable;
import com.baogong.pojo.TaskItem;
import com.baogong.service.CheckerPickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class checkerPickServiceImpl implements CheckerPickService {

    @Autowired
   private CheckerPickDao checkerPickDao;

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private WorkSectionDao workSectionDao;
    @Override
    public List<CompleteTable> checkerFindOwnTask(CheckerPick checkerPick) {
        String user_name="";
        if(checkerPick.getEmployeeName()!=null){
            user_name=checkerPick.getEmployeeName();
        }
        String checkerId = checkerPick.getUser_id();
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(checkerId);
//        List<String> workSpaceList = new ArrayList<>();
//        List<Integer> identifyOwnList = new ArrayList<>();
//        for(CheckerItem item:checkerItems){
//            workSpaceList.add(item.getWork_space());
//            identifyOwnList.add(item.getCheck_identify());
//        }
        String date1 = "";
        String date2 = "";
        if(checkerPick.getDate()!=null){
            date1=checkerPick.getDate()[0];
            date2=checkerPick.getDate()[1];
        }
        String proName = "";
        if(checkerPick.getProName()!=null){
            proName=checkerPick.getProName();
        }
        List<CompleteTable> completeTables =new ArrayList<>();

        List<TaskItem> items = checkerPickDao.checkerFindOwnTaskAll(checkerItems,date1,date2,proName,user_name,(checkerPick.getPageNum()-1)*10,checkerPick.getState());
        int i=1;
        for(TaskItem taskItem : items){
                CompleteTable completeTable = new CompleteTable();
                    completeTable.setUser_name(taskItem.getUser_name());
                    completeTable.setUser_id(taskItem.getTE004());
                    completeTable.setWorkType(taskItem.getTE001());
                    completeTable.setWorkId(taskItem.getTE002());
                    completeTable.setReportType(taskItem.getTE006());
                    completeTable.setReportId(taskItem.getTE007());
                    completeTable.setMacName(taskItem.getMac_name());
                    completeTable.setWorkNum(taskItem.getTE003());
                    completeTable.setMacId(taskItem.getTE005());
                    completeTable.setProName(taskItem.getTE018());
                    completeTable.setProSize(taskItem.getTE019());
                    completeTable.setWorkTec(taskItem.getWork_tec_name());
                    completeTable.setFailNum(taskItem.getTE010());
                    completeTable.setTransferNum(taskItem.getTE011());
                    completeTable.setCalType(taskItem.getTE030());
                    completeTable.setDate(taskItem.getDate());
                    completeTable.setProId(taskItem.getTE017());
                    completeTable.setWork_hour(taskItem.getWork_hour());
                    completeTable.setPrimaryId(taskItem.getPrimaryId());
                    completeTable.setMac_hour(taskItem.getMac_hour());
                    completeTable.setWorkProcedure(taskItem.getTE008());
                    completeTable.setWorkSection(taskItem.getWork_section());
                    completeTable.setWorkSectionName(taskItem.getWork_section_name());
                    completeTable.setWorkTecId(taskItem.getTE009());
                    completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
                    completeTable.setId((checkerPick.getPageNum()-1)*10+i);
                    i++;
                    for(CheckerItem checkerItem : checkerItems){
                        if(checkerItem.getWork_space().equals(taskItem.getUser_local_name())){
                            if((checkerItem.getCheck_identify()-taskItem.getTE014())==1){
                                completeTable.setState(0);
                            }else {
                                completeTable.setState(1);
                            }
                        }
                    }
                    completeTables.add(completeTable);

            }
        return completeTables;
    }
    public int checkerFindOwnTaskPages(CheckerPick checkerPick){
        String user_name = checkerPick.getEmployeeName();
        String checkerId = checkerPick.getUser_id();
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(checkerId);
//        List<String> workSpaceIdList = new ArrayList<>();
//        List<Integer> identifyOwnList = new ArrayList<>();
//        for(CheckerItem item:checkerItems){
//            workSpaceIdList.add(workSectionDao.findWorkSpaceId(item.getWork_space()));
//            identifyOwnList.add(item.getCheck_identify());
//        }
        String date1 = "";
        String date2 = "";
        if(checkerPick.getDate()!=null){
            date1=checkerPick.getDate()[0];
            date2=checkerPick.getDate()[1];
        }
        String proName = "";
        if(checkerPick.getProName()!=null){
            proName=checkerPick.getProName();
        }
        int length=0;
         length = checkerPickDao.checkerFindOwnTaskAllPages(checkerItems,date1,date2,proName,user_name,checkerPick.getState());
//        List<CompleteTable> completeTables =new ArrayList<>();
//        for(int i =0 ; i<workSpaceIdList.size();i++){
//            List<TaskItem> items = checkerPickDao.checkerFindOwnTask(workSpaceIdList.get(i),date1,date2,proName,user_name);
//            for(TaskItem taskItem : items){
//                if(taskItem.getTE014()<identifyOwnList.get(i)-1){
//                    continue;
//                }else {
//                    length++;
//                }
//            }
//        }
        return length;
    }

    @Override
    public List<String> findMyOwnSection(String user_id) {
        if(user_id!=""){
         List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
         List<String> workSpaceList = new ArrayList<>();
            for(CheckerItem item:checkerItems){
                workSpaceList.add(item.getWork_space());
            }
            return workSpaceList;
        }else return null;
    }

    @Override
    public List<CompleteTable> queryDataByOwnWorkSection(CheckerPick checkerPick) {
        String date1 = "";
        String date2 = "";
        if(checkerPick.getDate()!=null){
            date1=checkerPick.getDate()[0];
            date2=checkerPick.getDate()[1];
        }
        String proName = "";
        if(checkerPick.getProName()!=null){
            proName=checkerPick.getProName();
        }
        String user_name="";
        if(checkerPick.getEmployeeName()!=null){
            user_name=checkerPick.getEmployeeName();
        }
        CheckerItem checkItem = taskDao.findCheckItemByUserIdAndWorkSection(checkerPick.getUser_id(), checkerPick.getWorkSection());
        if(checkItem==null) return null;
        int owmIdentify=checkItem.getCheck_identify();
//        String workSpaceId = workSectionDao.findWorkSpaceId(checkerPick.getWorkSection());
        List<TaskItem> items = checkerPickDao.checkerFindOwnTask(checkerPick.getWorkSection(),date1,date2,proName,user_name,owmIdentify-1,(checkerPick.getPageNum()-1)*10,checkerPick.getState());
        List<CompleteTable> completeTables = new ArrayList<>();
        for(TaskItem taskItem : items){
            CompleteTable completeTable = new CompleteTable();
                completeTable.setUser_name(taskItem.getUser_name());
                completeTable.setUser_id(taskItem.getTE004());
                completeTable.setWorkType(taskItem.getTE001());
                completeTable.setWorkId(taskItem.getTE002());
                completeTable.setReportType(taskItem.getTE006());
                completeTable.setReportId(taskItem.getTE007());
                completeTable.setWorkNum(taskItem.getTE003());
                completeTable.setMacName(taskItem.getMac_name());
                completeTable.setMacId(taskItem.getTE005());
                completeTable.setProName(taskItem.getTE018());
                completeTable.setProSize(taskItem.getTE019());
                completeTable.setWorkTec(taskItem.getWork_tec_name());
                completeTable.setFailNum(taskItem.getTE010());
                completeTable.setTransferNum(taskItem.getTE011());
                completeTable.setCalType(taskItem.getTE030());
                completeTable.setDate(taskItem.getDate());
                completeTable.setProId(taskItem.getTE017());
                completeTable.setWork_hour(taskItem.getWork_hour());
                completeTable.setPrimaryId(taskItem.getPrimaryId());
                completeTable.setWorkProcedure(taskItem.getTE008());
                completeTable.setMac_hour(taskItem.getMac_hour());
                completeTable.setWorkSection(taskItem.getWork_section());
                completeTable.setWorkSectionName(taskItem.getWork_section_name());
                completeTable.setWorkTecId(taskItem.getTE009());
                completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
                if((owmIdentify-taskItem.getTE014())==1){
                    completeTable.setState(0);
                }else {
                    completeTable.setState(1);
                }
                completeTables.add(completeTable);

        }
        List<CompleteTable> list = new ArrayList<>();
        for(int i =(checkerPick.getPageNum()-1)*10;i<checkerPick.getPageNum()*10;i++){
            if(i<completeTables.size()){
                completeTables.get(i).setId(i+1);
                list.add( completeTables.get(i));}
        }
        return completeTables;
    }
    public int queryDataByOwnWorkSectionPages(CheckerPick checkerPick){
        String date1 = "";
        String date2 = "";
        if(checkerPick.getDate()!=null){
            date1=checkerPick.getDate()[0];
            date2=checkerPick.getDate()[1];
        }
        String proName = "";
        if(checkerPick.getProName()!=null){
            proName=checkerPick.getProName();
        }
        String user_name="";
        if(checkerPick.getEmployeeName()!=null){
            user_name=checkerPick.getEmployeeName();
        }
        CheckerItem checkItem = taskDao.findCheckItemByUserIdAndWorkSection(checkerPick.getUser_id(), checkerPick.getWorkSection());
        if(checkItem==null) return 0;
        int owmIdentify=checkItem.getCheck_identify();
        String workSpaceId = workSectionDao.findWorkSpaceId(checkerPick.getWorkSection());
        int length = checkerPickDao.checkerPagesFindOwnTask(workSpaceId,date1,date2,proName,user_name,owmIdentify-1,checkerPick.getState());

        return length;
    }

    @Override
    public int managerCheckerPickPages(CheckerPick checkerPick) {
        String date1 = "";
        String date2 = "";
        if(checkerPick.getDate()!=null){
            date1=checkerPick.getDate()[0];
            date2=checkerPick.getDate()[1];
        }
        String proName = "";
        if(checkerPick.getProName()!=null){
            proName=checkerPick.getProName();
        }
        String user_name="";
        if(checkerPick.getEmployeeName()!=null){
            user_name=checkerPick.getEmployeeName();
        }
        String workSection = checkerPick.getWorkSection();
//        String workSpaceId="";
//        if(!workSection.equals("")){
//           workSpaceId = workSectionDao.findWorkSpaceId(checkerPick.getWorkSection());
//        }
        return checkerPickDao.managerCheckerFindonTaskPages(date1,date2,proName,user_name,workSection,checkerPick.getState());
    }

    @Override
    public List<CompleteTable> managerCheckerPickData(CheckerPick checkerPick) {
        String date1 = "";
        String date2 = "";
        if(checkerPick.getDate()!=null){
            date1=checkerPick.getDate()[0];
            date2=checkerPick.getDate()[1];
        }
        String proName = "";
        if(checkerPick.getProName()!=null){
            proName=checkerPick.getProName();
        }
        String user_name="";
        if(checkerPick.getEmployeeName()!=null){
            user_name=checkerPick.getEmployeeName();
        }
        String workSection = checkerPick.getWorkSection();
//        String workSpaceId="";
//        if(!workSection.equals("")){
//            workSpaceId = workSectionDao.findWorkSpaceId(checkerPick.getWorkSection());
//        }
        List<TaskItem> items =  checkerPickDao.managerCheckerFindonTask(date1,date2,proName,user_name,workSection,(checkerPick.getPageNum()-1)*10,checkerPick.getState());
        List<CompleteTable> completeTables = new ArrayList<>();
        int i=1;
        for(TaskItem taskItem : items){
                CompleteTable completeTable = new CompleteTable();
                completeTable.setId((checkerPick.getPageNum()-1)*10+i);
                i++;
                completeTable.setUser_name(taskItem.getUser_name());
                completeTable.setUser_id(taskItem.getTE004());
                completeTable.setWorkType(taskItem.getTE001());
                completeTable.setWorkId(taskItem.getTE002());
                completeTable.setReportType(taskItem.getTE006());
                completeTable.setReportId(taskItem.getTE007());
                completeTable.setWorkNum(taskItem.getTE003());
                completeTable.setMacName(taskItem.getMac_name());
                completeTable.setMacId(taskItem.getTE005());
                completeTable.setProName(taskItem.getTE018());
                completeTable.setProSize(taskItem.getTE019());
                completeTable.setWorkTec(taskItem.getWork_tec_name());
                completeTable.setFailNum(taskItem.getTE010());
                completeTable.setTransferNum(taskItem.getTE011());
                completeTable.setCalType(taskItem.getTE030());
                completeTable.setDate(taskItem.getDate());
                completeTable.setProId(taskItem.getTE017());
                completeTable.setWork_hour(taskItem.getWork_hour());
                completeTable.setPrimaryId(taskItem.getPrimaryId());
                completeTable.setWorkProcedure(taskItem.getTE008());
                completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
                if(taskItem.getTE014()==7){
                    completeTable.setState(1);
                }else {
                    completeTable.setState(0);
                }
                completeTables.add(completeTable);
            }
        return completeTables;
    }

    @Override
    public int weChatCheckerPickTaskSize(CheckerPick checkerPick) {
        String checkerId = checkerPick.getUser_id();
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(checkerId);
        List<String> workSpaceList = new ArrayList<>();
        List<Integer> identifyOwnList = new ArrayList<>();
        for(CheckerItem item:checkerItems){
            workSpaceList.add(item.getWork_space());
            identifyOwnList.add(item.getCheck_identify());
        }
        int length=0;
//        List<CompleteTable> completeTables =new ArrayList<>();
//        for(int i =0 ; i<workSpaceList.size();i++){
//            List<TaskItem> items = checkerPickDao.checkerFindOwnTask(workSpaceList.get(i),"","","","",);
//            for(TaskItem taskItem : items){
//                if(taskItem.getTE014()==identifyOwnList.get(i)-1){
//                    length++;
//                }else {
//                    continue;
//                }
//            }
//        }
        return length;
    }


}
