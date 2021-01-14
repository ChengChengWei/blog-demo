package top.cwcenter.dynamic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import top.cwcenter.dynamic.config.DataSourceContextHolder;

import java.lang.reflect.Method;

/**
 * 数据源切面，作用于注解了@DataSource的方法上，取注解的name属性作为数据源.
 *
 * @Author: Jie.He, hejie@baijiahulian.com
 * @Date: 2019/9/29 4:26 下午
 */
@Aspect
@Component
public class HandleDataSourceAspect {

    @Pointcut("@annotation(top.cwcenter.dynamic.aop.DataSource)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeExecute(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if (null == annotation) {
            annotation = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
        }
        if (null != annotation) {
            // 切换数据源
            DataSourceContextHolder.switchDataSource(annotation.value());
        }
    }

    @After("pointcut()")
    public void afterExecute() {
        DataSourceContextHolder.clear();
    }

}
