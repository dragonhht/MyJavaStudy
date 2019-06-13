# Spring-data-redis

## 连接工厂

###   `Lettuce`连接工厂

> Lettuce基于Netty的连接实例（StatefulRedisConnection），可以在多个线程间并发访问，且线程安全，满足多线程环境下的并发访问，同时它是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。

#### Java编码方式

```
@Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisConfiguration redisConfiguration = new RedisStandaloneConfiguration("my.dragon.com", 6379);
        return new LettuceConnectionFactory(redisConfiguration);
    }
```

#### 配置文件方式

```yaml
spring:
  redis:
    host: my.dragon.com
    port: 6379
    timeout: 5000
    database: 0
    # lettuce相关配置
    lettuce:
      pool:
        max-active: 8
        max-wait: -1
        max-idle: 8
        min-idle: 0
```

-   `Jedis`连接工厂

> Jedis在实现上是直连redis server，多线程环境下非线程安全，除非使用连接池，为每个Jedis实例增加物理连接。

#### Java编码方式

```
// 使用该方法需引入Jedis依赖
@Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration("my.dragon.com", 6379);
        return new JedisConnectionFactory(redisConfiguration);
    }
``` 

## 自定义`RedisTemplate`

-   可将可序列化对象转成json后处理

```
@Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
```

-   使用

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRedisStudyApplicationTests {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testTemplate() {
        redisTemplate.opsForValue().set("spring:data:user", new User("dragonhht", 20));
        User user = (User) redisTemplate.opsForValue().get("spring:data:user");
        System.out.println(user);
    }

}
```

## 直接使用Redis相关类型的操作类

-   此处以列表为例

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRedisStudyApplicationTests {

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOperations;

    @Test
    public void testOperations() {
        listOperations.leftPush("spring:data:list", "dragonhht");
        listOperations.leftPush("spring:data:list", "20");

        List<String> list = listOperations.range("spring:data:list", 0, -1);
        list.forEach(System.out::println);
    }

}
```

## 通过`RedisTemplate`或`StringRedisTemplate`直接获取连接操作

```
@Test
    public void testCallback() {
        stringRedisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                // 当使用stringRedisTemplate时，可以转换为StringRedisConnection
                StringRedisConnection stringRedisConnection = (StringRedisConnection) redisConnection;
                stringRedisConnection.set("spring:data:callback", "callback");
                System.out.println(stringRedisConnection.get("spring:data:callback"));
                return null;
            }
        });
    }
```

## 哈希映射器

-   多种实现方式

    -   `BeanUtilsHashMapper`
    
    -   `ObjectHashMapper`
    
    -   `Jackson2HashMapper`

-   示例

```
@Test
    public void testHashMapper() {
        HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();
        Map<byte[], byte[]> user = mapper.toHash(new User("hello", 20));
        hashOperations.putAll("spring:data:hash", user);

        Map<byte[], byte[]> hash = hashOperations.entries("spring:data:hash");
        User u = (User) (mapper).fromHash(hash);
        System.out.println(u);
    }
```