package sockets2.serializacao;

/*
 * Cliente.java
 */

import java.net.*;
import java.io.*;

/**
 * 
 * @author rodrigo
 */
public class Cliente {
    
    public static void main (String args[]) {
        Pessoa a, b;
        Socket s;
        
        ObjectOutputStream objOut;
        
        try {
            System.out.println ("Criando instancias da classe Pessoa ...\n");
            a = new Pessoa ("Bicho Papao", "Imaginaria", "01/01/1300");
            b = new Pessoa ("Dracula", "Transilvania", "31/12/1500");
            
            System.out.println ("Conectando ao servidor ...\n");
            s = new Socket ("localhost",6666);
            
            System.out.println ("Criando objetos de leitura/escrita ...\n");
            objOut = new ObjectOutputStream (s.getOutputStream());
            
            System.out.println ("Enviando objetos serializados ...\n");
            objOut.writeObject(a);
            objOut.writeObject(b);
            objOut.flush();

            System.out.println ("Finalizado.");
            
        } catch (Exception e) {
            System.out.println(e);
        } //catch
    } //main
    
    
}
