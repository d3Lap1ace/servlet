package com.javaEE.ajax;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 11:33 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class Student {
    private String name;
    private Integer age;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
