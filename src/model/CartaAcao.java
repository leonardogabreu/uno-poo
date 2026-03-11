package model;

import controller.Jogo;

public class CartaAcao extends Carta {

    public CartaAcao(Cor cor, Valor valor) {
        super(cor, valor);
    }

    @Override
    public void aplicarEfeito(Jogo mesa) {
        System.out.println("Efeito aplicado! (Em fase de desenvolvimento"); //TODO Arrumar os efeitos de cada carta
    }
}
