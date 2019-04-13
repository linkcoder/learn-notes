package cn.link.frame.druid;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest
@RunWith(SpringRunner.class)
public class DruidDeEnTest {

//    @Value("${spring.datasource.password}")
    static String passCry = "DO0OZkloDRlQBgamd2ObGFgpvzL2mQePWyTW0zvMkkod2MS0/0KnirvmMyZS7tthy0wRMZl2XuEesdKmc/w4Zg==";

//    @Value("${publickey}")
    static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKGlIBr52L0pYvfmzrFb4/nl/cyNNy70lNhurfcrLvWKcupPd1SRNMrFoHmVMNjGNu0i5q41yb9hvqDt3q/Q0pECAwEAAQ==";

    @Test
    public void decrypt(){
        try {
            String password = ConfigTools.decrypt(publicKey, passCry);
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
