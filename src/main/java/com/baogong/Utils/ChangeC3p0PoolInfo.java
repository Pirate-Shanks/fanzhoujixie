package com.baogong.Utils;

import com.baogong.dao.logTask.DatabaseDao;
import com.baogong.pojo.DatabaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

@Component
public class ChangeC3p0PoolInfo {

    @Autowired
    private DatabaseDao databaseDao;

    public void Change(int index,String content) throws ParserConfigurationException, IOException, SAXException, TransformerException {
       //System.getProperty("user.dir")+".\\src\\main\\resources\\c3p0-config.xml".\src\\main\resources\c3p0-config.xml
        //File file = ResourceUtils.getFile("classpath:c3p0-config.xml");//Persons.xml文件绝对路径this.getClass().getClassLoader().getResource("").getPath()+
        Resource resource = new ClassPathResource("c3p0-config.xml");
        InputStream inputStream = resource.getInputStream();
//        InputStream inputStream = ClassUtils.class.getResourceAsStream(+"c3p0-config.xml");
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //②获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(inputStream);
        //③通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();
        NodeList personList = root.getElementsByTagName("named-config");
        Node item = personList.item(1);
        Element personElement = (Element) item;
        NodeList nameList = personElement.getElementsByTagName("property");
        Node item1;
        DatabaseInfo info = databaseDao.findDatabaseInfo();
       if(index==1) {
           item1=nameList.item(1);
           String databaseName = info.getDatabaseName();
           item1.setTextContent("jdbc:sqlserver://"+content+"; DatabaseName="+databaseName);
       }else if(index==2){
           item1=nameList.item(1);
           String ip = info.getIp();
           item1.setTextContent("jdbc:sqlserver://"+ip+"; DatabaseName="+content);
       }else if(index==3){
           item1=nameList.item(2);
           String userName = info.getUserName();
           item1.setTextContent(content);
       }else {
           item1=nameList.item(3);
           String password = info.getPassword();
           item1.setTextContent(content);
       }
        Transformer ts = TransformerFactory.newInstance().newTransformer();
        ts.transform(new DOMSource(doc), new StreamResult("c3p0-config.xml"));
    }
}
