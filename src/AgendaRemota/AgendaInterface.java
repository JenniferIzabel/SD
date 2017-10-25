/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author jennifer
 */
public interface AgendaInterface extends Remote{
    public void adicionar (Compromisso comp) throws RemoteException;
    public void alterar (int id, String data, String hora, String assunto, String descricao, String notificacao) throws RemoteException;
    public void remover (int id) throws RemoteException;
    public ArrayList<Compromisso> listarPorData (String data) throws RemoteException;
    public ArrayList<Compromisso> exibirTodos () throws RemoteException;
    
}
