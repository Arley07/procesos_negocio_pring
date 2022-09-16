package com.procesos.negocio.arley.controllers;

import com.procesos.negocio.arley.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UsuarioController {

    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Arley");
        usuario.setApellidos("Melo");
        usuario.setDocumento("1004897619");
        usuario.setDireccion("Kdx ssss");
        usuario.setFechaNacimiento(new Date(2000,10,17));
        usuario.setTelefono("3212010063");
        return usuario;

    }

}
