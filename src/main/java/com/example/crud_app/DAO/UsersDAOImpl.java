package com.example.crud_app.DAO;


import com.example.crud_app.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class UsersDAOImpl implements UsersDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUsers(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUsers(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id=:id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void deleteUsers(int id) {
        User user = getUsers(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUsers(User updateUser) {
        entityManager.merge(updateUser);
        entityManager.flush();
    }
}
