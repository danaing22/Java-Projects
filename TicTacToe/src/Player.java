public class Player {
    private final String PLAYER_NAME;
    private int movesMade; // keeps track of number of moves made in current game
    private String marker;

    public Player(String playerName) {
        this.PLAYER_NAME = playerName;
        movesMade = 0;
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
}
