package model;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Baralho {
    protected ArrayList<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
        montarBaralho();
    }

    public abstract void montarBaralho();
    public void embaralhar(){
        Collections.shuffle(this.cartas);
    }

    public Carta comprarCarta(){
        Carta c = cartas.get(0);
        cartas.remove(0);
        return c;
    }

    public boolean temCartas(){
        return !cartas.isEmpty();
    }

}
