package com.api.ForoChallenge.domain.topico.dto;

import com.api.ForoChallenge.domain.topico.Topico;
import jakarta.validation.constraints.NotBlank;

public record TopicoListadoDTO(
        String titulo,
        String mensaje,
        String fecha_creacion,
        String estatus,
        String autor,
        String curso
) {

    public TopicoListadoDTO(Topico topico){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion().toString(), String.valueOf(topico.getEstatus_topico()), topico.getAutor(), topico.getCurso().toString());
    }



}
