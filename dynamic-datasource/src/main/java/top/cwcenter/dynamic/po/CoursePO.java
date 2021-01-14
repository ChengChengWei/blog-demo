package top.cwcenter.dynamic.po;

/**
 * @Author C.W
 * @Date 2021/1/14 下午5:05
 * @Description course对象
 */
public class CoursePO {

    /**
     * id
     */
    private Long id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 教师名
     */
    private String teacherName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "CoursePO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
