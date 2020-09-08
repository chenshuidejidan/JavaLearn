package cn.hit.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void test1(){
        //获取连接,空参构造默认就是localhost和3306
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username","zhangsan");
        jedis.setex("name", 20, "lisi");  //20秒后自动删除数据

        jedis.hset("user", "username", "张三");
        jedis.hset("user", "password", "zhangsan123");
        Map<String, String> user = jedis.hgetAll("user");
        for(Map.Entry<String,String> entry:user.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());     //password--->zhangsan123  username--->张三
        }

        jedis.lpush("list", "张三", "李四", "王五");
        jedis.rpush("list", "赵六");
        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);       //[王五, 李四, 张三, 赵六]

        jedis.sadd("nameSet", "张三", "李四", "王五");
        Set<String> nameSet = jedis.smembers("nameSet");
        System.out.println(nameSet);    //[王五, 张三, 李四]

        jedis.zadd("nameZ", 40, "李四");
        jedis.zadd("nameZ", 50, "王五");
        jedis.zadd("nameZ", 30, "张三");
        Set<String> nameZ = jedis.zrange("nameZ", 0, -1);
        System.out.println(nameZ);      //[张三, 李四, 王五]

        //关闭连接
        jedis.close();
    }


    //jedis连接池
    @Test
    public void test2(){
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50); //最大连接
        config.setMaxIdle(10); //最大空闲连接
        //创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //获取连接对象
        Jedis jedis = jedisPool.getResource();
        //使用jedis
        jedis.set("name","张三");

        jedis.close();
    }

    //通过连接池工具类获取jedis
    @Test
    public void test3(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("name", "666");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}
