package com.baogong.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Utils2{
    private static   Logger logger = LoggerFactory.getLogger(C3p0Utils2.class);

    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("yuancheng");
    //从连接池中取用一个连接
    public synchronized static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            logger.error("Exception in C3p0Utils!", e);
        }
        return null;
    }
    //释放连接回连接池
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }
    }
}
