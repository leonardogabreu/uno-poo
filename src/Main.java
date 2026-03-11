import controller.Jogo;
import model.BaralhoUnoOficial;
import model.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO O MOTOR DO UNO ===");

        // 1. Criando os jogadores (O seu Front-end fará isso no futuro)
        Jogador j1 = new Jogador("Leonardo");
        Jogador j2 = new Jogador("Cauê");
        Jogador j3 = new Jogador("Visitante");

        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(j1);
        jogadores.add(j2);
        jogadores.add(j3);

        // 2. Criando o baralho escolhido e montando a mesa
        BaralhoUnoOficial baralho = new BaralhoUnoOficial();
        Jogo mesa = new Jogo(jogadores, baralho);

        // 3. O Juiz apita o início do jogo (Embaralha e distribui 7 cartas)
        System.out.println("Distribuindo cartas...");
        mesa.iniciarPartida();

        // 4. Verificando as mãos geradas
        System.out.println("\n--- STATUS INICIAL DAS MÃOS ---");
        for (Jogador j : jogadores) {
            System.out.println("Jogador: " + j.getNome() + " | Total de cartas: " + j.getMao().size());
            // Imprime a lista de cartas (vai usar aquele toString() que deixamos pronto na classe Carta)
            System.out.println("Cartas: " + j.getMao() + "\n");
        }

        // 5. Testando a Roda de Turnos e a Compra de Cartas
        System.out.println("--- TESTANDO MECÂNICA DE TURNOS ---");
        System.out.println("De quem é a vez? -> " + mesa.getJogadorDaVez().getNome());

        System.out.println(mesa.getJogadorDaVez().getNome() + " fingiu que não tem cartas e vai comprar...");
        mesa.jogadorCompraCarta();

        System.out.println("A vez passou? De quem é a vez agora? -> " + mesa.getJogadorDaVez().getNome());
        System.out.println("O Leonardo ficou com quantas cartas após comprar? -> " + j1.getMao().size());

        System.out.println("\n=== SUCESSO! O BACK-END ESTÁ 100% OPERACIONAL ===");
    }
}