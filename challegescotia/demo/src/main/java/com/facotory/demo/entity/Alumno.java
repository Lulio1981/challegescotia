package com.facotory.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class Alumno {

    @Id
    private Long id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private short estado;

}
