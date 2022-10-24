package com.example.crud_app.service;

import com.example.crud_app.DAO.UsersDAO;
import com.example.crud_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl  implements UsersService{

    private final UsersDAO usersDAO;

    @Autowired
    public UsersServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUsers(User user) {
        usersDAO.saveUsers(user);
    }

    @Override
    @Transactional
    public User getUsers(int id) {
        return usersDAO.getUsers(id);
    }

    @Override
    @Transactional
    public void deleteUsers(int id) {
        usersDAO.deleteUsers(id);
    }

    @Override
    @Transactional
    public void updateUsers(User updateUser) {
        usersDAO.updateUsers(updateUser);
    }
}
