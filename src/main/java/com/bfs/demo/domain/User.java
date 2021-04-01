package com.bfs.demo.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;

    //User user = new User();
    //user.setXXX();
    //user.setXXX();
    //user.setXXX();
}
