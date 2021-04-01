package com.bfs.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

    public String test(){
        try {
            System.out.println("-----Executing DAO Layer-----");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data From DAO Layer";
    }
}
