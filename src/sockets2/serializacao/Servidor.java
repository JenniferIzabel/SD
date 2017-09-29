package sockets2.serializacao;

import java.net.*;
import java.io.*;

/**
 * Servidor TCP que recebe dois objetos serializados
 * @author rodrigo
 */
public class Servidor {
    
    public static void main (String args[]) {
        Pessoa p1, p2;
        ServerSocket serverSocket;
        Socket clientSocket;
        
        ObjectInputStream objIn;
        
        try {
            System.out.println ("Mapeando porta ...");
            serverSocket = new ServerSocket (6666);
            
            System.out.println ("Servidor aguardando conexoes ...");
            clientSocket = serverSocket.accept();
            
            System.out.println ("Criando objetos de leitura/escrita ...");
            objIn = new ObjectInputStream (clientSocket.getInputStream());
            
            System.out.println ("Aguardando objetos serializados ...");
            p1 = (Pessoa) objIn.readObject();
            p2 = (Pessoa) objIn.readObject();
            
            System.out.println ("\nObjetos Recebidos\n");
            System.out.println ("\nPessoa 1: " +
                    "\n nome: " + p1.getNome() + 
                    "\n cidade: " + p1.getCidade() + 
                    "\n data nasc.: " + p1.getDataNasc());
            
            System.out.println ("\nPessoa 2: " +
                    "\n nome: " + p2.getNome() + 
                    "\n cidade: " + p2.getCidade() + 
                    "\n data nasc.: " + p2.getDataNasc());
            
            System.out.println("\nSistema finalizado!");
            
        } catch (Exception e) {
            System.out.println(e);
        } //catch
    } //main
    
    
}
