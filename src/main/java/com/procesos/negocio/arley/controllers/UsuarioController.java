package com.procesos.negocio.arley.controllers;

import com.procesos.negocio.arley.models.Usuario;
import com.procesos.negocio.arley.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping(value = "/usuario/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id){
//        Usuario usuario = new Usuario();
//        usuario.setId(id);
//        usuario.setNombre("Arley");
//        usuario.setApellidos("Melo");
//        usuario.setDocumento("1004897619");
//        usuario.setDireccion("Kdx ssss");
//        usuario.setFechaNacimiento(new Date(2000,10,17));
//        usuario.setTelefono("3212010063");
          Optional<Usuario> usuario = usuarioRepository.findById(id);
          return usuario;

    }

    @PostMapping("/usuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {

        usuarioRepository.save(usuario);
        return usuario;

    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();

    }

    @GetMapping("/usuario/{nombre}/{apellidos}")
    public List<Usuario> listarPorNombreApellidos(@PathVariable String nombre,@PathVariable String apellidos){
        return usuarioRepository.findAllByNombreAndApellidos(nombre, apellidos);
    }

    @GetMapping("/usuario/nombre/{nombre}")
    public List<Usuario> listarPorNombre(@PathVariable String nombre){
        return usuarioRepository.findAllByNombre(nombre);
    }

    @GetMapping("/usuario/apellidos/{apellidos}")
    public List<Usuario> listarPorApellidos(@PathVariable String apellidos){
        return usuarioRepository.findAllByApellidos(apellidos);
    }

    @PutMapping("/usuario/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioBD = usuarioRepository.findById(id).get();
        try{

            usuarioBD.setNombre(usuario.getNombre());
            usuarioBD.setApellidos(usuario.getApellidos());
            usuarioBD.setTelefono(usuario.getTelefono());
            usuarioBD.setDireccion(usuario.getDireccion());
            usuarioBD.setDocumento(usuario.getDocumento());
            usuarioBD.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioRepository.save(usuarioBD);
            return usuarioBD;

        }catch(Exception e){
            return null;
        }


    }

    @DeleteMapping("/usuario/{id}")
    public Usuario eliminarUsuario(@PathVariable Long id){
        Usuario usuarioBD = usuarioRepository.findById(id).get();
        try{
            usuarioRepository.delete(usuarioBD);
            return usuarioBD;

        }catch(Exception e){
            return null;
        }

    }

}
