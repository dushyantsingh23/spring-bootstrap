package com.springbootstrap.controller;

import com.springbootstrap.model.User;
import com.springbootstrap.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@Api
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "To get user by id")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public User getUser(@ApiParam @PathVariable("id") String id) {
        LOG.info("Request received to get user by id: {}", id);
        return userService.getUserById(id);
    }

    @ApiOperation(value = "To create new user")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        LOG.info("Request received to create user: {}", user);
        return userService.createUser(user);
    }

    @ApiOperation(value = "To update existing user")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        LOG.info("Request received to update user:{}, {}", id, user);
        return userService.updateUser(id, user);
    }

    @ApiOperation(value = "To delete existing user")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        LOG.info("Request received to delete user: {}", id);
        userService.deleteUser(id);
    }
}
