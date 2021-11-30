public class Player {
    private final String PLAYER_NAME;
    private int movesMade; // keeps track of number of moves made in current game
    private String marker; // this player's marker
    private boolean isComputer;

    public Player(String playerName) {
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
}
