package com.challenge.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.challenge.jpa.entity.Aposta;
import com.challenge.jpa.entity.Usuario;
import com.challenge.jpa.repository.ApostaRepository;
import com.challenge.jpa.repository.UsuarioRepository;
import com.challenge.jpa.utils.RandomStringProvider;


@AllArgsConstructor
@NoArgsConstructor
@Service("apostaService")
public class ApostaServiceImpl implements ApostaService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ApostaRepository apostaRepository;

	@Autowired
	private RandomStringProvider randomStringProvider;

	@Override
	public Aposta fazerApostaParaEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email).orElseGet(() -> {
			return Usuario.builder()
					.email(email)
					.build();
		});

		usuarioRepository.save(usuario);
		
		String apostaRandom = randomStringProvider.gerarStringAleatoriaArrayNumeros(5);
		
		while(apostaRepository.findByApostaRandomAndUsuario(apostaRandom, usuario).isPresent()){
			apostaRandom = randomStringProvider.gerarStringAleatoriaArrayNumeros(5);			
		}
		
		Aposta aposta = Aposta.builder().apostaRandom(apostaRandom).usuario(usuario).build();

		usuario.adicionarAposta(aposta);
		usuarioRepository.save(usuario);
		
		return aposta;
	}
}
