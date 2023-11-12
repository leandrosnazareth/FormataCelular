package br.com.leandronazareth;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            System.out.println("Hello world!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o número de celular: ");
            String numero = scanner.nextLine();
            System.out.println(new FormatarCelular().validarNumeroCelular(numero));
        }
    }