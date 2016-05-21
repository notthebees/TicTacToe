package game;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestTicTacToe {

    @Test
    public void cannotPlayMoveThatHasAlreadyBeenPlayed() {
        TicTacToe game = new TicTacToe();

        game.playMove(1);
        game.playMove(2);

        MatcherAssert.assertThat(game.isNotValid(1), Matchers.equalTo(true));
        MatcherAssert.assertThat(game.isNotValid(2), Matchers.equalTo(true));
        MatcherAssert.assertThat(game.isNotValid(3), Matchers.equalTo(false));
    }

    @Test
    public void unfinishedGame() {
        TicTacToe game = new TicTacToe();

        game.playMove(1);
        game.playMove(5);
        game.playMove(2);
        game.playMove(3);
        game.playMove(7);
        game.playMove(4);
        game.playMove(6);
        game.playMove(9);

        MatcherAssert.assertThat(game.isOver(), Matchers.equalTo(false));

    }

    @Test
    public void player2Wins() {
        TicTacToe game = new TicTacToe();

        game.playMove(1);
        game.playMove(2);
        game.playMove(3);
        game.playMove(5);
        game.playMove(4);
        game.playMove(8);

        MatcherAssert.assertThat(game.isOver(), Matchers.equalTo(true));
        MatcherAssert.assertThat(game.result(), Matchers.equalTo(Result.P2_WIN));

    }

    @Test
    public void player1Wins() {
        TicTacToe game = new TicTacToe();

        game.playMove(1);
        game.playMove(2);
        game.playMove(3);
        game.playMove(4);
        game.playMove(5);
        game.playMove(6);
        game.playMove(7);

        MatcherAssert.assertThat(game.isOver(), Matchers.equalTo(true));
        MatcherAssert.assertThat(game.result(), Matchers.equalTo(Result.P1_WIN));

    }

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
