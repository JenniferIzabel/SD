/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaRemota;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author jennifer
 */
public class Cliente {
    public static void main(String args[]) {
         try {
             System.out.println ("Cliente iniciado ...");

             if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
             } //if

            /* obtem a referencia para o objeto remoto */
             Registry registry = LocateRegistry.getRegistry("localhost");
	     Compromisso c = (Compromisso)registry.lookup("ServicoCalculadora");

	     
         } catch (Exception e) {
            System.out.println(e);
         } //catch

     } //main
}
