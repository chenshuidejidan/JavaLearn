package cn.hit16.jdbc;

import java.sql.Timestamp;

class Student {
    private int id;
    private String name;
    private String address;
    private Timestamp add_time;

    public Student(int id, String name, String address, Timestamp add_time) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.add_time = add_time;
    }

    @Override
    public String toString() {
        return '\n'+
                "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", add_time=" + add_time +
                '}';
    }
}
