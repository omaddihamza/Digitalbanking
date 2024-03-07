package org.sid.services;

import org.sid.entities.UserEntity;
import org.sid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImlp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> userList() {
        return userRepository.allUser();
    }
}
