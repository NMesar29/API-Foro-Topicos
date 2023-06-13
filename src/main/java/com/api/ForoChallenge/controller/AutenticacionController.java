package com.api.ForoChallenge.controller;

import com.api.ForoChallenge.domain.usuario.Usuario;
import com.api.ForoChallenge.domain.usuario.dto.AutenticacionUsuarioDTO;
import com.api.ForoChallenge.infra.security.JWTTokenDTO;
import com.api.ForoChallenge.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid AutenticacionUsuarioDTO autenticacionUsuarioDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticacionUsuarioDTO.login(),
                autenticacionUsuarioDTO.password());
        authenticationManager.authenticate(authToken);
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDTO(JWTtoken));

    }


}
