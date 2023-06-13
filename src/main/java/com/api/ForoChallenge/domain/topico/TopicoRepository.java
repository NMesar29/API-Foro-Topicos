package com.api.ForoChallenge.domain.topico;

import com.api.ForoChallenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {

    boolean existsByTitulo(String titulo);
    boolean existsByMensaje(String mensaje);

}
