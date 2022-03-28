package com.example.apitestrxjava.models.dtos;

import com.example.apitestrxjava.models.enums.TypeMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private Integer status;
    private String text;
    private TypeMessage type;
}
