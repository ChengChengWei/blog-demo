package top.cwcenter.dynamic.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源.
 *
 * @Author: C.W
 * @Date: 2019/9/29 3:14 下午
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 获取当前线程的数据源.
     *
     * @return 当前使用的数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }

}
