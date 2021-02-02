package com.challenge.jpa.repository;

import java.util.Optional;

import com.challenge.jpa.entity.Aposta;
import com.challenge.jpa.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApostaRepository extends JpaRepository<Aposta,Integer> {
  public Optional<Aposta> findByApostaRandomAndUsuario(String apostaRandom, Usuario usuario);
}
