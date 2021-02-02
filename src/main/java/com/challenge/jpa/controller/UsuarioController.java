package com.challenge.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.jpa.dto.ApostaResponse;
import com.challenge.jpa.entity.Usuario;
import com.challenge.jpa.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/buscarUsuarios")
    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/getInfo/{email}")
    public List<ApostaResponse> buscar(@PathVariable("email") String email) {
        return usuarioRepository.getJoinInformation(email);
    }    
}
