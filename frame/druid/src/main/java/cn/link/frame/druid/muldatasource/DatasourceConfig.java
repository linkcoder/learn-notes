package cn.link.frame.druid.muldatasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {


    @Bean(name = "one")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSource1(@Value("${spring.datasource.druid.one.password}") String ciphertext ) {
        System.out.println(ciphertext);
        DruidDataSource ds = new DruidDataSource();
        ds.setPassword(ciphertext);
        return ds;
    }

    @Bean(name = "two")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSource2(
//            @Value("${spring.datasource.druid.two.password}") String ciphertext
    ){
//        System.out.println(ciphertext);
        DruidDataSource ds = null;
        try {
            ds = new MyDataSource();
            ds.setPassword("hellosql");
        } catch (Exception e) {
            System.out.println(ds.getPassword());
            e.printStackTrace();
        }
        return ds;
    }
}
