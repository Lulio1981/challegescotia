package com.facotory.demo.service;

import com.facotory.demo.entity.Alumno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {

    Flux<Alumno> findByEstado(short estdado);

    Mono<Alumno> saveAlumno(Alumno alumno);
}
