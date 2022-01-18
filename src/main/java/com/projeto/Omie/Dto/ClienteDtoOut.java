package com.projeto.Omie.Dto;

import java.util.List;

import com.projeto.Omie.Model.Cliente;
import com.projeto.Omie.Model.Email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDtoOut {
    
    private Cliente cliente;
    private List<Email> emails;

}
