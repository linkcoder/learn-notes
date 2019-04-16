package cn.link.frame.druid.monitor;

import com.alibaba.druid.filter.stat.StatFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitorConfig {

    @Bean(name = "stat")
    public StatFilter statFilter(){
        StatFilter filter = new StatFilter();
        filter.setMergeSql(false);
        filter.setSlowSqlMillis(1000);

        return filter;
    }
}
