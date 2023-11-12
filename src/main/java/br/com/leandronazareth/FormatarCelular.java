package br.com.leandronazareth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatarCelular {

    public static String validarNumeroCelular(String pNumero) {
        // Expressão regular para encontrar apenas números
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(pNumero);

        // Substituindo todos os não dígitos por uma string vazia
        String numeros = matcher.replaceAll("");

        // Validar telefone
        if (validaNumero(numeros)) {
            return numeros;
        } else {
            return "Número inválido";
        }
    }

    private static boolean validaNumero(String pNumeroValidar) {
        // Verificar se vazio
        if (pNumeroValidar.length() == 0) {
            System.out.println("Nenhum número informado!");
            return false;
        }

        // Remover código do país (caso comece com "55")
        if (pNumeroValidar.startsWith("55")) {
            pNumeroValidar = pNumeroValidar.substring(2);
        }

        // Remover zeros no início
        pNumeroValidar = pNumeroValidar.replaceFirst("^0+", "");

        // Verificar se menos que 11 dígitos
        if (pNumeroValidar.length() != 11) {
            System.out.println("Número inválido ou sem DDD");
            return false;
        }

        // Verificar o 5º dígito
        char digitoControle = pNumeroValidar.charAt(4);

        if (digitoControle >= '2' && digitoControle <= '9') {
            System.out.println("Número móvel");
            return true;
        } else {
            System.out.println("Número inválido ou fixo");
            return false;
        }
    }
}
