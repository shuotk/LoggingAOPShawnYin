package com.bfs.demo.exception.handler;

import com.bfs.demo.domain.ErrorMessage;
import com.bfs.demo.domain.UserResponse;
import com.bfs.demo.exception.EmptyUserListException;
import com.bfs.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerUserNotFound(UserNotFoundException e){
        System.out.println("If UserNotFoundException throws, it will be intercepted by this handler");
        return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()+" Not Found").build(), HttpStatus.OK);
    }

    @ExceptionHandler(value={EmptyUserListException.class})
    public ResponseEntity<ErrorMessage> handlerEmptyUserList(EmptyUserListException e){
        System.out.println("If EmptyUserListException throws, it will be intercepted by this handler");
        return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()).build(), HttpStatus.OK);
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<ErrorMessage> handlerException(Exception e){
        return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
