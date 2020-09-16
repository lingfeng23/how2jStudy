package redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author malf
 * @description Redis 测试类
 * @project how2jStudy
 * @since 2020/9/16
 */
public class TestRedis {
	JedisPool pool;
	Jedis jedis;

	@Before
	public void setUp() {
		jedis = new Jedis("localhost");
	}

	/**
	 * Redis 存储初级字符串
	 */
	@Test
	public void testString() {
		// 添加数据
		jedis.set("name", "张三");
		System.out.println(jedis.get("name"));
		// 修改数据
		// 1、在原来基础上修改
		jedis.append("name", "李四");
		System.out.println(jedis.get("name"));
		// 2、直接覆盖原来数据
		jedis.set("name", "王五");
		System.out.println(jedis.get("name"));
		// 删除key对应的记录
		jedis.del("name");
		System.out.println(jedis.get("name"));
		// 批量添加数据
		jedis.mset("name", "赵六", "age", "10");
		System.out.println(jedis.mget("name", "age"));
	}

	/**
	 * 操作Map
	 */
	@Test
	public void testMap() {
		Map<String, String> user = new HashMap<>();
		user.put("name", "张三");
		user.put("age", "20");
		// 添加Map
		jedis.hmset("user", user);
		List<String> userName = jedis.hmget("user", "name");
		System.out.println(userName);
		// 删除某个键值
		jedis.hdel("user", "age");
		System.out.println(jedis.hmget("user", "age"));
		System.out.println(jedis.hlen("user"));
		System.out.println(jedis.exists("user"));
		System.out.println(jedis.hkeys("user"));
		System.out.println(jedis.hvals("user"));
		Iterator<String> iterator = jedis.hkeys("user").iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + "=" + jedis.hmget("user", key));
		}
	}

	/**
	 * 操作List
	 */
	@Test
	public void testList() {
		// 先删除List内容
		jedis.del("list");
		System.out.println(jedis.lrange("list", 0, -1));
		// 添加List
		jedis.lpush("list", "AAA");
		jedis.lpush("list", "BBB");
		jedis.lpush("list", "CCC");
		jedis.lpush("list", "DDD");
		// 取出数据
		System.out.println(jedis.lrange("list", 0, -1));
	}

	/**
	 * 操作Set
	 */
	@Test
	public void testSet() {
		// 添加数据
		jedis.sadd("set","AA");
		jedis.sadd("set","BB");
		jedis.sadd("set","CC");
		jedis.sadd("set","DD");
		// 移除数据
		jedis.srem("set","DD");
		System.out.println(jedis.smembers("set"));
		System.out.println(jedis.sismember("set","BB"));
		System.out.println(jedis.srandmember("set"));
		System.out.println(jedis.scard("set"));
	}

	public static void main(String[] args) {
		/*Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);*/
	}
}
