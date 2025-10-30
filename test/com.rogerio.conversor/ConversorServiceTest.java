package com.rogerio.conversor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorServiceTest {

    @Test
    void testCalculoConversaoSimples() {
        ConversorService service = new ConversorService();
        double resultado = service.calcular(100, 5.0);
        assertEquals(500.0, resultado, 0.0001);
    }

    @Test
    void testCalculoComZero() {
        ConversorService service = new ConversorService();
        double resultado = service.calcular(0, 5.0);
        assertEquals(0.0, resultado, 0.0001);
    }

    @Test
    void testCalculoComValorNegativo() {
        ConversorService service = new ConversorService();
        double resultado = service.calcular(-50, 5.0);
        assertEquals(-250.0, resultado, 0.0001);
    }

    @Test
    void testCalculoComValorDecimal() {
        ConversorService service = new ConversorService();
        double resultado = service.calcular(12.34, 4.56);
        assertEquals(56.2704, resultado, 0.0001);
    }

    @Test
    void testCalculoComValorGrande() {
        ConversorService service = new ConversorService();
        double resultado = service.calcular(1_000_000, 5.20);
        assertEquals(5_200_000.0, resultado, 0.0001);
    }
}

