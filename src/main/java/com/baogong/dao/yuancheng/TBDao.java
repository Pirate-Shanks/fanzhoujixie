package com.baogong.dao.yuancheng;

import com.baogong.Utils.C3p0Utils;
import com.baogong.Utils.C3p0Utils2;
import com.baogong.Utils.PrimaryGenerater;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TBDao {

    //INVMB tongbu
    public int INVMB_TB(){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            INVMB_TBDelete();
            int i=0;
            ps= conn.prepareStatement("select MB001,MB002,MB003,MB004,MB005 from INVMB");
            rs = ps.executeQuery();
            while (rs.next()){
                if(!INVMB_TBHava(rs.getString("MB001").trim())) {
                    INVMB_TBInsert(rs.getString("MB001").trim(), rs.getString("MB002").trim(), rs.getString("MB003").trim(), rs.getString("MB004").trim(), rs.getString("MB005").trim());
                    i++;
                }
            }
            insertTableInfo("INVMB",i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
    public int INVMB_TBInsert(String list1,String list2,String list3,String list4,String list5){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("insert into INVMB (MB001,MB002,MB003,MB004,MB005) values (?,?,?,?,?)");
            ps.setString(1,list1);
            ps.setString(2,list2);
            ps.setString(3,list3);
            ps.setString(4,list4);
            ps.setString(5,list5);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public int INVMB_TBDelete(){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("delete from INVMB where MB121 is NULL or MB121 =''");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public Boolean INVMB_TBHava(String id){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select count(*) as num from INVMB where MB001= ?");
            ps.setString(1,id);
            rs= ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("num")>0)return true;
                else return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return false;
    }








    //CMSMW tongbu
    public int CMSMW_TB(){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            CMSMW_TBDelete();
            int i=0;
            ps= conn.prepareStatement("select MW001,MW002,MW004,MW005,MW006 from CMSMW");
            rs = ps.executeQuery();
            while (rs.next()){
                CMSMW_TBInsert(rs.getString("MW001").trim(),rs.getString("MW002").trim(),rs.getString("MW004").trim(),rs.getString("MW005").trim(),rs.getString("MW006").trim());
                i++;
            }
            insertTableInfo("CMSMW",i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
    public int CMSMW_TBInsert(String list1,String list2,String list4,String list5,String list6){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("insert into CMSMW (MW001,MW002,MW004,MW005,MW006) values (?,?,?,?,?)");
            ps.setString(1,list1);
            ps.setString(2,list2);
            ps.setString(3,list4);
            ps.setString(4,list5);
            ps.setString(5,list6);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public int CMSMW_TBDelete(){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("delete from CMSMW where 1=1");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }




    //CMSMX tongbu
    public int CMSMX_TB(){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            CMSMX_TBDelete();
            int i=0;
            ps= conn.prepareStatement("select MX001,MX002,MX003 from CMSMX");
            rs = ps.executeQuery();
            while (rs.next()){
                if(!CMSMX_TBHava(rs.getString("MX001").trim())){
                CMSMX_TBInsert(rs.getString("MX001").trim(),rs.getString("MX002").trim(),rs.getString("MX003").trim());
                i++;
                }

            }
            insertTableInfo("CMSMX",i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
    public int CMSMX_TBInsert(String list1,String list2,String list3){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("insert into CMSMX (MX001,MX002,MX003) values (?,?,?)");
            ps.setString(1,list1);
            ps.setString(2,list2);
            ps.setString(3,list3);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public int CMSMX_TBDelete(){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("delete from CMSMX where isMould is NULL or isMould =''");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public Boolean CMSMX_TBHava(String moudleId){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select count(*) as num from CMSMX where MX001= ?");
            ps.setString(1,moudleId);
            rs= ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("num")>0)return true;
                else return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return false;
    }






    //CMSMV_Tongbu

    //CMSMX tongbu
    public int CMSMV_TB(){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            int i=0;
            ps= conn.prepareStatement("select MV001,MV002 from CMSMV");
            rs = ps.executeQuery();
            String datetime = PrimaryGenerater.getAddOrDelDate();
            while (rs.next()){
                if(!CMSMV_TBHava(rs.getString("MV001").trim())){
                CMSMV_TBInsert(rs.getString("MV001").trim(),rs.getString("MV002").trim(),datetime);
                i++;
                }
            }
            insertTableInfo("CMSMV",i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
    public int CMSMV_TBInsert(String list1,String list2,String datetime){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("insert into [user] (user_id,user_name,password,add_date) values (?,?,?,?)");
            ps.setString(1,list1);
            ps.setString(2,list2);
            ps.setString(3,list2);
            ps.setString(4,datetime);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public Boolean CMSMV_TBHava(String user_id){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select count(*) as num from [user] where user_id=?");
           ps.setString(1,user_id);
            rs= ps.executeQuery();
           while(rs.next()){
               if(rs.getInt("num")>0)return true;
               else return false;
           }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return false;
    }


//CMSME tongbu
//CMSMX tongbu
public int CMSME_TB(){
    Connection conn = C3p0Utils2.getConnection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    try {
        CMSME_TBDelete();
        int i=0;
        ps= conn.prepareStatement("select ME001,ME002 from CMSME");
        rs = ps.executeQuery();
        while (rs.next()){
            if(!CMSME_TBHava(rs.getString("ME001").trim())) {
                CMSME_TBInsert(rs.getString("ME001").trim(), rs.getString("ME002").trim());
                i++;
            }
        }
        insertTableInfo("CMSME",i);
        return i;
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }finally {
        C3p0Utils2.close(conn,ps,rs);
    }
}
    public int CMSME_TBInsert(String list1,String list2){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("insert into localInfo (local_id,user_local_name) values (?,?)");
            ps.setString(1,list1);
            ps.setString(2,list2);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public int CMSME_TBDelete(){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("delete from localInfo where ME003 is NULL or ME003 =''");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public Boolean CMSME_TBHava(String local_id){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select count(*) as num from [localInfo] where local_id=?");
            ps.setString(1,local_id);
            rs= ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("num")>0)return true;
                else return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return false;
    }







    public int insertTableInfo(String name,int num){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("UPDATE DataBaseTB set tableInfo =?,date =? where tableName = ?");
            ps.setString(1,num+"");
            String date1= PrimaryGenerater.getCreatDate();
            ps.setString(2,date1);
            ps.setString(3,name);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }


    //CMSMD_TB
    public int CMSMD_TB(){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            CMSMD_TBDelete();
            int i=0;
            ps= conn.prepareStatement("select local_id,user_local_name from localInfo where ME003 = 'y' or ME003 = 'Y' order by local_id");
            rs = ps.executeQuery();
            while (rs.next()){
                    CMSMD_TBInsert(rs.getString("local_id").trim(),rs.getString("user_local_name").trim());
                    i++;
            }
            insertTableInfo("CMSMD",i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public int CMSMD_TBInsert(String list1,String list2){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("insert into worktime (id,workspace) values (?,?)");
            ps.setString(1,list1);
            ps.setString(2,list2);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }
    public int CMSMD_TBDelete(){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("delete from worktime where 1=1");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
    }


}
