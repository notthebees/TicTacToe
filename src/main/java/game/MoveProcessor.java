package game;

import java.util.Scanner;

public class MoveProcessor {
    private final Scanner scanner;

    public MoveProcessor() {
        scanner = new Scanner(System.in);
    }

    public int move(final TicTacToe game, final int round) {
        String player = (round % 2 == 0) ? "1" : "2";
        System.out.println("Player " + player + " move:");
        int move = scanner.nextInt();
        while (game.isNotValid(move)) {
            System.out.println("Not valid.");
            System.out.println("Player " + player + " move:");
            move = scanner.nextInt();
        }
        return move;
    }
}
