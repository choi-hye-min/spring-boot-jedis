package com.arthur.springbootredis.repository;

import com.arthur.springbootredis.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PersonRespositoryImpl implements PersonRepository {

    ObjectMapper objectMapper = new ObjectMapper();;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private static String redisKey = "person";

    @Override
    public void save(Person person) {
        try {
            redisTemplate.opsForHash().put(redisKey, person.getId(), objectMapper.writeValueAsString(person));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person find(String id) {
        return null;
    }

    @Override
    public Map<Object, Object> findAll() {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
