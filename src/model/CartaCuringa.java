package model;

import controller.Jogo;

public class CartaCuringa extends Carta{

    public CartaCuringa(Cor cor, Valor valor) {
        super(cor, valor);
    }

    @Override
    public void aplicarEfeito(Jogo mesa) {
        switch(this.valor) {
            case CORINGA -> { //TODO Cauê, essa parte é com vc. Qnd for fazer, o jogador vai escolher o curinga
                // TODO e vc vai ter q usar um scanner pra ele escolher a cor, e usar cartaEscolhida.setCor(Cor.COR)
                //em que COR é a cor que o usuario escolheu, pra mudar a cor do curinga de preto pra verde
            }
            case CORINGA_MAIS_QUATRO -> {
                mesa.avancarTurno();
                mesa.comprarCartas(4);
            }
        }
    }
}
