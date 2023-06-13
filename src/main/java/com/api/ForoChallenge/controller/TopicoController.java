package com.api.ForoChallenge.controller;

import com.api.ForoChallenge.domain.topico.dto.TopicoActualizarDTO;
import com.api.ForoChallenge.domain.topico.dto.TopicoListadoDTO;
import com.api.ForoChallenge.domain.topico.dto.TopicoRespuestaDTO;
import com.api.ForoChallenge.domain.topico.dto.TopicosDTO;
import com.api.ForoChallenge.domain.topico.*;
import com.api.ForoChallenge.domain.topico.TopicoRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<?> registrarNuevoTopico(@RequestHeader("Authorization")String authorizationHeader,@RequestBody TopicosDTO topicosDTO, UriComponentsBuilder uriComponentsBuilder){
        boolean registroExistente = topicoRepository.existsByTitulo(topicosDTO.titulo()) && topicoRepository.existsByMensaje(topicosDTO.mensaje());
        System.out.println("Registro existente:" + registroExistente);

        if(registroExistente){
            return ResponseEntity.badRequest().body("El registro ya ha sido enviado anteriormente.");
        }else{
            Topico topico = topicoRepository.save(new Topico(topicosDTO));
            TopicoRespuestaDTO topicoRespuesta = new TopicoRespuestaDTO(topico.getId(), topico.getTitulo(),
                    topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus_topico(),
                    topico.getAutor(), topico.getCurso());
            URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(url).body(topicoRespuesta);
        }
    }

   @GetMapping
    public List<TopicoListadoDTO> listarTopicos(){
        return topicoRepository.findAll().stream().map(TopicoListadoDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Optional<Topico> detallarTopico(@PathVariable Long id){
        return topicoRepository.findById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoRespuestaDTO> actualizarTopico(@PathVariable Long id, @RequestBody TopicoActualizarDTO topicoActualizarDTO){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarTopico(topicoActualizarDTO);
        System.out.println(topico);
        return ResponseEntity.ok(new TopicoRespuestaDTO(topico.getId(), topico.getTitulo(),
                topico.getMensaje(),topico.getFecha_creacion(), topico.getEstatus_topico(),
                topico.getAutor(), topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id){
        if(topicoRepository.existsById(id)){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().body("El tópico ha sido eliminado correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro con el ID: " + id);
        }

    }

}
