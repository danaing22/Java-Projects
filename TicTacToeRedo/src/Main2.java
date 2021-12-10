
public class Main2 {
    public static void main(String[] args){
        boolean playing = true;
        boolean win = false;
        // call welcome messages- get player info and validate, return array of player objects
        Player2[] playerList = Welcome.welcomeMessages(); // get player info and validation

        //if playerList is returned that means player agreed to play a game- create new game instance
        Game game = new Game(playerList); //creates a new board instance so game instructions can be printed

        PrintItems.printInstructions(game); // should print instructions with an empty board

        // figure out player order, return array with player1 and player2 with associated pieces set
        Player2[] playerOrder = Welcome.decidePlayerOrder(playerList[0], playerList[1]); // player order
        game.setPlayers(playerOrder); // set order of players for the game

        // active play session
        while(playing) {
            // active game
            while(!win) {
                win = PlayingGame.playTurn(playerOrder[0], game); // player1 makes their move
                // todo may need to remove previous implementation elsewhere for this
                if(win)
                    PrintItems.printWin(playerOrder[0]);
                // check if game was not won by either player- player 1 will get opportunity to make 5 moves
                if (!win && (playerOrder[0].getMovesMade() == PlayingGame.MAX_PLAYER_MOVES)) {
                    System.out.println("Neither player has secured the win, game over!");
                    win = true; // not actually a win but will exit loop
                }
                // if player1 doesn't win on their turn, player2 goes
                else if (!win){
                    win = PlayingGame.playTurn(playerOrder[1], game);
                    if(win) // todo same as above todo
                        PrintItems.printWin(playerOrder[1]);
                }
            }
            // after game is finished ask if user would like to play again
            System.out.println("Would you like to play another game?");
            playing = Validation.playingValidation();
            // todo if yes, should we add in a feature to decide player order again? just swap?
            if(!playing)
                System.out.println("Thanks for playing, goodbye!");
        }
    }
}
