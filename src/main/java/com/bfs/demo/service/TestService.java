package com.bfs.demo.service;

import com.bfs.demo.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TestService {

    @Autowired
    private TestDAO testDAO;

//    @Transactional
    public String test(){
       return testDAO.test();
    }
}
