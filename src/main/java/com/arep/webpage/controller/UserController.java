package com.arep.webpage.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.arep.webpage.exceptions.NotFoundException;
import com.arep.webpage.model.User;
import com.arep.webpage.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/webPage")
public class UserController {

    @Autowired
    WebPageService webPageService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<User>> recursoConsultarUsuarios() throws NotFoundException {
        try {
            List<User> usuarios = webPageService.consultarUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/usuarios/{correo}", method = RequestMethod.GET)
    public ResponseEntity<User> recursoConsultarUsuarioPorCorreo(@PathVariable String correo)
            throws NotFoundException {
        try {
            User usuario = webPageService.consultarUsuarioPorCorreo(correo);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }
}
