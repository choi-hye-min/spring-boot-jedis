package com.arthur.springbootredis.repository;

import com.arthur.springbootredis.Person;

import java.util.Map;

public interface PersonRepository {
    void save(Person person);

    Person find(String id);

    Map<Object, Object> findAll();

    void delete(String id);
}
