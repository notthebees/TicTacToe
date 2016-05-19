package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {

    private final Set<Integer> noughts = new HashSet<Integer>();
    private final Set<Integer> crosses = new HashSet<Integer>();
    private final Scanner scanner;

    public TicTacToe() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Player 1 move:");
                int move = move();
                while (noughts.contains(move) || crosses.contains(move)) {
                    System.out.println("Not valid. Player 1 move:");
                    move = move();
                }
                noughts.add(move);
            } else {
                System.out.println("Player 2 move:");
                int move = move();
                while (noughts.contains(move) || crosses.contains(move)) {
                    System.out.println("Not valid. Player 2 move:");
                    move = move();
                }
                crosses.add(move);
            }

            if (wins(noughts)) {
                System.out.println("Player 1 wins!");
                return;
            } else if (wins(crosses)) {
                System.out.println("Player 2 wins!");
                return;
            }
        }
        System.out.println("Tie!");
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

    private int move() {
        return scanner.nextInt();
    }
}
