package com.baogong.test;

import com.baogong.Utils.ChangeC3p0PoolInfo;
import com.baogong.Utils.IsAllowedUtils;
import com.baogong.Utils.PrimaryGenerater;
import com.baogong.dao.CheckerDao;
import com.baogong.dao.CheckerPickDao;
import com.baogong.dao.TaskDao;
import com.baogong.dao.UserDao;
import com.baogong.dao.fzjx.fzjxDao;
import com.baogong.dao.fzjx.taskInfoDao;
import com.baogong.dao.yuancheng.SFCTADao;
import com.baogong.dao.yuancheng.SFCTEDao;
import com.baogong.dao.yuancheng.TBDao;
import com.baogong.pojo.CheckerItem;
import com.baogong.service.findTaskService;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

        @Autowired
        private SFCTEDao sfcteDao;
        @Autowired
        private IsAllowedUtils isAllowedUtils;
        @Autowired
        private CheckerPickDao checkerPickDao;
        @Autowired
        private SFCTADao sfctaDao;

        @Autowired
        private TBDao tbDao;
        @Autowired
        private CheckerDao checkerDao;

        @Autowired
        private taskInfoDao dao;

        @Autowired
        private fzjxDao fzjx;
        @Autowired
        UserDao userDao;

        @Autowired
        DataSource dataSource;

        @Autowired
        public TaskDao task;

        @Autowired
        private findTaskService find;
        @Test
        public void test(){
                try  {
                        Connection connection = dataSource.getConnection();
                        PreparedStatement ps= connection.prepareStatement("insert into [user] (user_id,user_local,user_name) values (?,?,?)");

                        ps.setString(1, "112");
                        ps.setString(2, "345");
                        ps.setString(3,"周秋");
                        ps.executeUpdate();
                        ps.close();
                        connection.close();

                }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("出现问题了");
                }
                System.out.println("111111111111111111111111111111111111");
        }


        @Autowired
        private ChangeC3p0PoolInfo changeC3p0PoolInfo;

        @Test
        public void test4() throws IOException, SAXException, ParserConfigurationException, TransformerException {
//
//                File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\c3p0-config.xml");//Persons.xml文件绝对路径
//                DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//                //②获取一个与磁盘文件关联的非空Document对象
//                Document doc = newDocumentBuilder.parse(file);
//                //③通过文档对象获得该文档对象的根节点
//                Element root = doc.getDocumentElement();
//                NodeList personList = root.getElementsByTagName("named-config");
//                Node item = personList.item(2);
//                Element personElement = (Element) item;
//                NodeList nameList = personElement.getElementsByTagName("property");
//                Node item1 = nameList.item(1);
//                item1.setTextContent("zhouqiu");
//                Transformer ts = TransformerFactory.newInstance().newTransformer();
//                ts.transform(new DOMSource(doc), new StreamResult(System.getProperty("user.dir")+"\\src\\main\\resources\\c3p0-config.xml"));
               // System.out.println(task.findRemainAcount("5102","20150804001","0020"));
//                2019-10-25 18:53:12.000
              //  System.out.println(sfctaDao.workTecSelectByGongDan("5102","20150804001"));

//               task.deleteTaskByWorkIdAndBeTweenDate("20191108002", PrimaryGenerater.getCreatDate());
//                System.out.println(tbDao.INVMB_TB());
//            System.out.println(tbDao.CMSMW_TB());
//                System.out.println(tbDao.CMSMX_TB());
//                System.out.println(tbDao.CMSMV_TB());
//                System.out.println(tbDao.CMSME_TB());
       }
       @Test
       public void test5() throws ParseException {
//               System.out.println(isAllowedUtils.isAllowedLogin());
//               System.out.println(isAllowedUtils.isAllowedSubmit("2019-12-15"));
               List<CheckerItem> checkerItems = task.findCheckItemByUserId("10003");

             //  System.out.println(checkerPickDao.checkerFindOwnTaskAll(checkerItems,"","","","",1));
       }
        @Test
        public void test6() {
//               System.out.println(isAllowedUtils.isAllowedLogin());
//               System.out.println(isAllowedUtils.isAllowedSubmit("2019-12-15"));
                Double aDouble = sfcteDao.remoteFindRemainAcount("5102", "20150804001", "0070");
                System.out.println(aDouble);
                //  System.out.println(checkerPickDao.checkerFindOwnTaskAll(checkerItems,"","","","",1));
        }


        }

