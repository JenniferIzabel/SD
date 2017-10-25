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
public class Servidor {
    public static void main(String args[]) {
       try {
             if (System.getSecurityManager() == null) {
                 System.setSecurityManager(new SecurityManager());
             }

             /* inicializa um objeto remoto */
             AgendaInterface agenda = new AgendaInterface();

             /* registra o objeto remoto no Binder */
             Registry registry = LocateRegistry.getRegistry("localhost");
	         registry.bind("ServicoAgenda", agenda);

	         /* aguardando invocacoes remotas */
	         System.out.println("Servidor pronto ...");
	     } catch (Exception e) {
	         System.out.println(e);
         } //catch
     } //main
}
