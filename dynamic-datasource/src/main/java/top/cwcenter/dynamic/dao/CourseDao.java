package top.cwcenter.dynamic.dao;

import org.apache.ibatis.annotations.Mapper;
import top.cwcenter.dynamic.aop.DataSource;
import top.cwcenter.dynamic.po.CoursePO;

import java.util.List;

/**
 * @Author C.W
 * @Date 2021/1/14 下午5:06
 * @Description course操作
 */
@Mapper
public interface CourseDao {

    /**
     * 插入
     *
     * @param coursePO
     * @return
     */
    @DataSource("dataSource2")
    Integer insert(CoursePO coursePO);

    /**
     * 查询所有
     *
     * @return
     */
    @DataSource("dataSource2")
    List<CoursePO> selectAll();

}
