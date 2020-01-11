package cn.redis.RedisTest;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test1 {
    @Test
    public void demo1(){
        //创建Jedis对象
        Jedis jedis=new Jedis("192.168.43.220",6379);
        //进行jedis set操作
        jedis.set("007","island");
        //获取添入的值
        String str = jedis.get("007");
        //打印值
        System.out.println("007_:"+str);
        //关闭jedis
        jedis.close();
    }

    //使用连接池连接
    @Test
    public void demo2(){
        //new 连接池对象
        JedisPool jedisPool=new JedisPool("192.168.43.220",6379);
        //获取jedis对象
        Jedis jedis = jedisPool.getResource();
        //获取值
        String str = jedis.get("007");
        //打印值
        System.out.println("007_:"+str);
        //关闭资源
        jedis.close();
        //关闭连接池
        jedisPool.close();
    }
}
