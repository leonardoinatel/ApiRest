package com.challenge.jpa.utils;

public class FakeRandomString implements RandomStringProvider {

  @Override
  public String gerarStringAleatoriaArrayNumeros(int tamanho) {
    return "1,2,3,4,5";
  }
  
}
