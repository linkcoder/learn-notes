package cn.link.frame.druid.muldatasource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatasourceConfig {

    @Bean(name = "one")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSource1(@Value("${publickey}") String publicKey,
                                  @Value("${spring.datasource.druid.one.password}") String ciphertext,
                                  @Qualifier("stat") StatFilter filter) {

        DBPasswordDecoder decoder = new DBPasswordDecoder(publicKey, ciphertext);

        List<Filter> filterList = new ArrayList<>();
        filterList.add(filter);

        DruidDataSource ds = new DruidDataSource();
        ds.setPasswordCallback(decoder);
        ds.setProxyFilters(filterList);
        return ds;
    }

    @Bean(name = "two")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSource2(@Value("${publickey}") String publicKey,
                                  @Value("${spring.datasource.druid.two.password}") String ciphertext,
                                  @Qualifier("stat") StatFilter filter){

        DBPasswordDecoder decoder = new DBPasswordDecoder(publicKey, ciphertext);

        List<Filter> filterList = new ArrayList<>();
        filterList.add(filter);

        DruidDataSource ds = new DruidDataSource();
        ds.setPasswordCallback(decoder);
        ds.setProxyFilters(filterList);
        return ds;
    }
}
