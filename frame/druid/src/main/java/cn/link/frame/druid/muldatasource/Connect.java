package cn.link.frame.druid.muldatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect implements CommandLineRunner {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    @Qualifier("one")
    private DataSource one;

    @Autowired
    @Qualifier("two")
    private DataSource two;

    @Override
    public void run(String... args) throws Exception {
//        readData(dataSource.getConnection());
        readData(one.getConnection());
        readData(two.getConnection());
    }

    public void readData(Connection connect) throws SQLException {
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("select * from apps");
        while(rs.next()){
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
            System.out.println();
        }
    }
}
