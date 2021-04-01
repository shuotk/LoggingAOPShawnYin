package com.bfs.demo.dao;
import com.bfs.demo.domain.User;
import com.bfs.demo.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserDAO {
    static List<User> list;
    static{
        list = new ArrayList();
        list.add(User.builder().id(1).age(18).name("UserA").build());
        list.add(User.builder().id(2).age(22).name("UserB").build());
        list.add(User.builder().id(3).age(39).name("UserC").build());
        list.add(User.builder().id(4).age(26).name("UserD").build());
    }
    public List<User> findAll(){
        return list;
    }

    public List<User> findByName(String name){
        return list.stream().filter((u)->u.getName().equals(name)).collect(Collectors.toList());
    }
}
