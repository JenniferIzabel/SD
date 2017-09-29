package sockets2.serializacao;

/*
 * Pessoa.java
 *
 */

import java.io.Serializable;
import java.util.Calendar;

/**
 * Armazena informacoes sobre pessoa
 * @author rodrigo
 */
public class Pessoa implements Serializable {
    
    private String nome;
    private String cidade;
    private String dataNasc;
    
    /** Construtor */
    public Pessoa(String n, String c, String d) {
        nome = n;
        cidade = c;
        dataNasc = d;
    } //construtor
    
    public String getNome () {
        return this.nome;
    } //getNome
    
    public String getCidade () {
        return this.cidade;
    } //getCidade
    
    public String getDataNasc () {
        return this.dataNasc;
    } //getDataNasc
    
} //class
