package jdbcTemplate;

import java.sql.Timestamp;

class Student {
    private int id;
    private String name;
    private String address;
    private Timestamp add_time;

    public Student() {
    }

    public Student(int id, String name, String address, Timestamp add_time) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Timestamp add_time) {
        this.add_time = add_time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", add_time=" + add_time +
                '}';
    }
}
