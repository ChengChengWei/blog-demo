package top.cwcenter.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cwcenter.dynamic.dao.CourseDao;
import top.cwcenter.dynamic.dao.PersonDao;
import top.cwcenter.dynamic.po.CoursePO;
import top.cwcenter.dynamic.po.PersonPO;

import java.util.List;

/**
 * @Author C.W
 * @Date 2021/1/14 下午5:11
 * @Description mybatis测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTests {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private CourseDao courseDao;


    @Test
    public void test() {
        // 查询两个数据源数据
        List<PersonPO> personPOList = personDao.selectAll();
        List<CoursePO> coursePOList = courseDao.selectAll();
        System.out.println(String.format("数据源1 数据条数:%d, 数据:%s", personPOList.size(), personPOList));
        System.out.println(String.format("数据源2 数据条数:%d, 数据:%s", coursePOList.size(), coursePOList));
        // 新增数据
        PersonPO personPO = new PersonPO();
        personPO.setName("小明");
        personPO.setAge(25);
        personDao.insert(personPO);
        CoursePO coursePO = new CoursePO();
        coursePO.setName("java程序设计");
        coursePO.setTeacherName("王老师");
        courseDao.insert(coursePO);

        personPOList = personDao.selectAll();
        coursePOList = courseDao.selectAll();
        System.out.println(String.format("数据源1 数据条数:%d, 数据:%s", personPOList.size(), personPOList));
        System.out.println(String.format("数据源2 数据条数:%d, 数据:%s", coursePOList.size(), coursePOList));
    }

}
