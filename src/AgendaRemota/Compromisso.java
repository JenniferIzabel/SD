/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaRemota;

/**
 *
 * @author jennifer
 */
public class Compromisso {
    private int id;
    private String data;
    private String hora;
    private String assunto;
    private String descricao;
    private String notificacao;

    public Compromisso() {
    }
    
    public Compromisso(int id, String data, String hora, String assunto, String descricao, String notificacao) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.assunto = assunto;
        this.descricao = descricao;
        this.notificacao = notificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }
    
    
    
}
