public class Game {
    Board board; //access game board and # of spaces open
    Player nextToMove; // next player to make a move- can access piece
    Player lastToMove; // last player to make a move
    boolean win; // if there is currently a win on the board
    boolean computer; // if computer is playing

    public Game() {
        this.board = new Board();
        this.win = false;
        this.computer = false;
    }
}
