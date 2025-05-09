package io.alexiacgc.exchangeapi;

public class HistoricoConversao {
    public String paisOrigem;
    public String paisDestino;
    public double valorOriginal;
    public double valorConvertido;
    public String dataFormatada;

    public HistoricoConversao(String paisOrigem, String paisDestino, double valorOriginal, double valorConvertido, String dataFormatada) {
        this.paisOrigem = paisOrigem;
        this.paisDestino = paisDestino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.dataFormatada = dataFormatada;
    }
}
