package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TicTacToe {

    private final Set<Integer> noughts = new HashSet<Integer>();
    private final Set<Integer> crosses = new HashSet<Integer>();
    private final Display display;

    public TicTacToe() {
        display = new Display();
    }

    public static void main(String[] args) {
        final TicTacToe game = new TicTacToe();
        final MoveProcessor moveProcessor = new MoveProcessor();

        int round = 0;
        while (!game.isOver()) {
            int move = moveProcessor.move(game, round++);
            game.playMove(move);
            game.display();
        }
        System.out.println(game.result().message());
    }

    public Result result() {
        if (wins(noughts)) return Result.P1_WIN;
        else if (wins(crosses)) return Result.P2_WIN;
        else return Result.TIE;
    }

    public boolean isOver() {
        return (wins(noughts) || wins(crosses) || noughts.size() > 4);
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
        display.display(noughts, crosses);
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
