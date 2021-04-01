package com.bfs.demo.controller;

import com.bfs.demo.domain.ErrorMessage;
import com.bfs.demo.domain.UserResponse;
import com.bfs.demo.exception.EmptyUserListException;
import com.bfs.demo.exception.UserNotFoundException;
import com.bfs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//least invasive
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<UserResponse> findAll() throws EmptyUserListException {
        try {
            UserResponse userResponse = UserResponse.builder().userList(userService.findAll()).build();
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (EmptyUserListException e){
            return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()).build(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{name}")
    public ResponseEntity findByName(@PathVariable String name) throws UserNotFoundException {
//        too many try catch block
//        try{
//            UserResponse userResponse = UserResponse.builder().userList(userService.findByName(name)).build();
//            return new ResponseEntity(userResponse,HttpStatus.OK);
//        }catch (UserNotFoundException e){
//            return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()+" Not Found").build(),HttpStatus.NOT_FOUND);
//        }

        UserResponse userResponse = UserResponse.builder().userList(userService.findByName(name)).build();
        return new ResponseEntity<>(userResponse,HttpStatus.OK);

    }

}
