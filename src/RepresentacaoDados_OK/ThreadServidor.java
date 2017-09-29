/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepresentacaoDados_OK;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class ThreadServidor extends Thread {

    Servidor guiServidor;
    ObjectInputStream objIn;
    Socket clientSocket;
    ServerSocket serverSocket;

    public ThreadServidor(Servidor guis) {
        this.guiServidor = guis;
    }

    public void inicia() {
        try {
            serverSocket = new ServerSocket(6666);
            guiServidor.writeOnGUIServer("Mapeando porta ...");

            this.clientSocket = serverSocket.accept();
            guiServidor.writeOnGUIServer("Servidor aguardando conexoes ...");

            objIn = new ObjectInputStream(clientSocket.getInputStream());
            guiServidor.writeOnGUIServer("Criando objetos de leitura/escrita ...");

            guiServidor.writeOnGUIServer("Aguardando objetos serializados ...");

            this.start();
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fecha() {
        try {
            this.serverSocket.close();
            this.interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        Compromisso compromisso;
        while (true) {
            try {
                compromisso = (Compromisso) objIn.readObject();
                guiServidor.writeOnGUIServer(compromisso);

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
