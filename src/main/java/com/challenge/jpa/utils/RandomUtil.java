package com.challenge.jpa.utils;

import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component("randomStringProvider")
public class RandomUtil implements RandomStringProvider {
    public String gerarStringAleatoriaArrayNumeros(int tamanho) {
        Random rnd = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(rnd.nextFloat()*50);
        }
        String strArray[] = Arrays.stream(arr)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new);
        
        String str = String.join(",", strArray);

        return str;
    }
}
