package com.SpringData.SpringData.service;

import com.SpringData.SpringData.domin.rol;
import com.SpringData.SpringData.domin.usuarios;
import com.SpringData.SpringData.repo.UsuarioRepo;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * convertimos esta clase en una de servicio que la va utilizar SpringSecrity
 * por lo que debe tener exactamente en nombre que le pasamos
 * "userDetailsService"
 */
@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {

    // inyectamos la clase de UsuarioRepo
    // con esta clase es que vamos a interactuar con las 
    //   tablas de usuarios y rol, ya que estan relacionadas
    @Autowired
    private UsuarioRepo usuarioRepo;

    //va a obtener el OBJ de usuario filtrado por un username 
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // recuperamos un usuario
        usuarios usuario = usuarioRepo.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException(username);
        }
        /**
         * recupearmos los roles asociados y para que funcione debemos envolver
         * los roles en la clase GrantedAuthority
         */
        var roles = new ArrayList<GrantedAuthority>();
           /**
            * recuperamos los roles que tiene el usuario que pasamos
            * siempre utilizando la clase GrantedAuthority
         */
        for (rol rl : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rl.getNombre()));
        }
        // retornamos los elementos que hemos recuprado dentro de la clase User
        //que es una clase de spring
        return new User(usuario.getUsername(), usuario.getPassword(), roles);

    }

}
