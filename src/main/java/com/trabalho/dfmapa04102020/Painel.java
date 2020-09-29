package com.trabalho.dfmapa04102020;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel F
 */
public class Painel {

    private List<Senha> fila;

    private int cont = 0;
    

    public List<Senha> getFila() {
        if (this.fila == null) {
            this.fila = new ArrayList<>();
        }
        return this.fila;
    }

    public Senha adicionarSenhaNaFila(char tipo) {
        int numero = ++this.cont;
        Senha senha = new Senha(numero, tipo);
        this.getFila().add(senha);
        return senha;
    }

    public String atender(char tipo) {
        Senha senhaAtendida = null;
        if (getFila().size() < 1) {
            return null;
        }

        for (int i = 0; i < getFila().size(); i++) {
            if (getFila().get(i).getTipo() == tipo) {
                senhaAtendida = fila.get(i);
                getFila().remove(i);
                break;
            }
        }

        if (senhaAtendida == null) {            
            senhaAtendida = getFila().get(0);
            getFila().remove(0);
        }
        return senhaAtendida.getSenhaTxt();

    }

}
