package controller;

import model.Baralho;
import model.Carta;
import model.Cor;
import model.Jogador;

import java.util.ArrayList;
import java.util.List;

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

    public void avancarTurno(){

        int totalJogadores = this.jogadores.size();
        if(this.sentidoHorario){
            this.jogadorAtual = (jogadorAtual + 1)% totalJogadores;
        } else {
            this.jogadorAtual = (this.jogadorAtual - 1 + totalJogadores) % totalJogadores;
        }
    }

    public Jogador getJogadorDaVez(){
        return jogadores.get(jogadorAtual);
    }

    public boolean validarJogada(Carta c){
        Carta topoDaPilha = this.pilhaDescarte.get(pilhaDescarte.size()-1);
        return (topoDaPilha.getCor() == c.getCor() ||
                topoDaPilha.getValor() == c.getValor() ||
                    c.getCor() == Cor.PRETO);
    }

    public boolean realizarJogada(Carta c){
        if(validarJogada(c)){
            getJogadorDaVez().getMao().remove(c);
            pilhaDescarte.add(c);
            c.aplicarEfeito(this);
            avancarTurno();
            return true;
        } else return false;
    }

    public void inverterSentido(){
        sentidoHorario= sentidoHorario ^ true;
    }

    public void comprarCartas(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            verificarEReciclarBaralho();
            getJogadorDaVez().getMao().add(baralho.comprarCarta());
        }
    }

    public void jogadorCompraCarta(){
        verificarEReciclarBaralho();
        getJogadorDaVez().getMao().add(baralho.comprarCarta());
        avancarTurno();
    }

    private void verificarEReciclarBaralho(){
        if (!baralho.temCartas()){
            Carta topo = this.pilhaDescarte.getLast();
            this.pilhaDescarte.removeLast();
            baralho.reabastecer(this.pilhaDescarte);
            this.pilhaDescarte.clear();
            this.pilhaDescarte.add(topo);
            System.out.println("Baralho atualziado! Pilha de cartas esvaziada.");
        }
    }

    public Jogador verificaVencedor(){
        for (Jogador j : this.jogadores){
            if(j.getMao().isEmpty()) return j;
        }
        return null;
    }
}
