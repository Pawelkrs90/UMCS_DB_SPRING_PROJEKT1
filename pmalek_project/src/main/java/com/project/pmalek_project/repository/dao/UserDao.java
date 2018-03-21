package com.project.pmalek_project.repository.dao;

import com.project.pmalek_project.repository.model.User;

import java.util.List;

public interface UserDao {

    public User getById(Long id);
    public List<User> getAll();
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public void delete(Long id);
}
