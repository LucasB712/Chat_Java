package rede;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class ServidorChat extends Thread {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JTextArea area;
    private int porta;

    public ServidorChat(JTextArea area, int porta) {
        this.area = area;
        this.porta = porta;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(porta);
            area.append("Aguardando conexão na porta " + porta + "...\n");
            socket = serverSocket.accept();
            area.append("Cliente conectado!\n");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true); // out configurado aqui!

            // Thread separada para ouvir mensagens
            new Thread(() -> {
                String mensagem;
                try {
                    while ((mensagem = in.readLine()) != null) {
                        area.append("Cliente: " + mensagem + "\n");
                    }
                } catch (IOException e) {
                    area.append("Conexão encerrada.\n");
                }
            }).start();

        } catch (IOException e) {
            area.append("Erro no servidor: " + e.getMessage() + "\n");
        }
    }

    public void enviarMensagem(String mensagem) {
        if (out != null) {
            out.println(mensagem);
            area.append("Você: " + mensagem + "\n");
        } else {
            area.append("Nenhum cliente conectado ainda.\n");
        }
    }
}
