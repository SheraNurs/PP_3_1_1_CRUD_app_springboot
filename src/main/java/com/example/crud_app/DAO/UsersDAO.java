package com.example.crud_app.DAO;


import com.example.crud_app.model.User;

import java.util.List;

public interface UsersDAO {

    public List<User> getAllUsers();

    public void saveUsers(User user);

    public User getUsers(int id);

    public void deleteUsers(int id);

    public void updateUsers(User updateUser);
}
