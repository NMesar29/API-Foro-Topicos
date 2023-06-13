package com.api.ForoChallenge.domain.topico.dto;

import com.api.ForoChallenge.domain.topico.CursoTopico;
import com.api.ForoChallenge.domain.topico.EstatusTopico;

import java.time.LocalDate;

public record TopicoRespuestaDTO(Long id, String titulo, String mensaje, LocalDate fechaCreacion,
                                 EstatusTopico estatusTopico, String autor, CursoTopico curso) {
}
