package cn.hit00.test;

import cn.hit13.io.Student;

@FunctionalInterface
public interface StudentBuilder {
    //定义根据传递的姓名、年龄、性别创建Student对象的方法
    Student buildStudent(String name, int age, String sex);
}
