package rede;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class ClienteChat extends Thread {
    private String host;
    private int porta;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JTextArea area;

    public ClienteChat(String host, int porta, JTextArea area) {
        this.host = host;
        this.porta = porta;
        this.area = area;
    }

    public void run() {
        try {
            socket = new Socket(host, porta);
            area.append("Conectado ao servidor!\n");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                area.append("Servidor: " + mensagem + "\n");
            }
        } catch (IOException e) {
            area.append("Erro ao conectar: " + e.getMessage() + "\n");
        }
    }

    public void enviarMensagem(String mensagem) {
        if (out != null) {
            out.println(mensagem);
            area.append("Você: " + mensagem + "\n");
        }
    }
}
