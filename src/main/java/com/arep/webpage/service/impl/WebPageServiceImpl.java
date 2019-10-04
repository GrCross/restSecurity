package com.arep.webpage.service.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.User;
import com.arep.webpage.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebPageServiceImpl implements WebPageService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public List<User> consultarUsuarios() {
        return userDAO.loadAll();
    }

    @Override
    public User consultarUsuarioPorCorreo(String correo) {
        return userDAO.loadUsuarioByEmail(correo);
    }
}
