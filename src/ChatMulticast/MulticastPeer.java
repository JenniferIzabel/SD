package ChatMulticast;

/**
 * MulticastPeer: Implementa um peer multicast Descricao: Envia uma mensagem
 * para todos os membros do grupo. Apos tres msgs, finaliza.
 */
import java.net.*;
import java.io.*;

public class MulticastPeer {

    private InetAddress group;
    private int port;
    private MulticastSocket multicastSocket;
    private byte[] m;

    public MulticastPeer() {

    }

    public MulticastPeer(InetAddress group, MulticastSocket s) {
        this.group = group;
        this.multicastSocket = s;
    }

    public MulticastPeer(String sgroup, int port) {
        try {
            this.port = port;
            this.group = InetAddress.getByName(sgroup);
            this.multicastSocket = new MulticastSocket(this.port);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
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

    public void receivedMessage(byte[] buffer) {
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

    public void closeSocket() {
        if (multicastSocket != null) {
            multicastSocket.close(); //fecha o socket
        }
    }
    
    /* getters and setters */

    public InetAddress getGroup() {
        return group;
    }

    public int getPort() {
        return port;
    }

    public MulticastSocket getMulticastSocket() {
        return multicastSocket;
    }
    

}//class
