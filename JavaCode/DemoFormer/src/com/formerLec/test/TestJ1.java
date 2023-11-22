package com.formerLec.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formerLec.JsonT.Dog;
import com.formerLec.JsonT.Person;
import org.junit.Test;

/**
 * @author 陆涛
 * @version 1.0
 */
public class TestJ1 {
    @Test
    public void writeJSON() throws JsonProcessingException {
        //实例化person对象,将其转化为JSON串
        Dog dog = new Dog("kat");
        Person person = new Person("lt", 22, dog);
        //转换
        ObjectMapper objectMapper = new ObjectMapper();
        String personStr = objectMapper.writeValueAsString(person);
        System.out.println(personStr);
    }
    @Test
    public void readJSON() throws JsonProcessingException {
        String personStr = "{\"name\":\"lt\",\"age\":22,\"dog\":{\"name\":\"kat\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(personStr, Person.class);
        System.out.println(person);
    }
}
