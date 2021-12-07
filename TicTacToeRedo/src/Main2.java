
public class Main2 {
    public static void main(String[] args){
        boolean playing = true;
        // call welcome messages- get player info and validate, return array of player objects
        Player[] playerList = Welcome.welcomeMessages(); // get player info and validation
        //todo need to instantiate a gameboard object to pass into printinstructions
//        Welcome.printInstructions();

        // figure out player order, return array with player1 and player2 with associated pieces set
        Player[] playerOrder = Welcome.decidePlayerOrder(playerList[0], playerList[1]); // player order

        // main game loop
        while(playing) {


            // after game is finished ask if user would like to play again
            System.out.println("Would you like to play another game?");
            playing = Validation.playingValidation();
            if(!playing)
                System.out.println("Thanks for playing, goodbye!");
        }
    }
}
