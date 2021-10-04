public class Player {
    private String playerName;
    private int movesMade; // keeps track of number of moves made in current game
    private String marker;

    public Player(String playerName) {
        this.playerName = playerName;
        movesMade = 0;
    }

    //getter for name
    public String getPlayerName(){
        return playerName;
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
