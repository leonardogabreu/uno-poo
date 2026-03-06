package model;

public class CartaCuringa extends Carta{

    public CartaCuringa(Cor cor, Valor valor) {
        super(cor, valor);
    }

    @Override
    public void aplicarEfeito() {
        System.out.println("Efeito aplicado! (Em fase de desenvolvimento");
    }
}
