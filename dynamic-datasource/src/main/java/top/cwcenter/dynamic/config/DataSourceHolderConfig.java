package top.cwcenter.dynamic.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: C.W
 * @date: 2020/4/13 5:44 下午
 */
@Configuration
public class DataSourceHolderConfig {

    @Autowired
    @Qualifier("dataSource1")
    private DataSource dataSource1;

    @Autowired
    @Qualifier("dataSource2")
    private DataSource dataSource2;

    @Bean(name = "routingDataSource")
    public RoutingDataSource routingDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put("dataSource1", dataSource1);
        dataSourceMap.put("dataSource2", dataSource2);

        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setTargetDataSources(dataSourceMap);
        // 默认使用um数据源.
        routingDataSource.setDefaultTargetDataSource(dataSource1);
        return routingDataSource;
    }

    @Bean(name = "mybatisConfig")
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("routingDataSource") DataSource routingDataSource, @Qualifier("mybatisConfig") org.apache.ibatis.session.Configuration configuration)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(routingDataSource);
        bean.setConfiguration(configuration);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        return bean.getObject();
    }
}
