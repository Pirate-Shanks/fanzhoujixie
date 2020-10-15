package com.baogong.dao.yuancheng;

import com.baogong.Utils.C3p0Utils;
import com.baogong.Utils.C3p0Utils2;
import com.baogong.dao.fzjx.fzjxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SFCTADao {

    @Autowired
    private fzjxDao fzjx;
    //根据工单找到所有工序列表
    public List<String> gxSelectByProductId(String workType,String workId,String workTecId,String workSection){
        if(workType.equals("")||workId.equals("")||workTecId.equals("")||workSection.equals("")){
            return null;
        }
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
//            fzjxDao fzjx= new fzjxDao();
//            String s = fzjx.gyIdSelectByProductIdAndWorkSection(workTec,workSection).trim();
            ps= conn.prepareStatement("select TA003 from SFCTA where TA001 = ? and TA002 = ? and TA004 = ? and TA006 = ?  order by TA003");
            ps.setString(1,workType);
            ps.setString(2,workId);
            ps.setString(3,workTecId);
            ps.setString(4,workSection);
            rs = ps.executeQuery();
            List<String> list = new ArrayList<String>();
            while(rs.next()){
                list.add(rs.getString("TA003").trim());
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return null;
    }

    public Double getMaxProductHave(String reportType,String reportId){
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select TA015 from MOCTA where TA001 =? and TA002 =? and (TA011 = '2' or TA011 = '3')");
            ps.setString(1, reportType);
            ps.setString(2, reportId);
            rs = ps.executeQuery();
            Double max;
            if (rs.next()) {
                max = rs.getDouble("TA015");
            } else {
                max = 0.0;
            }
            return max;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils2.close(conn, ps, rs);
        }
        return null;
    }


    public Map<String,Map<String,List<String>>> workTecSelectByGongDan(String workType, String workId) {
        if(workType.equals("")||workId.equals("")){
            return null;
        }
        Map<String,List<String>> map1 = new HashMap<>();
        Map<String,List<String>> map2 = new HashMap<>();
        Connection conn = C3p0Utils2.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps= conn.prepareStatement("select DISTINCT TA004,TA006,TA007 from SFCTA where TA001 = ? and TA002 = ? and TA005 = ?");
            ps.setString(1,workType);
            ps.setString(2,workId);
            ps.setString(3,"1");
            rs = ps.executeQuery();
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<>();
            List<String> list3 = new ArrayList<String>();
            List<String> list4 = new ArrayList<>();
            while(rs.next()){
                list1.add(rs.getString("TA004").trim());
                list2.add(fzjx.gyNameSelectByProductId(rs.getString("TA004").trim()));
                list3.add(rs.getString("TA006").trim());
                list4.add(rs.getString("TA007").trim());
            }
            Map<String,Map<String,List<String>>> map = new HashMap<>();
            map1.put("id",list1);
            map1.put("name",list2);
            map2.put("id",list3);
            map2.put("name",list4);
            map.put("workTec",map1);
            map.put("workSection",map2);
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Utils2.close(conn,ps,rs);
        }
        return null;
    }
}
