package com.rogerio.conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final ConversorService conversorService = new ConversorService();

    public void exibir() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            try {
                System.out.println("\n=== Conversor de Moedas ===");
                System.out.println("1 - USD -> BRL");
                System.out.println("2 - BRL -> USD");
                System.out.println("3 - USD -> EUR");
                System.out.println("4 - EUR -> USD");
                System.out.println("5 - USD -> ARS");
                System.out.println("6 - ARS -> USD");
                System.out.println("7 - USD -> CLP");
                System.out.println("8 - CLP -> USD");
                System.out.println("9 - USD -> COP");
                System.out.println("10 - COP -> USD");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();

                if (opcao != 0) {
                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();
                    conversorService.converter(opcao, valor);
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada inválida! Digite apenas números.");
                scanner.nextLine(); // limpa o buffer
            }

        } while (opcao != 0);

        System.out.println("✅ Programa encerrado.");
    }
}



