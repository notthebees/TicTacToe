package game;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestTicTacToe {

    @Test
    public void simpleTieGameWithoutInvalidMoves() {
        TicTacToe game = new TicTacToe();

        game.playMove(1);
        game.playMove(5);
        game.playMove(2);
        game.playMove(3);
        game.playMove(7);
        game.playMove(4);
        game.playMove(6);
        game.playMove(9);
        game.playMove(8);

        MatcherAssert.assertThat(game.isOver(), Matchers.equalTo(true));
        MatcherAssert.assertThat(game.result(), Matchers.equalTo(Result.TIE));

    }
}
