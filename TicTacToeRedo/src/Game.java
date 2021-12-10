/*
    An object that represents the current state of the game, its board, and its players
 */
public class Game {
    private Board board; //access game board and # of spaces open
    private Player2 player1; //player with 'X' marker that moves first
    private Player2 player2; //player with 'O' marker that moves second
    private Player2 nextToMove; // next player to make a move- can access piece
    private Player2 lastToMove; // last player to make a move
    private boolean win; // if there is currently a win on the board
    private boolean computer; // if computer is playing

    /*
        Constructor
     */
    public Game(Player2[] playerList) {
        this.board = new Board();
        this.win = false;
        this.computer = false;
        this.nextToMove = null;
        this.lastToMove = null;
        verifyComputer(playerList[1]); //only second player in original playerList can be computer
    }

    /*
        Check if player is computer and set field
     */
    public void verifyComputer(Player2 player){
        if(player.getPLAYER_NAME().equals("Computer"))
            this.computer = true;
    }

    /*
        After order is decided, set player1 and player2 with associated markers
     */
    public void setPlayers(Player2[] playerList){
        this.player1 = playerList[0];
        this.player2 = playerList[1];
    }

    /*
        Return access to board instance
     */
    public Board accessBoard(){return board;}

    /*
        Set value of win variable
     */
    public void setWin(boolean win){this.win = win;}
}
