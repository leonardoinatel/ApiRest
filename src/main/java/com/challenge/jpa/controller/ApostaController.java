package com.challenge.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.jpa.dto.ApostaRequest;
import com.challenge.jpa.dto.ApostaResponse;
import com.challenge.jpa.entity.Aposta;
import com.challenge.jpa.service.ApostaService;

@RestController
public class ApostaController {
	@Autowired
	private ApostaService apostaService;	
	
	@PostMapping("/apostar")
	public ApostaResponse apostar(@RequestBody ApostaRequest request) {
		Aposta aposta = apostaService.fazerApostaParaEmail(request.getEmail());
		return ApostaResponse.builder()
				.apostaRandom(aposta.getApostaRandom())
				.email(aposta.getUsuario().getEmail())
				.build();
	}
}
