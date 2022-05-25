package org.ada.school.service;

import org.ada.school.model.User;
import org.ada.school.dto.*;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(String id){
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        userRepository.deleteById(id);
        if (userRepository.findById(id) != null){
            return false;
        }
        return true;
    }

    @Override
    public User update(UserDto userDto, String id) {
        User ch = findById(id);
        ch.update(userDto);
        return userRepository.save(ch);
    }
}
