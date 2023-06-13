package com.api.ForoChallenge.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioDTO(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
