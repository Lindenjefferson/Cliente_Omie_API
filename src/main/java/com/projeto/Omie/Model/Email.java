package com.projeto.Omie.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.projeto.Omie.Dto.EmailDtoIn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Email {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String categoria;
    private String nome;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Email(EmailDtoIn dto, Cliente cliente) {
        this.categoria = dto.getCategoria();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.cliente = cliente;
    }

}
