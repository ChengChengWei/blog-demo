package top.cwcenter.dynamic.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author C.W
 * @Date 2021/1/14 上午10:17
 * @Description um MySQL配置
 */
@Configuration
public class DataSource1Config {

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.mysql01")
    public DataSource tidbDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "transactionManager1")
    public PlatformTransactionManager dataSourceTransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
