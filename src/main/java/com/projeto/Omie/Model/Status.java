package com.projeto.Omie.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    
    DESATIVADO(0),
    ATIVADO(1),
    SUSPENSO(2);

    private int valor;

}
