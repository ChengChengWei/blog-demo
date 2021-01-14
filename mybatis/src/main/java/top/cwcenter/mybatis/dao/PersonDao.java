package top.cwcenter.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.cwcenter.mybatis.po.PersonPO;

import java.util.List;

/**
 * @Author C.W
 * @Date 2021/1/14 下午3:28
 * @Description person表查询
 */
@Mapper
public interface PersonDao {

    /**
     * 新增
     *
     * @param personPO
     * @return
     */
    Integer insert(PersonPO personPO);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    Integer deleteById(@Param("id") Long id);

    /**
     * 根据id更新
     *
     * @param personPO
     * @return
     */
    Integer updateById(PersonPO personPO);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    PersonPO selectById(@Param("id") Long id);

    /**
     * 查询所有
     *
     * @return
     */
    List<PersonPO> selectAll();

}
