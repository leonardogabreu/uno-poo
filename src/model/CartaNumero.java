package model;

public class CartaNumero extends Carta{

    public CartaNumero(Cor cor, Valor valor) {
        super(cor, valor);
    }

    @Override
    public void aplicarEfeito() {
        System.out.println("Efeito aplicado! (Em fase de desenvolvimento");
    }
}
