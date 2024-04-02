package com.facotory.demo.service.impl;

import com.facotory.demo.entity.Alumno;
import com.facotory.demo.repository.AlumnoRepository;
import com.facotory.demo.service.AlumnoService;
import com.facotory.demo.util.handler.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private AlumnoRepository alumnoRepository;

    /**
     * @param estdado
     * @return lista de alumnos
     */
    @Override
    public Flux<Alumno> findByEstado(short estdado) {
        return alumnoRepository.findByEstado(estdado)
                .doOnError(alm -> Flux.error(new BadRequestException(
                        "ERROR",
                        "Ha ocurrido un error al consultar los alumnos",
                        alm.getMessage(),
                        getClass(),
                        "findByEstado.onErrorResume"
                ))).cast(Alumno.class);
    }

    /**
     * @param alumno
     * @return el alumno guardado.
     */
    @Override
    public Mono<Alumno> saveAlumno(Alumno alumno) {
        return alumnoRepository.findById(alumno.getId())
                .map(alm -> {
                    throw new BadRequestException(
                            "ERROR",
                            "El alumno ya se encuentra registrado",
                            "",
                            getClass(),
                            "findByEstado.onErrorResume"
                    );
                })
                .switchIfEmpty(alumnoRepository.save(alumno))
                .doOnError(alm -> Flux.error(new BadRequestException(
                        "ERROR",
                        "Ha ocurrido un error al guardar el alumno",
                        alm.getMessage(),
                        getClass(),
                        "saveAlumno.onErrorResume"
                ))).cast(Alumno.class);
    }
}
