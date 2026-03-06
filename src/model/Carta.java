package model;

public abstract class Carta {
    // Usamos 'protected' para que as classes filhas possam acessar essas variáveis
    protected Cor cor;
    protected Valor valor;

    // Construtor
    public Carta(Cor cor, Valor valor) {
        this.cor = cor;
        this.valor = valor;
    }

    // Getters para checar as regras do jogo depois
    public Cor getCor() {
        return cor;
    }

    public Valor getValor() {
        return valor;
    }

    // A MÁGICA DO POLIMORFISMO:
    // Cada carta filha vai ter que implementar sua própria versão desse métod0.
    // O jogo só vai chamar carta.aplicarEfeito() e a própria carta sabe o que fazer.
    public abstract void aplicarEfeito();

    public String toString() {
        return valor + " " + cor;
    }
}