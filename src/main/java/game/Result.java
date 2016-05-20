package game;

public enum Result {

    P1_WIN("Player 1 wins!"), P2_WIN("Player 2 wins!"), TIE("Tie!");

    private final String message;

    Result(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
