/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaRemota;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author jennifer
 */
public class Agenda extends UnicastRemoteObject implements AgendaInterface {
    
    ArrayList<Compromisso> listaCompromissos;

    public Agenda() throws RemoteException {
        super();
        System.out.println("Objeto remoto instanciado");
        listaCompromissos = new ArrayList<>();
    }

    @Override
    public void adicionar(Compromisso comp) throws RemoteException {
         listaCompromissos.add(comp);
    }

    @Override
    public void alterar(int id, String data, String hora, String assunto, String descricao, String notificacao) throws RemoteException {
        Compromisso comp = procuraCompromisso(id);
        comp.setData(data);
        comp.setHora(hora);
        comp.setAssunto(assunto);
        comp.setDescricao(descricao);
        comp.setNotificacao(notificacao);
    }

    @Override
    public void remover(int id) throws RemoteException {
        listaCompromissos.remove(procuraCompromisso(id));
    }

    
    @Override
    public ArrayList<Compromisso> listarPorData(String data) throws RemoteException { 
        //Listar os compromissos de uma data específica
        return procuraCompromisso(data);
    }

    @Override
    public ArrayList<Compromisso> exibirTodos() throws RemoteException {
        //Exibir todos os compromissos da Agenda.
        return listaCompromissos;
    }

    private Compromisso procuraCompromisso(int id){
        for (Compromisso comp : listaCompromissos) {
            if(comp.getId() == id){
                return comp;
            }
        }
        return null;
    }
    
    private ArrayList<Compromisso> procuraCompromisso(String data){
        ArrayList<Compromisso> listComp = new ArrayList<>();
        for (Compromisso comp : listaCompromissos) {
            if(comp.getData().equals(data)){
                listComp.add(comp);
            }
        }
        return listComp;
    }
   
}
