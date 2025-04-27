package io.alexiacgc.exchangeapi;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String menu = """
                ----------------------------------------------------------
                      Bem vindos ao sistema de conversão de moedas!
                
                Segue alguns códigos que vai te ajudar a usar o sistema:
                """;
        String exemplosCodigos = """
                ARS - Peso argentino
                BOB - Boliviano boliviano
                BRL - Real brasileiro
                CLP - Peso chileno
                COP - Peso colombiano
                USD - Dólar americano
                """;
        System.out.println(menu);
        System.out.println(exemplosCodigos);
        Boolean continuos = true;
        Scanner leitura = new Scanner(System.in);
        while (continuos){
            try{
                System.out.println("Digite o códido de uma moeda de origem:");
                String pais = leitura.next().toUpperCase();

                Moeda moeda = new Moeda().buscaMoeda(pais);

                System.out.println("Digite o código da moeda para qual quer converter:");
                String paisFinal = leitura.next().toUpperCase();
                leitura.nextLine();
                System.out.println("Digite valor que gostaria de converter:");
                String valorString = leitura.nextLine();
                double valor = 0;
                boolean valorValido = false;

                while (!valorValido) {
                    try {
                        valor = Double.parseDouble(valorString.replace(",", "."));
                        valorValido = true;
                    } catch (Exception e) {
                        System.out.println("Erro: Digite um valor numérico válido.");
                        leitura.next();
                    }
                }
                var valorConvertido = moeda.converterMoeda(valor, moeda.buscarTaxa(paisFinal));
                System.out.println("Seu valor convertido é " + paisFinal + "$ " + String.format("%.2f", valorConvertido));
                System.out.println("Deseja continuar? (S/N)");
                String desejaContinuar = leitura.next();
                if(desejaContinuar.equalsIgnoreCase("N")) {
                    System.out.println("Até a próxima :)");
                    continuos = false;
                }

            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage()); // Exibindo o erro detalhado
                System.out.println("Finalizando a aplicação");
                break;
            }
        }



    }
}