package cn.link.frame.druid.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class WebController {

    @Autowired
    @Qualifier(value = "one")
    private DataSource d1;


    @Autowired
    @Qualifier(value = "two")
    private DataSource d2;


    @Autowired
    private DataSource ds;

    @RequestMapping("/query")
    public String search() throws SQLException {
//        ResultSet rs1 = d1.getConnection().createStatement().executeQuery("select * from apps");
//        while (rs1.next()){
//            rs1.getString(1);
//        }
//
//        ResultSet rs2 = d2.getConnection().createStatement().executeQuery("select * from apps");
//        while (rs2.next()){
//            rs2.getString(1);
//        }
//        rs1.close();
//        rs2.close();
        ResultSet rs1 = d1.getConnection().createStatement().executeQuery("select * from apps");
        while (rs1.next()){
            String str = rs1.getString(1);
            System.out.println(str);
        }
        rs1.close();
        return "success";
    }
}
