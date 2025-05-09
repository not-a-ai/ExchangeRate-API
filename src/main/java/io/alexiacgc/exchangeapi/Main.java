package io.alexiacgc.exchangeapi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;



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
        GeradorDeHistorico arquivo = new GeradorDeHistorico();
        while (continuos){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Realizar conversão");
            System.out.println("2. Ver histórico de conversões");
            System.out.println("3. Sair");
            int opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    try{
                        Moeda moeda = new Moeda();
                        System.out.println("Digite o códido de uma moeda de origem:");
                        String pais = leitura.next().toUpperCase();

                        moeda.buscaMoeda(pais);

                        System.out.println("Digite o código da moeda para qual quer converter:");
                        moeda.pais = leitura.next().toUpperCase();
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
                        moeda.valor = moeda.converterMoeda(valor, moeda.buscarTaxa(moeda.pais));
                        System.out.println("Seu valor convertido é " + moeda.pais + "$ " + String.format("%.2f", moeda.valor));
                        LocalDateTime data = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                        String dataFormatada = data.format(formatter);

                        HistoricoConversao registro = new HistoricoConversao(
                                pais, moeda.pais, valor, moeda.valor, dataFormatada
                        );

                        arquivo.salvaHistorico(registro);
                        break;

                    } catch (RuntimeException e) {
                        System.out.println("Erro: " + e.getMessage()); // Exibindo o erro detalhado
                        System.out.println("Finalizando a aplicação");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                case 2:
                    try {
                        arquivo.exibeHistorico();
                    } catch (IOException e) {
                        System.out.println("Erro ao ler o histórico.");
                    }
                    break;

                case 3:
                    System.out.println("Até a próxima :)");
                    continuos = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        leitura.close();




    }
}