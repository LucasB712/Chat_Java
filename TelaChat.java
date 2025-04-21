package gui;

import rede.ClienteChat;
import rede.ServidorChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaChat extends JFrame {
    private JButton btnAguardar, btnConectar, btnEnviar;
    private JTextField campoMensagem, campoPorta;
    private JTextArea areaChat;

    private ServidorChat servidor;
    private ClienteChat cliente;

    public TelaChat() {
        setTitle("Chat Simples");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        btnAguardar = new JButton("Aguardar");
        btnConectar = new JButton("Conectar");
        btnEnviar = new JButton("Enviar");
        campoMensagem = new JTextField();
        campoPorta = new JTextField("5000"); // porta padrão
        areaChat = new JTextArea();
        areaChat.setEditable(false);

        JLabel labelPorta = new JLabel("Porta:");

        // Posicionamento
        labelPorta.setBounds(20, 20, 50, 30);
        campoPorta.setBounds(60, 20, 60, 30);
        btnAguardar.setBounds(140, 20, 100, 30);
        btnConectar.setBounds(250, 20, 100, 30);
        campoMensagem.setBounds(20, 70, 250, 30);
        btnEnviar.setBounds(280, 70, 80, 30);
        JScrollPane scrollPane = new JScrollPane(areaChat);
        scrollPane.setBounds(20, 120, 340, 160);

        add(labelPorta);
        add(campoPorta);
        add(btnAguardar);
        add(btnConectar);
        add(btnEnviar);
        add(campoMensagem);
        add(scrollPane);

        // Aguardar (servidor)
        btnAguardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int porta = Integer.parseInt(campoPorta.getText().trim());
                    servidor = new ServidorChat(areaChat, porta);
                    servidor.start();
                } catch (NumberFormatException ex) {
                    areaChat.append("Porta inválida.\n");
                }
            }
        });

        // Conectar (cliente)
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int porta = Integer.parseInt(campoPorta.getText().trim());
                    cliente = new ClienteChat("localhost", porta, areaChat);
                    cliente.start();
                } catch (NumberFormatException ex) {
                    areaChat.append("Porta inválida.\n");
                }
            }
        });

        // Enviar
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = campoMensagem.getText().trim();
                if (!msg.isEmpty()) {
                    if (cliente != null) {
                        cliente.enviarMensagem(msg);
                    } else if (servidor != null) {
                        servidor.enviarMensagem(msg);
                    }
                    campoMensagem.setText("");
                }
            }
        });

        setVisible(true);
    }
}
