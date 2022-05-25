package edu.eci.ieti.lab01.service.impl;

import edu.eci.ieti.lab01.data.User;
import edu.eci.ieti.lab01.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService {

    private HashMap<String, User> users = new HashMap<String, User>();
    private Integer current = 1;

    @Override
    public User Create(User user) {
        user.setId(current.toString());
        user.setCreatedAt(java.time.LocalDate.now().toString());
        users.put(current.toString(), user);
        current += 1;
        return user;
    }

    @Override
    public User findById(String id) {
        try{
            return users.get(id);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        List<User> ret = new ArrayList<User>();
        for (String id : users.keySet()){
            ret.add(users.get(id));
        }
        return ret;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        return users.put(userId, user);
    }
}
