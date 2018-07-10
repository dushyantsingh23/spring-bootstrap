package com.springbootstrap.service;

import com.springbootstrap.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service("userService")
public class UserService {

    private static volatile Map<String, User> userMap = new LinkedHashMap<>();

    public User getUserById(String id) {
        if (userMap.containsKey(id)) {
            return userMap.get(id);
        }

        return null;
    }

    public User createUser(User user) {
        String id = String.valueOf(userMap.size() + 1);
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    public void deleteUser(String id) {
        userMap.remove(userMap.get(id));
    }
}
