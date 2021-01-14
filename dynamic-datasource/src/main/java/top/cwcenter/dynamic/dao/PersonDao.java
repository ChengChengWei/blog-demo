package top.cwcenter.dynamic.dao;

import org.apache.ibatis.annotations.Mapper;
import top.cwcenter.dynamic.po.PersonPO;

import java.util.List;

/**
 * @Author C.W
 * @Date 2021/1/14 下午5:06
 * @Description person操作
 */
@Mapper
public interface PersonDao {

    /**
     * 插入
     *
     * @param personPO
     * @return
     */
    Integer insert(PersonPO personPO);

    /**
     * 查询所有
     *
     * @return
     */
    List<PersonPO> selectAll();

}
