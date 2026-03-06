package model;

public class CartaAcao extends Carta {

    public CartaAcao(Cor cor, Valor valor) {
        super(cor, valor);
    }

    @Override
    public void aplicarEfeito() {
        System.out.println("Efeito aplicado! (Em fase de desenvolvimento");
    }
}
