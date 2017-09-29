/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista3_Ex2_VERIFICAR;

/**
 *
 * @author jennifer
 * 
 * TCPClient: Cliente para conexao TCP Descricao: Envia uma informacao ao
 * servidor e finaliza a conexao
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient extends Thread {

    public static void main(String args[]) {
        /* args[0]: mensagem  e args[1]: ip do servidor */

        String ipServidor = "127.0.1.1";

        Socket s = null;

        try {

            /* especifica a porta */
            int serverPort = 7896;
            /* conecta com o servidor */
            s = new Socket(ipServidor, serverPort);

            /* cria objetos de leitura e escrita */
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String sedMsg = "", recMsg = "";

            while (!sedMsg.equals("SAIR")) {

                sedMsg = sc.nextLine(); // le do teclado 
                out.writeUTF(sedMsg);  // envia a string para o servidor
                recMsg = in.readUTF(); // recebe uma mensagem do servidor
                System.out.println(recMsg); // imprime mensagem recebida
            }
            /* finaliza conexao */
            in.close();
            out.close();
            s.close();
            /* end */
            System.out.println("closed");

        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("leitura:" + e.getMessage());
        } //catch
    } //main
} //class
