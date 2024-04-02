package com.facotory.demo.repository;

import com.facotory.demo.entity.Alumno;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AlumnoRepository extends R2dbcRepository<Alumno,Long> {

    Flux<Alumno> findByEstado (short estado);

}
