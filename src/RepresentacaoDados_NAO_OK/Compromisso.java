/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepresentacaoDados_NAO_OK;

import java.io.Serializable;

/**
 *
 * @author jennifer
 */
public class Compromisso implements Serializable {
    private final int idCliente;
    private final String compromisso;
    private final String data;
    private final String hora;

    public Compromisso(int idCliente, String compromisso, String data, String hora) {
        this.idCliente = idCliente;
        this.compromisso = compromisso;
        this.data = data;
        this.hora = hora;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getCompromisso() {
        return compromisso;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
    
    
    
}
