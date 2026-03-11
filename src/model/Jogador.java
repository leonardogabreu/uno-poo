package model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public List<Carta> getMao() { return mao; }

    // TODO Cauê, programar o resto depois (comprar, jogar, gritar UNO, etc.). Fiz só o basicão pra eu conseguir fzr minha parte
}