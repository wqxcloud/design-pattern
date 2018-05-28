package com.xiaoxin.guava.util.compare;

import com.google.common.collect.ComparisonChain;
import lombok.*;

/**
 * @Auther zhangyongxin
 * @date 2018/5/28 下午4:52
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Comparable<Person>{

    private String id;

    private String name;

    private Integer age;


    @Override
    public int compareTo(Person person) {
        return ComparisonChain.start().compare(this.name,person.name)
                .compare(this.age,person.age).compare(this.id,person.id).result();
    }
}
