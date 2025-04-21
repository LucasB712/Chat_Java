## 🗨️ Chat Simples em Java (Swing + Sockets)

Este é um projeto de chat ponto-a-ponto (peer-to-peer) feito em Java, utilizando Sockets TCP/IP e interface gráfica com Swing. Dois usuários podem conversar entre si: um atua como servidor e o outro como cliente, ambos podendo enviar e receber mensagens.

## 🚀 Funcionalidades

Interface gráfica com Swing

Comunicação bidirecional via Sockets

Campo para definir a porta de conexão

Envio e recebimento de mensagens em tempo real

Permite que tanto servidor quanto cliente enviem mensagens

## 🖥️ Interface

Campo para digitar a porta

Botões:

Aguardar: inicia como servidor

Conectar: conecta como cliente

Enviar: envia a mensagem escrita

Área de chat para exibir as mensagens trocadas

## 📁 Estrutura de Arquivos

```
css
Copiar
Editar
ChatSimples/
├── Main.java
├── gui/
│   └── TelaChat.java
├── rede/
│   ├── ServidorChat.java
│   └── ClienteChat.java
└── README.md

```

## ✅ Como compilar e executar

Abra o terminal e navegue até a pasta do projeto:

```
bash
Copiar
Editar
cd ChatSimples
```

Compile todos os arquivos:

```
bash
Copiar
Editar
javac Main.java gui/TelaChat.java rede/ServidorChat.java rede/ClienteChat.java
```

Execute o programa:

```
bash
Copiar
Editar
java Main
```

## 🧪 Como usar


Passo 1: Abrir duas janelas do programa

Execute java Main em dois terminais diferentes (ou duas vezes, se estiver em uma IDE).

Passo 2: Conectar

Em uma janela, digite a porta desejada (ex: 5050) e clique em Aguardar.

Na outra janela, digite a mesma porta e clique em Conectar.


Passo 3: Conversar

Agora ambos os lados podem digitar mensagens e clicar em Enviar.

## 🧼 Problemas comuns

⚠️ Erro: Address already in use: bind

A porta está ocupada por outra instância. Tente:

Fechar outras janelas que estão usando essa porta.

Usar outra porta (como 5051, 6000 etc).

Verificar com netstat ou lsof se a porta está em uso.

## 💡 Melhorias futuras
Adição de nomes de usuário

Suporte a múltiplos clientes conectados

Histórico de mensagens com timestamp

Conexão via IP configurável (para uso em rede local)

🧑‍💻 Autor
Feito por [LucasB712] – projeto de estudo com Java Sockets e Swing.
