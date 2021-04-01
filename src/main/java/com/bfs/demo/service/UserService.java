package com.bfs.demo.service;

import com.bfs.demo.dao.UserDAO;
import com.bfs.demo.domain.User;
import com.bfs.demo.exception.EmptyUserListException;
import com.bfs.demo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() throws EmptyUserListException {
        List<User> result = userDAO.findAll();
        if(result.isEmpty()){
            throw new EmptyUserListException("The User list is empty");
        }
        return userDAO.findAll();
    }

    public List<User> findByName(String name) throws UserNotFoundException {
        List<User> res = userDAO.findByName(name);
        if(res.isEmpty()){
            throw new UserNotFoundException(name);
        }
        return res;
    };
}
