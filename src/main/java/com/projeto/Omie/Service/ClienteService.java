package com.projeto.Omie.Service;

import java.util.List;
import java.util.Optional;

import com.projeto.Omie.Dto.ClienteDtoOut;
import com.projeto.Omie.Model.Cliente;
import com.projeto.Omie.Model.Email;
import com.projeto.Omie.Repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmailService emailService;

    public ResponseEntity<Page<Cliente>> findAllClientes(int pag) {
        PageRequest pageRequest = PageRequest.of(pag, 5, Sort.Direction.ASC, "apelido");
        Page<Cliente> clientes = clienteRepository.findAll(pageRequest);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    public ResponseEntity<Cliente> save(Cliente cliente) {
        clienteRepository.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    public ResponseEntity<Cliente> update(long id, Cliente cliente) {
        if (clienteRepository.findById(id).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        cliente.setId(id);
        clienteRepository.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    public ResponseEntity<Cliente> delete(long id) {
        if (clienteRepository.findById(id).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        emailService.deleteAllByCliente(id);
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<ClienteDtoOut> detail(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Email> emails = emailService.findAllByCliente(id);
        ClienteDtoOut dtoOut = new ClienteDtoOut(cliente.get(), emails);
        return new ResponseEntity<>(dtoOut, HttpStatus.OK);
    }

}
