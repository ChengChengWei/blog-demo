package top.cwcenter.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cwcenter.mybatis.dao.PersonDao;
import top.cwcenter.mybatis.po.PersonPO;

import java.util.List;

/**
 * @Author C.W
 * @Date 2021/1/14 下午3:52
 * @Description mybatis测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTests {

    @Autowired
    private PersonDao personDao;

    @Test
    public void test() {
        // 查询数量
        List<PersonPO> personPOList = personDao.selectAll();
        System.out.println(String.format("当前person表中数量为:%d, 数据为:%s", personPOList.size(), personPOList));
        // 插入数据
        PersonPO xiaoming = new PersonPO();
        xiaoming.setAge(25);
        xiaoming.setName("小明");
        personDao.insert(xiaoming);
        personPOList = personDao.selectAll();
        System.out.println(String.format("当前person表中数量为:%d, 数据为:%s", personPOList.size(), personPOList));
        PersonPO xiaohong = new PersonPO();
        xiaohong.setAge(18);
        xiaohong.setName("小红");
        personDao.insert(xiaohong);
        personPOList = personDao.selectAll();
        System.out.println(String.format("当前person表中数量为:%d, 数据为:%s", personPOList.size(), personPOList));
        // 删除一条
        personDao.deleteById(personPOList.get(0).getId());
        personPOList = personDao.selectAll();
        System.out.println(String.format("当前person表中数量为:%d, 数据为:%s", personPOList.size(), personPOList));
        // 更新年龄
        PersonPO personPO = personPOList.get(0);
        personPO.setAge(30);
        personDao.updateById(personPO);
        personPOList = personDao.selectAll();
        System.out.println(String.format("当前person表中数量为:%d, 数据为:%s", personPOList.size(), personPOList));
    }

}
