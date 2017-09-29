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
 * TCPServer: Servidor para conexao TCP com Threads Descricao: Recebe uma
 * conexao, cria uma thread, recebe uma mensagem e finaliza a conexao
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer {

    public static void main(String args[]) {

        try {
            int serverPort = 7896; // porta do servidor

            /* cria um socket e mapeia a porta para aguardar conexao */
            ServerSocket listenSocket = new ServerSocket(serverPort);

            while (true) {
                System.out.println("Servidor aguardando conexao ...");

                /* aguarda conexoes */
                Socket clientSocket = listenSocket.accept();

                System.out.println("Cliente conectado ... Criando thread ...");
                /* cria um thread para atender a conexao */
                TaskThread c = new TaskThread(clientSocket);
            } //while

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        } //catch
    } //main
} //class

/**
 * Classe TaskThread: Thread responsavel pela comunicacao Descricao: Rebebe um
 * socket, cria os objetos de leitura e escrita e aguarda msgs clientes
 */
class TaskThread extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public TaskThread(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
            /* inicializa a thread */
        } catch (IOException e) {
            System.out.println("TaskThread:" + e.getMessage());
        } //catch
    } //construtor

    /* metodo executado ao iniciar a thread - start() */
    @Override
    public void start() {
        try {
            
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
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
            clientSocket.close();
            /* end */
            System.out.println("closed");
            System.out.println("close");
        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("leitura: " + e.getMessage());
        } //catch
    } //run
} //class
