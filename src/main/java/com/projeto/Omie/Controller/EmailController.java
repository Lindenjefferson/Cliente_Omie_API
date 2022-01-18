package com.projeto.Omie.Controller;

import com.projeto.Omie.Dto.EmailDtoIn;
import com.projeto.Omie.Model.Email;
import com.projeto.Omie.Service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Email> save(@RequestBody EmailDtoIn emailDto) {
        return emailService.save(emailDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Email> delete(@PathVariable long id) {
        return emailService.delete(id);
    }

}
