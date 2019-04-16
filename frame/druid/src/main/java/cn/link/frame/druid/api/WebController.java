package cn.link.frame.druid.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class WebController {

    @Autowired
    @Qualifier("one")
    private DataSource ds1;

    @Autowired
    @Qualifier("two")
    private DataSource ds2;

    @RequestMapping("/query")
    public String search() throws SQLException {
        ResultSet rs1 = ds1.getConnection().createStatement().executeQuery("select * from t_permission");
        while (rs1.next()){
            String string = rs1.getString(1);
            System.out.println(string);
        }

        ResultSet rs2 = ds2.getConnection().createStatement().executeQuery("select * from t_sample");
        while (rs2.next()){
            String string = rs2.getString(1);
            System.out.println(string);
        }
        rs1.close();
        rs2.close();
//        Connection connection = ds.getConnection();

//        ResultSet rs1 = connection.createStatement().executeQuery("select * from apps");
//        while (rs1.next()){
//            String str = rs1.getString(2);
//            System.out.println(str);
//        }
//        rs1.close();
        return "success";
    }
}
