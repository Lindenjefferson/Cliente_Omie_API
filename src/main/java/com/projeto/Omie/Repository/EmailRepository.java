package com.projeto.Omie.Repository;

import java.util.List;

import com.projeto.Omie.Model.Cliente;
import com.projeto.Omie.Model.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findAllByCliente(Cliente cliente);

}
