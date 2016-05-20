package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TicTacToe {

    private final Set<Integer> noughts = new HashSet<Integer>();
    private final Set<Integer> crosses = new HashSet<Integer>();
    private boolean gameOver;

    public TicTacToe() {
        gameOver = false;
    }

    public static void main(String[] args) {
        final TicTacToe game = new TicTacToe();
        final MoveProcessor moveProcessor = new MoveProcessor();

        for (int round = 0; round < 9; round++) {
            int move = moveProcessor.move(game, round);
            game.playMove(move);
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

    public void playMove(final int move) {
        if (noughts.size() <= crosses.size()) {
            noughts.add(move);
        } else {
            crosses.add(move);
        }
    }

    public boolean isNotValid(final int move) {
        return noughts.contains(move) || crosses.contains(move);
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

}
