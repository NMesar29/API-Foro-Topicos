package com.api.ForoChallenge.domain.topico.dto;

import com.api.ForoChallenge.domain.topico.CursoTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoActualizarDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotNull
        CursoTopico curso
) {

}
