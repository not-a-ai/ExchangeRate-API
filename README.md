# ExchangeRate API
<p align="center">
<img loading="lazy" src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge" style="height:25px;"/>
<img loading="lazy" src="/src/images/exchangeapi.png" style="height:25px;"/>
</p>


Este projeto é um sistema que consome uma  **API**  que fornece a conversão de moedas, utilizando taxas de câmbio em tempo real. 
Ele foi projetado para ser executado no terminal e pode ser utilizado por desenvolvedores que precisam integrar informações de câmbio em seus aplicativos.
<p align="center">
<img loading="lazy" src="/src/images/Terminal.png" />
</p>


## Tecnologias Utilizadas

- **Java** (versão 21 )
- **API externa de taxas de câmbio** (ex: https://api.exchangerate-api.com/ )
- **Maven** (para gerenciamento de dependências)

## Funcionalidades

- Consultar a taxa de câmbio entre duas moedas.
- Converter um valor de uma moeda para outra, utilizando a taxa de câmbio em tempo real.
  
## Instalação

### Pré-requisitos

Antes de rodar o projeto, você precisa ter:

- **Java 21** instalado em sua máquina.
- **Maven** (ou o seu gerenciador de dependências preferido).
- Uma chave de API de uma plataforma de câmbio (caso esteja usando uma API externa, como **Exchangerate-API** ou outra).

### Passos para Instalação

1. **Clone o repositório**

   Se ainda não fez isso, clone o repositório para sua máquina local:

   ```bash
   git clone https://github.com/not-a-ai/ExchangeRate-API/)
   ```
2. **Navegue até a pasta do projeto**

3. **Configure as variáveis de ambiente**

   Crie um arquivo `.env` na raiz do projeto e insira sua chave da API de câmbio. Exemplo:

   ```env
   API_KEY=SuaChaveDeAPI
   ```

4. Compile o projeto

Compile o projeto com o Maven.

5. Execute o projeto

Para rodar a aplicação no terminal, execute o comando adequado para iniciar o programa. O terminal irá executar o programa, e você poderá interagir com ele através de entradas no console.


## Como Usar

### Consultar Taxa de Câmbio

No terminal, execute o programa com o comando para consultar a taxa de câmbio entre duas moedas. Exemplo:

- `USD` (moeda de origem).
- `EUR` (moeda de destino).

O programa irá mostrar a taxa de câmbio entre as duas moedas diretamente no terminal.

### Converter Moeda

Para converter um valor de uma moeda para outra, execute o programa passando o valor a ser convertido, a moeda de origem e a moeda de destino.

Isso irá converter 100 USD para EUR e exibir o resultado no terminal.


