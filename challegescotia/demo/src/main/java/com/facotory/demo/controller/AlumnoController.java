package com.facotory.demo.controller;

import com.facotory.demo.entity.Alumno;
import com.facotory.demo.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("alumno/maintenance")
@AllArgsConstructor
public class AlumnoController {

    private AlumnoService alumnoService;


    @GetMapping("/{estado}")
    public ResponseEntity<Flux<Alumno>> findByEstado(@PathVariable short estado) {

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(alumnoService.findByEstado(estado));
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno).then(Mono.just(ResponseEntity.ok().build()));
    }

}
