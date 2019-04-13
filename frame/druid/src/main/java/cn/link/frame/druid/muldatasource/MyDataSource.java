package cn.link.frame.druid.muldatasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;

public class MyDataSource extends DruidDataSource {

    @Value("${publickey}")
    private String publicKey;

    @Override
    public void setPassword(String ciphertext){

        try {
            String password = ConfigTools.decrypt(publicKey,ciphertext);
            System.out.println("my  ===== " + password);
            super.setPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
