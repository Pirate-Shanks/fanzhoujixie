package com.baogong.service.Impl;

import com.baogong.Utils.PrimaryGenerater;
import com.baogong.dao.CheckerDao;
import com.baogong.dao.UserDao;
import com.baogong.dao.logTask.LogTaskDao;
import com.baogong.pojo.*;
import com.baogong.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class checkerServiceImpl implements CheckerService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogTaskDao logTaskDao;

    @Autowired
    private CheckerDao checkerDao;

    @Override
    public List<Checkers> findAllWorkSection() {
        List<String> listName= checkerDao.findAllWorkSection();
        List<Checkers> checkers = new ArrayList<>();
        for (String name:listName) {
            Checkers checker = new Checkers();
            checker.setWork_space(name);
            List<User> listFirst = new ArrayList<>();
            List<User> listsecond = new ArrayList<>();
            List<String> list1 = checkerDao.findListByName(name,1);
            List<String> list2 = checkerDao.findListByName(name,2);
            for (String user_id:list1) {
                User user = userDao.findById(user_id);
                listFirst.add(user);
            }
            for (String user_id:list2) {
                User user = userDao.findById(user_id);
                listsecond.add(user);
            }
            checker.setList1(listFirst);
            checker.setList2(listsecond);
            checkers.add(checker);
        }
        return checkers;
    }

    @Override
    public int updateIdentify(String user_id) {
        try{
            checkerDao.updateUserIdentify(user_id);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public int cancelIdentify(String user_id) {
        try{
            checkerDao.cancelUserIdentify(user_id);
            checkerDao.deleteCheckWorkItem(user_id);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    @Override
    public int setFrozen(String user_id) {
        try{
            String datetime = PrimaryGenerater.getAddOrDelDate();
            checkerDao.setFrozen(user_id,datetime);
            checkerDao.deleteCheckWorkItem(user_id);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public int cancelFrozen(String user_id) {
        try{
            checkerDao.cancelFrozen(user_id);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public List<User> findAllCheckers() {
        return checkerDao.findAllCheckers();
    }

    @Override
    public int deleleWorkSpaceChecker(String work_space) {
        return checkerDao.deleteWorkSpaceCheker(work_space);
    }

    @Override
    public int setWorkSpaceChecker(String work_space,int check_identify,String user_id) {
        if(checkerDao.selectItemIsAlive(work_space,check_identify,user_id)!=0){
            return 1;
        }
        try {
            CheckerItem item = new CheckerItem();
            item.setWork_space(work_space);
            item.setCheck_identify(check_identify);
            item.setUser_id(user_id);
            checkerDao.itemInsert(item);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int deleteWorkSpaceChecker(String work_space, int check_identify, String user_id) {
        try {
            CheckerItem item = new CheckerItem();
            item.setWork_space(work_space);
            item.setCheck_identify(check_identify);
            item.setUser_id(user_id);
            checkerDao.itemDelete(item);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<User> findNotCheckers() {
        return userDao.findNotCheckers();
    }

    @Override
    public List<LogTaskItem> queryLogOnConditions(CheckerLogPick checkerLogPick) {
        String workSection="";
        if( checkerLogPick.getWorkSection()!=null){
            workSection=checkerLogPick.getWorkSection();
        }
        String date1="";
        String date2="";
        if(checkerLogPick.getDate()!=null){
            date1=checkerLogPick.getDate()[0]+" 00:00:00";
            date2=checkerLogPick.getDate()[1]+" 23:59:59";
        }
        List<LogTaskItem> list =logTaskDao.findAllOnConditions(date1,date2,workSection,(checkerLogPick.getPageNum()-1)*10);
        for (int i=0;i<list.size();i++){
            list.get(i).setId((checkerLogPick.getPageNum()-1)*10+i+1);
            list.get(i).setDate(list.get(i).getDate().substring(0,16));
        }
        return list;
    }

    @Override
    public int queryLogPagesOnConditions(CheckerLogPick checkerLogPick) {
        String workSection="";
        if( checkerLogPick.getWorkSection()!=null){
            workSection=checkerLogPick.getWorkSection();
        }
        String date1="";
        String date2="";
        if(checkerLogPick.getDate()!=null){
            date1=checkerLogPick.getDate()[0]+" 00:00:00";
            date2=checkerLogPick.getDate()[1]+" 23:59:59";
        }
        int length = logTaskDao.findAllPagesOnConditions(date1,date2,workSection);
        return length;
    }

    @Transactional
    @Override
    public int managerAddWorkSpace(String local_id, String local_name) {
        checkerDao.managerAddLocal(local_id,local_name);
        checkerDao.managerAddWorkSpace(local_id,local_name);
        return 1;
    }

    @Override
    public int managerDeleteWorkSpace(String local_name) {
        checkerDao.managerDeleteLocal(local_name);
        checkerDao.managerDeleteWorkSpace(local_name);
        checkerDao.DeleteworkSpace(local_name);
        return 1;
    }


}
