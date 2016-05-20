package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {

    private final Set<Integer> noughts = new HashSet<Integer>();
    private final Set<Integer> crosses = new HashSet<Integer>();
    private boolean gameOver;
    private final Scanner scanner;

    public TicTacToe() {
        gameOver = false;
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        final TicTacToe game = new TicTacToe();
        for (int i = 0; i < 9; i++) {
            game.playMove(i);
            game.display();
            game.checkStatus();
            if (game.isOver()) return;
        }
        System.out.println("Tie!");
    }

    public boolean isOver() {
        return gameOver;
    }

    public void checkStatus() {
        if (wins(noughts)) {
            gameOver = true;
            System.out.println("Player 1 wins!");
        } else if (wins(crosses)) {
            gameOver = true;
            System.out.println("Player 2 wins!");
        }
    }

    public void playMove(final int i) {
        String player = (i % 2 == 0) ? "1" : "2";
        System.out.println("Player " + player + " move:");
        int move = move();
        while (noughts.contains(move) || crosses.contains(move)) {
            System.out.println("Not valid. Player " + player + " move:");
            move = move();
        }
        if (i % 2 == 0) {
            noughts.add(move);
        } else {
            crosses.add(move);
        }
    }

    public void display() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int pos = i * 3 + j + 1;
                if (noughts.contains(pos)) {
                    builder.append('o');
                } else if (crosses.contains(pos)) {
                    builder.append('x');
                } else {
                    builder.append('.');
                }
            }
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }

    private boolean wins(final Set<Integer> moves) {
        return moves.containsAll(Arrays.asList(1, 2, 3))
                || moves.containsAll(Arrays.asList(4, 5, 6))
                || moves.containsAll(Arrays.asList(7, 8, 9))
                || moves.containsAll(Arrays.asList(1, 4, 7))
                || moves.containsAll(Arrays.asList(2, 5, 8))
                || moves.containsAll(Arrays.asList(3, 6, 9))
                || moves.containsAll(Arrays.asList(1, 5, 9))
                || moves.containsAll(Arrays.asList(3, 5, 7));
    }

    public int move() {
        return scanner.nextInt();
    }
}
