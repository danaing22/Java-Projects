import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args){
        ArrayList<Player> playerList = Welcome.welcomeMessages(); // get player info and validation
        Player[] playerOrder = Welcome.decidePlayerOrder(playerList.get(0), playerList.get(1)); // player order
    }
}
