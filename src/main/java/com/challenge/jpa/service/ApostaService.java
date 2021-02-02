package com.challenge.jpa.service;

import com.challenge.jpa.entity.Aposta;

public interface ApostaService {
	Aposta fazerApostaParaEmail(String email);
}
