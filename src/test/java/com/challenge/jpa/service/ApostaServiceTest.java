package com.challenge.jpa.service;

import java.util.Optional;

import com.challenge.jpa.entity.Usuario;
import com.challenge.jpa.repository.ApostaRepository;
import com.challenge.jpa.repository.UsuarioRepository;
import com.challenge.jpa.utils.FakeRandomString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.util.Assert;

@TestInstance(Lifecycle.PER_CLASS)
public class ApostaServiceTest {
	private UsuarioRepository usuarioRepository;
  private ApostaRepository apostaRepository;
  private ApostaService apostaService;
  
  @BeforeAll
  public void setup(){
    usuarioRepository = Mockito.mock(UsuarioRepository.class);
    apostaRepository = Mockito.mock(ApostaRepository.class);
    
    apostaService = new ApostaServiceImpl(usuarioRepository, apostaRepository, new FakeRandomString());
  }

  @Test
  public void TesteInsercao() {
    String emailTest = "teste@teste.com";
    Usuario usuario = Usuario.builder().email(emailTest).id(1).build();

    Mockito.when(usuarioRepository.findByEmail(emailTest))
      .thenReturn(Optional.of(usuario));    
    
    Mockito.when(apostaRepository.findByApostaRandomAndUsuario("1,2,3,4,5", usuario))
      .thenReturn(Optional.empty());
    
    Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);

    apostaService.fazerApostaParaEmail(emailTest);

    Assert.notNull(usuario.getApostas(), "Usuario sem apostas");
    Assertions.assertEquals("1,2,3,4,5", usuario.getApostas().get(0).getApostaRandom());
  }

}
