/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatMulticast_OK;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class ListenerThread extends Thread {

    private InetAddress group;
    private int port;
    private MulticastSocket multicastSocket;
    private byte[] m;

    private final ChatMulticastGUI chatGUI;

    public ListenerThread(ChatMulticastGUI chatGUI) {
        this.chatGUI = chatGUI;
    }

    /* cria um grupo multicast */
    public void joinGroup(String sgroup, int port) {
        try {
            this.port = port;
            /* cria um grupo multicast */
            this.group = InetAddress.getByName(sgroup);
            /* cria um socket multicast */
            this.multicastSocket = new MulticastSocket(this.port);
            /* adiciona o host ao grupo */
            this.multicastSocket.joinGroup(group);
            /* inicia a thread */
            this.start();
            
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public void leaveGroup() {
        try {
            /* retira-se do grupo */
            multicastSocket.leaveGroup(group);
            if (multicastSocket != null) {
                multicastSocket.close(); //fecha o socket
            }
            this.interrupt();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public void sendMessage(byte[] message) {
        try {
            /* envia o datagrama como multicast */
            this.m = message;
            DatagramPacket messageOut = new DatagramPacket(this.m, this.m.length, this.group, this.port);
            multicastSocket.send(messageOut);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    private void receivedMessage(byte[] buffer) {
        try {
            /* aguarda o recebimento de msgs de outros peers */
            for (int i = 0; i < 3; i++) {
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(messageIn);
                System.out.println("Recebido:" + new String(messageIn.getData()));
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        byte[] buffer;
        while (true) {
            try {
                buffer = new byte[1000];
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(messageIn);

                chatGUI.receberMsg(new String(messageIn.getData()));

            } catch (SocketException e) {
                System.out.println("Socket: " + e.getMessage());
            } catch (IOException ex) {
                System.out.println("IO: " + ex.getMessage());
            }
        }

    }

}
