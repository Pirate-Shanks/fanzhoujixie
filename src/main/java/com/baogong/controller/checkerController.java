package com.baogong.controller;

import com.baogong.pojo.Checkers;
import com.baogong.pojo.User;
import com.baogong.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class checkerController {

    @Autowired
    private CheckerService checkerService;

    @ResponseBody
    @RequestMapping("/queryAllWorkSection")
    public List<Checkers> queryAllWorkSection(){
        return checkerService.findAllWorkSection();
    }
    @ResponseBody
    @RequestMapping("/setChecker")
    public int setChecker(@RequestParam("user_id")String user_id){
        return checkerService.updateIdentify(user_id);
    }

    @ResponseBody
    @RequestMapping("/cancelChecker")
    public int cancelChecker(@RequestParam("user_id")String user_id){
        return checkerService.cancelIdentify(user_id);
    }

    @ResponseBody
    @RequestMapping("/frozen")
    public int forzen(@RequestParam("user_id")String user_id){
        return checkerService.setFrozen(user_id);
    }

    @ResponseBody
    @RequestMapping("/cancelFrozen")
    public int cancelForzen(@RequestParam("user_id")String user_id){
        return checkerService.cancelFrozen(user_id);
    }

    @ResponseBody
    @RequestMapping("/queryCheckers")
    public List<User> queryCheckers(){
        return checkerService.findAllCheckers();
    }

    @ResponseBody
    @RequestMapping("/queryNotCheckers")
    public List<User> queryNotCheckers(){
        return checkerService.findNotCheckers();
    }



    @ResponseBody
    @RequestMapping("/setCheckerList")
    public int setCheckerList(@RequestParam("workspace")String workspace,@RequestParam("check_identify")int check_identify,@RequestParam("user_id")String user_id){

        return checkerService.setWorkSpaceChecker(workspace,check_identify,user_id);
    }

    @ResponseBody
    @RequestMapping("/setManyCheckerList")
    public int setManyCheckerList(@RequestParam(value = "selections")String workspace,@RequestParam("check_identify")int check_identify,@RequestParam("user_id")String user_id){
        String[] list = workspace.split(",");
        for(int i =0;i<list.length;i++){
           if(checkerService.setWorkSpaceChecker(list[i],check_identify,user_id)!=1){
               return 0;
           }
        }
        return 1;
    }


    @ResponseBody
    @RequestMapping("/deleteCheckerList")
    public int deleteCheckerList(@RequestParam("workspace")String workspace,@RequestParam("check_identify")int check_identify,@RequestParam("user_id")String user_id){

        return checkerService.deleteWorkSpaceChecker(workspace,check_identify,user_id);
    }

    @ResponseBody
    @RequestMapping("/managerAddWorkSpace")
    public int managerAddWorkSpace(@RequestParam("local_id")String local_id,@RequestParam("local_name")String local_name){
        return checkerService.managerAddWorkSpace(local_id,local_name);
    }
    @ResponseBody
    @RequestMapping("/managerDeleteWorkSpace")
    public int managerDeleteWorkSpace(@RequestParam("local_name")String local_name){
        return checkerService.managerDeleteWorkSpace(local_name);
    }
}
