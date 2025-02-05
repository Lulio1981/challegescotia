package com.facotory.demo.util.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

    private String code;
    private String message;
    private String detail;
    private Class context_class;
    private String context;

}
