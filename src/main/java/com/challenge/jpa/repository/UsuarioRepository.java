package com.challenge.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.jpa.dto.ApostaResponse;
import com.challenge.jpa.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("SELECT new com.challenge.jpa.dto.ApostaResponse(u.email , ap.apostaRandom) FROM Usuario u JOIN u.apostas ap WHERE u.email =?1")
	public List<ApostaResponse> getJoinInformation(String email);

	public Optional<Usuario> findByEmail(String email);
}
