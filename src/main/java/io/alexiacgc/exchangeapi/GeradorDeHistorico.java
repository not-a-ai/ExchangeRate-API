package io.alexiacgc.exchangeapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeHistorico {
    private static final String ARQUIVO = "historico.json";

    public void salvaHistorico(HistoricoConversao novoRegistro) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<HistoricoConversao> historico = new ArrayList<>();

        File file = new File(ARQUIVO);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<HistoricoConversao>>(){}.getType();
                historico = gson.fromJson(reader, listType);
            } catch (Exception e) {
                System.out.println("Erro ao ler histórico existente: " + e.getMessage());
            }
        }

        historico.add(novoRegistro);

        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            writer.write(gson.toJson(historico));
        }
    }
    public void exibeHistorico() throws IOException {
        Gson gson = new Gson();
        File file = new File(ARQUIVO);

        if (file.exists()) {
            FileReader reader = new FileReader(file);
            Type tipoLista = new TypeToken<List<HistoricoConversao>>() {}.getType();
            List<HistoricoConversao> historico = gson.fromJson(reader, tipoLista);


            if (historico != null && !historico.isEmpty()) {
                System.out.println("\nHistórico de conversões:");
                for (HistoricoConversao registro : historico) {
                    System.out.println("Moeda de origem: " + registro.paisOrigem);
                    System.out.println("Moeda de destino: " + registro.paisDestino);
                    System.out.println("Valor convertido: " + registro.valorConvertido);
                    System.out.println("Data de conversão: " + registro.dataFormatada);
                    System.out.println("-------------------------------------------------");
                }
            } else {
                System.out.println("Nenhum histórico encontrado.");
            }
        } else {
            System.out.println("Arquivo de histórico não encontrado.");
        }
    }

}
