package cn.link.frame.druid.muldatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {


    @Bean(name = "one")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSource1(@Value("${publickey}") String publicKey,
                                  @Value("${spring.datasource.druid.one.password}") String ciphertext) {

        DBPasswordDecoder decoder = new DBPasswordDecoder(publicKey, ciphertext);

        DruidDataSource ds = new DruidDataSource();
        ds.setPasswordCallback(decoder);
        return ds;
    }

    @Bean(name = "two")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSource2(@Value("${publickey}") String publicKey,
                                  @Value("${spring.datasource.druid.two.password}") String ciphertext){

        DBPasswordDecoder decoder = new DBPasswordDecoder(publicKey, ciphertext);

        DruidDataSource ds = new DruidDataSource();
        ds.setPasswordCallback(decoder);
        return ds;
    }
}
