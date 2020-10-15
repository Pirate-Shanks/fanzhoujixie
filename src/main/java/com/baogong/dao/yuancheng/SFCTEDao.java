package com.baogong.dao.yuancheng;

import com.baogong.Utils.C3p0Utils;
import com.baogong.Utils.C3p0Utils2;
import com.baogong.Utils.PrimaryGenerater;
import com.baogong.pojo.TaskItem;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SFCTEDao {

    public int submitIntoSFCTETable(TaskItem item){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn.setAutoCommit(false);
            ps= conn.prepareStatement("insert into SFCTE (COMPANY,CREATOR,CREATE_DATE,FLAG,TE001,TE002,TE003,TE004,TE005,TE006,TE007,TE008,TE009,TE010,TE011,TE012,TE013,TE014,TE017,TE018,TE019,TE020,TE021,TE030,USR_GROUP,MODIFIER,MODI_DATE,TE015,TE200,UDF02) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"FZJX");
            ps.setString(2,"DS");
            ps.setString(3, PrimaryGenerater.getInsertCreatDate());
            ps.setString(4,"6");
            ps.setString(5,item.getTE001());
            ps.setString(6,item.getTE002());
            ps.setString(7,item.getTE003());
            ps.setString(8,item.getTE004());
            ps.setString(9,item.getTE005());
            ps.setString(10,item.getTE006());
            ps.setString(11,item.getTE007());
            ps.setString(12,item.getTE008());
            ps.setString(13,item.getTE009());
            ps.setString(14,"1");
            ps.setDouble(15,item.getTE011());
            ps.setDouble(16,item.getWork_hour()*3600);
            ps.setDouble(17,item.getMac_hour()*3600);
            //TE014
            ps.setString(18,"Y");
            ps.setString(19,item.getTE017());
            ps.setString(20,item.getTE018());
            ps.setString(21,item.getTE019());
            ps.setString(22,item.getTE020());
            ps.setString(23,item.getTE021());
            ps.setInt(24,item.getTE030());
            ps.setString(25,"6000");
            ps.setString(26,"");
            ps.setString(27,"");
            ps.setString(28,item.getTE015());
            ps.setString(29,item.getTE005());
            ps.setDouble(30,item.getTE010());
            int response = ps.executeUpdate();
            if(submitIntoSFCTDTable(item)==0)
                return 0;
            if(response==1){
                conn.commit();
                return 1;
            }

            else return 0;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }


    public int submitIntoSFCTDTable(TaskItem item){

        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            if(SFCTD_TBHava(item.getTE001(),item.getTE002(),item.getWork_section())){
                return 1;
            }
            ps= conn.prepareStatement("insert into SFCTD (COMPANY,CREATOR,CREATE_DATE,TD001,TD002,TD003,TD004,TD005,TD008,TD009,TD010,USR_GROUP,MODIFIER,MODI_DATE,FLAG,TD006,TD018 ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"FZJX");
            ps.setString(2,"DS");
            ps.setString(3, PrimaryGenerater.getInsertCreatDate());
            ps.setString(4,item.getTE001());
            ps.setString(5,item.getTE002());
            ps.setString(6,item.getTE002().substring(0,8));
            ps.setString(7,item.getWork_section());
            ps.setString(8,"Y");
            ps.setString(9,item.getTE002().substring(0,8));
            ps.setString(10,"DS");
            ps.setString(11,"N");
            ps.setString(12,"6000");
            ps.setString(13,"");
            ps.setString(14,"");
            ps.setString(15,"6");
            ps.setString(16,"");
            ps.setString(17,"**********");
            int response = ps.executeUpdate();
            if(response==1)
                return 1;
            else return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
    public Boolean SFCTD_TBHava(String TD001,String TD002,String TD004){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select count(*) as num from SFCTD where TD001=? and TD002 =? and TD004=?");
            ps.setString(1,TD001);
            ps.setString(2,TD002);
            ps.setString(3,TD004);
            rs= ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("num")>0)return true;
                else return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return false;
    }
    //以下是获取单号和序号的操作
    public  List<TaskItem> findTodayTaskItemSize(String date, String work_section, String te001) {
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select TD001,TD002 from SFCTD where TD003 = ? and TD004 = ? and TD001 = ?");
            ps.setString(1,date);
            ps.setString(2,work_section);
            ps.setString(3,te001);
            rs = ps.executeQuery();
            List<TaskItem> list = new ArrayList<TaskItem>();
            while(rs.next()){
                TaskItem item = new TaskItem();
                item.setTE001(rs.getString("TD001"));
                item.setTE002(rs.getString("TD002"));
                list.add(item);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return null;
    }

    public int findAllToday(String date) {
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select count(*) as num from SFCTE where TE002 like '"+date+"%'");
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return 0;


    }
    public Double remoteFindRemainAcount(String reportType,String reportId,String workProcedure) {
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select sum(TE011) as num from SFCTE where TE006= ? and TE007 = ? and TE008= ? ");
            ps.setString(1, reportType);
            ps.setString(2, reportId);
            ps.setString(3, workProcedure);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("num");
            } else {
                return 0.0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return 0.0;


    }

    public String findTodayMaxWorkId(String date) {
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select max(TE002) as te from SFCTE where TE002 like '"+date+"%'");
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString("te").trim();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return "";


    }

    public int findToDayXuhaoByWorkId(String workId) {
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select count(*) as num from SFCTE where TE002 = ?");
            ps.setString(1,workId);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return 0;
    }

    public String findToDayMaxXuhaoByWorkId(String workId) {
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select max(TE003) as te from SFCTE where TE002 = ?");
            ps.setString(1,workId);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString("te").trim();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return "";
    }
}
