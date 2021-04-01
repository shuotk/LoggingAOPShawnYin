package com.bfs.demo.controller;

import com.bfs.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/executionTime")
    public ResponseEntity executionTime() {
        System.out.println("-----Executing Controller Layer-----");
        String res = testService.test();
        return new ResponseEntity(res,HttpStatus.OK);
    }

}
