package com.baogong.dao.yuancheng;

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
public class MOCTADao {
    public List<String> findReportTypeByProductId( String id){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT TA001 from MOCTA where TA006 = ? and (TA011 = '2' or TA011 = '3') and TA001 !='5199' order by TA001 ");
            ps.setString(1,id);
            rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()){
                list.add(rs.getString("TA001").trim());
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
    public List<String> findReportTypeByProductIdandWorkType( String id,String reportType){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT TA002 from MOCTA where TA006 = ? and TA001 = ? and (TA011 = '2' or TA011 = '3')");
            ps.setString(1,id);
            ps.setString(2,reportType);
            rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()){
                list.add(rs.getString("TA002").trim());
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
    }
}
