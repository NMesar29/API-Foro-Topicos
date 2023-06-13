package com.api.ForoChallenge.controller;

import com.api.ForoChallenge.domain.usuario.Usuario;
import com.api.ForoChallenge.domain.usuario.UsuarioRepository;
import com.api.ForoChallenge.domain.usuario.dto.CrearUsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crear-usuario")
public class CrearUsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody @Valid CrearUsuarioDTO crearUsuarioDTO){
        if(usuarioRepository.existsByLogin(crearUsuarioDTO.login())){
            return ResponseEntity.badRequest().body("El usuario ingresado ya existe");
        }else{
            usuarioRepository.save(new Usuario(crearUsuarioDTO));
            return ResponseEntity.ok("Se ha creado la cuenta correctamente");
        }

    }

}
