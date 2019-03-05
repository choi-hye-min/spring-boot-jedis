package com.arthur.springbootredis;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class Person implements Serializable {
    private static final long serialVersionUID = -8243145429438016231L;

    private String id;

    private String name;

    private int age;

    @Builder
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
