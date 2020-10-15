package com.baogong.dao.fzjx;

import com.baogong.Utils.C3p0Utils;
import com.baogong.Utils.C3p0Utils2;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class fzjxDao {

    //根据产品名称以及规格找产品编号
    public String productIdSelectByName(String name,String GG){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select MB001 from INVMB where MB002 = ? and MB003 = ?");
            ps.setString(1,name);
            ps.setString(2,GG);
            rs = ps.executeQuery();
            rs.next();
            return rs.getString("MB001").trim();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }

    //获取产品规格列表供用户选择
    public List<String> productGGSelectByName(String name){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MB003 from INVMB where MB002 =  ? ");
            ps.setString(1,name);
            rs = ps.executeQuery();
            List<String> result = new ArrayList<String>();
            while(rs.next()){
                result.add(rs.getString("MB003").trim());
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }


    //根据机器名称获取机器编号列表
    public List<String> robotSelectByName(String name){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MX001 from CMSMX where MX003 =  ? ");
            ps.setString(1,name);
            rs = ps.executeQuery();
            List<String> result = new ArrayList<String>();
            while(rs.next()){
                result.add(rs.getString("MX001").trim());
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }
    //根据机器编号获取机器编号列表
    public List<String> robotSelectByMachineName(String machineName){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MX001 from CMSMX where MX003 = ? ");
            ps.setString(1,machineName);
            rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while(rs.next()) {
                list.add(rs.getString("MX001").trim());
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }






    //根据工艺名称搜索工艺编号
    public String gyIdSelectByProductId(String name){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MW001 from CMSMW where MW002 = N'"+name+"'");
            rs = ps.executeQuery();
            if(rs.next())
            return rs.getString("MW001").trim();
            else return "";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }
    //根据工艺名称搜索工艺编号 升级后
    public String gyIdSelectByProductIdAndWorkSection(String name,String workSection){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MW001 from CMSMW where MW002 = N'"+name+"' and MW006 =N'"+workSection+"' ");
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getString("MW001").trim();
            else return "";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }


//根据工艺名称搜索所属工段
public List<String>  queryWorkSection(String name){
    Connection conn = C3p0Utils.getConnection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    try {
        ps= conn.prepareStatement("select DISTINCT MW006 from CMSMW where MW002 = N'"+name+"'");
        rs = ps.executeQuery();
        List<String> list = new ArrayList<>();
        while (rs.next()){
        list.add(rs.getString("MW006").trim());
        }
        return list;
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        C3p0Utils.close(conn,ps,rs);
    }
    return null;
}

    public String gyNameSelectByProductId(String id){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MW002 from CMSMW where MW001 = ?");
            ps.setString(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
            return rs.getString("MW002").trim();}else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;
    }


}
