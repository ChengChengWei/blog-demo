package top.cwcenter.dynamic.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，注解在dao接口或方法上，指定使用的数据源.
 *
 * @Author: Jie.He, hejie@baijiahulian.com
 * @Date: 2019/9/29 4:24 下午
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    String value() default "";

}
