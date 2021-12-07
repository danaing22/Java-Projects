public class Player2 {
    private final String PLAYER_NAME;
    private int movesMade; // keeps track of number of moves made in current game
    private static final int MAX_PLAYER_MOVES = 5; //max number of moves a player can make per game
    private String marker; // this player's marker
    private boolean isComputer;

    public Player2(String playerName) {
        this.PLAYER_NAME = playerName;
        movesMade = 0;
        if(playerName.equals("Computer"))
            isComputer = true;
        else
            isComputer = false;
    }

    //getter for name
    public String getPLAYER_NAME(){
        return PLAYER_NAME;
    }

    //getter and setter for marker
    public String getPlayerMarker(){
        return marker;
    }
    public void setPlayerMarker(String marker){
        this.marker = marker;
    }

    //getter and setter for movesMade
    public int getMovesMade(){
        return movesMade;
    }
    public void incrementMovesMade(){
        movesMade++;
    }

    public boolean returnIsComputer(){return isComputer;}

    public int returnMaxMoves(){return MAX_PLAYER_MOVES;}
}
