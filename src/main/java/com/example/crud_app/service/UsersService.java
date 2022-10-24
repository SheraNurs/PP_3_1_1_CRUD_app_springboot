package com.example.crud_app.service;


import com.example.crud_app.model.User;

import java.util.List;

public interface UsersService {
    public List<User> getAllUsers();

    public void saveUsers(User user);

    public User getUsers(int id);

    public void deleteUsers(int id);

    public void updateUsers(User updateUser);

}
