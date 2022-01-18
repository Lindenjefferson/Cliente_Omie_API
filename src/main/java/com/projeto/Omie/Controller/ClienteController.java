package com.projeto.Omie.Controller;

import com.projeto.Omie.Dto.ClienteDtoOut;
import com.projeto.Omie.Model.Cliente;
import com.projeto.Omie.Service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("list/page={pag}")
    public ResponseEntity<Page<Cliente>> findAllClientes(@PathVariable int pag) {
        return clienteService.findAllClientes(pag);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable long id) {
        return clienteService.delete(id);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<ClienteDtoOut> detail(@PathVariable long id) {
        return clienteService.detail(id);
    }

}
