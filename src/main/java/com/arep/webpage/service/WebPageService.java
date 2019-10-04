package com.arep.webpage.service;


import com.arep.webpage.model.User;

import java.util.List;

/**
 * La clase SchiNotesService representa los servicios que se pueden ofrecer.
 */
public interface WebPageService {


    public User consultarUsuarioPorCorreo(String correo) ;
    public List<User> consultarUsuarios();


}
