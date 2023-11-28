package com.pro06.service;

import com.pro06.entity.User;
import com.pro06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void userInsert(User user) {
        userRepository.save(user);
    }
}
