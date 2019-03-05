package com.arthur.springbootredis;

import com.arthur.springbootredis.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDataTypeTests {

    private Person person;

    ObjectMapper objectMapper = new ObjectMapper();;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {
        redisTemplate.getConnectionFactory()
                .getConnection()
                .flushAll();
    }

    @Test
    public void personSetTest() throws JsonProcessingException {
        person = Person.builder()
                .age(33)
                .id("11")
                .name("arthur")
                .build();

        redisTemplate.opsForValue().set(person.getName(), objectMapper.writeValueAsString(person));
        String result = String.valueOf(redisTemplate.opsForValue().get(person.getName()));

        Assert.assertNotNull(result);
    }

    @Test
    public void personHashTest() {
        Person person = Person.builder()
                .age(33)
                .id("key01")
                .name("arthur")
                .build();

        personRepository.save(person);
    }
}
