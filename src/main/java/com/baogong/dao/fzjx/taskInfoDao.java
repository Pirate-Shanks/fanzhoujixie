package com.baogong.dao.fzjx;

import com.baogong.Utils.C3p0Utils;
import com.baogong.Utils.sqlNameChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class taskInfoDao {

     @Autowired
   private fzjxDao dao ;
    //根据机器名称搜索提示列表
   public List<String> queryMachineName(String queryString){

       Connection conn = C3p0Utils.getConnection();
       PreparedStatement ps=null;
       ResultSet rs=null;
       try {
           ps= conn.prepareStatement("select DISTINCT MX003 from CMSMX where MX003 like N'%"+queryString+"%' and (isMould is NULL or isMould = '')   ");
//           ps.setString(1,macId);
           rs = ps.executeQuery();
           List<String> result = new ArrayList<String>();
          while (rs.next()) {
              result.add(rs.getString("MX003").trim());
          }
          return result;
       } catch (
               SQLException e) {
           e.printStackTrace();
       }finally {
           C3p0Utils.close(conn,ps,rs);
       }
       return null;

   }



   //根据产品名称找到所有的序列
    public List<String> queryProduct(String name){

        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MB002 from INVMB where MB002 like N'%"+name+"%' and (MB121 is NULL or MB121 ='') ");
            rs = ps.executeQuery();
            List<String> result = new ArrayList<String>();
            while(rs.next()){
                result.add(rs.getString("MB002").trim());
            }
            return result;
    } catch (
                SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;

    }

    //根据工艺名称找到所有工艺111111111111111111111111111111111
    public List<String> queryWorkTec(String name){
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT MW002 from CMSMW where MW002 like N'%"+name+"%'  ");
             rs = ps.executeQuery();
            List<String> result = new ArrayList<String>();
            while(rs.next()){
                result.add(rs.getString("MW002").trim());
            }
            return result;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils.close(conn,ps,rs);
        }
        return null;

    }


}
