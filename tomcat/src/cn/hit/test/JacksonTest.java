package cn.hit.test;

import cn.hit.domain.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonTest {
    //java对象转json
    @Test
    public void test1() throws IOException {
        Person p = new Person("张三",13,"深圳");

        //创建json的核心对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);       //{"name":"张三","age":13,"address":"深圳"}

        mapper.writeValue(new File("D:\\a.txt"),p);
    }

    @Test
    public void test2() throws JsonProcessingException {
        Person p1 = new Person("张三",13,"深圳");
        Person p2 = new Person("李四",14,"深圳");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        String json = new ObjectMapper().writeValueAsString(list);
        System.out.println(json);   //[{"name":"张三","age":13,"address":"深圳"},{"name":"李四","age":14,"address":"深圳"}]
    }

    @Test
    public void test3() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 13);
        map.put("address", "深圳");
        String json = new ObjectMapper().writeValueAsString(map);
        System.out.println(json);   //{"address":"深圳","name":"张三","age":13}
    }

    @Test
    public void test4() throws IOException {
        String json = "{\"address\":\"深圳\",\"name\":\"张三\",\"age\":13}";
        Person person = new ObjectMapper().readValue(json, Person.class);
        System.out.println(person);
    }
}
