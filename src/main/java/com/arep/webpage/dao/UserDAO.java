package com.arep.webpage.dao;

import com.arep.webpage.model.User;

import java.util.List;

public interface UserDAO {

    public User loadUsuarioByEmail(String correo);
    public List<User> loadAll();

}
