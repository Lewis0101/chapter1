package com.battcn.chapter1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : 00222 [liu.yang@unisinsight.com]
 * @description:
 * @date : 2019/3/19 9:55
 * @since: 1.0
 */

@Component
@ConfigurationProperties(prefix = "my1")
class MyProperties1 {

    public int age;
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "MyProperties{" +
                "age=" + age +
                ", name='" + name +'\''+
                '}';
    }
}
