package com.api.ForoChallenge.domain.topico;

import com.api.ForoChallenge.domain.topico.dto.TopicoActualizarDTO;
import com.api.ForoChallenge.domain.topico.dto.TopicosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="tbtopicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fecha_creacion = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private EstatusTopico estatus_topico = EstatusTopico.SIN_RESOLVER;
    private String autor;
    @Enumerated(EnumType.STRING)
    private CursoTopico curso;

    public Topico(TopicosDTO topicosDTO) {
        this.titulo = topicosDTO.titulo();
        this.mensaje = topicosDTO.mensaje();
        this.autor = topicosDTO.autor();
        this.curso = topicosDTO.curso();
    }

    public void actualizarTopico(TopicoActualizarDTO topicoActualizarDTO) {
        this.titulo = topicoActualizarDTO.titulo();
        this.mensaje = topicoActualizarDTO.mensaje();
        this.autor = topicoActualizarDTO.autor();
        this.curso = topicoActualizarDTO.curso();
    }
}
