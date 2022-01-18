package com.projeto.Omie.Service;

import java.util.List;
import java.util.Optional;

import com.projeto.Omie.Dto.EmailDtoIn;
import com.projeto.Omie.Model.Cliente;
import com.projeto.Omie.Model.Email;
import com.projeto.Omie.Repository.ClienteRepository;
import com.projeto.Omie.Repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<Email> save(EmailDtoIn emailDto) {
        Optional<Cliente> cliente = clienteRepository.findById(emailDto.getIdCliente());
        Email email = new Email(emailDto, cliente.get());
        emailRepository.save(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

    public ResponseEntity<Email> delete(long id) {
        if (emailRepository.findById(id).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        emailRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public List<Email> findAllByCliente(long idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        return emailRepository.findAllByCliente(cliente);
    }

    public void deleteAllByCliente(long idCliente) {
        List<Email> emails = findAllByCliente(idCliente);
        emailRepository.deleteAll(emails);
    }

}
