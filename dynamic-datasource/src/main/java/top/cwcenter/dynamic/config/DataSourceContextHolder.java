package top.cwcenter.dynamic.config;

/**
 * ThreadLocal变量，用于记录当前线程使用的数据源,配合AOP实现数据源切换.
 *
 * @Author: C.W
 * @Date: 2019/9/29 3:15 下午
 */
public class DataSourceContextHolder {

    private static final String MYSQL_DATASOURCE = "dataSource1";
    private static final ThreadLocal<String> DATASOURCE_CONTEXT = new ThreadLocal<>();

    public static void switchDataSource(String datasource) {
        DATASOURCE_CONTEXT.set(datasource);
    }

    public static String getDataSource() {
        String dataSource = DATASOURCE_CONTEXT.get();
        if (dataSource == null || dataSource.equals("")) {
            return MYSQL_DATASOURCE;
        }
        return dataSource;
    }

    /**
     * 清除ThreadLocal的值，每次切换数据源查询后清理，避免与线程池同时使用时ThreadLocal中有残留.
     */
    public static void clear() {
        DATASOURCE_CONTEXT.remove();
    }

}
