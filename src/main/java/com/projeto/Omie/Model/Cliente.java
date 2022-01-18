package com.projeto.Omie.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cliente {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String inscricao;
    private String nome;
    private String apelido;
    private int status;
    private String urlImagem;

}
