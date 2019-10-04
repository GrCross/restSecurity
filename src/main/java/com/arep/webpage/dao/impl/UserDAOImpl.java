package com.arep.webpage.dao.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User loadUsuarioByEmail(String correo)  {
        String sql = "SELECT * FROM usuario u WHERE u.email = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { correo });

        User usuario = (User) jdbcTemplate.queryForObject(sql, new Object[] { correo }, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
                User usuario = new User();
                usuario.setName(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTelephone(rs.getString("telephone"));
                return usuario;
            }
        });
        return usuario;
    }

    @Override
    public List<User> loadAll() {
        String sql = "SELECT * FROM usuario u";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<User> usuarios = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            User usuario = new User();
            usuario.setName((String)row.get("name"));
            usuario.setEmail((String)row.get("email"));
            usuario.setPassword((String)row.get("password"));
            usuario.setTelephone((String)row.get("telephone"));
            usuarios.add(usuario);
        }
        return usuarios;
    }
}
