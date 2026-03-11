package controller;

import model.Baralho;
import model.Carta;
import model.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private List<Jogador> jogadores;
    private Baralho baralho;
    private List<Carta> pilhaDescarte;
    private int jogadorAtual;
    private boolean sentidoHorario;

    public Jogo(List<Jogador> jogadores, Baralho baralho) {
        this.jogadores = jogadores;
        this.baralho = baralho;
        this.pilhaDescarte = new ArrayList<>();
        this.jogadorAtual = 0; // O primeiro jogador da lista começa
        this.sentidoHorario = true;
    }

    public void iniciarPartida(){

        baralho.embaralhar();

        for (Jogador j : this.jogadores){
            for(int i=0; i<7; i++){
                j.getMao().add(baralho.comprarCarta());
            }
        }

        this.pilhaDescarte.add(baralho.comprarCarta());
    }
}
