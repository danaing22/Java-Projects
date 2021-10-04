import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args){
        boolean playing; // playing the game or not
        boolean computer; // playing against computer or not
        Player player1;
        Player player2;

        System.out.println("Welcome! Would you like to play a game of TicTacToe?");
        playing = Validation.playingValidation(); // start game and validate user input
        if(!playing)
            System.out.println("Goodbye!");
        else {
            System.out.println("What is your name Player 1?");
            player1 = new Player(Validation.nameValidation()); // create player object for player1
            computer = Validation.friendOrComputer(); // t/f if playing against computer

            // if playing a friend, get name and create player instance
            if(!computer) {
                System.out.println("What is your name Player 2?");
                player2 = new Player(Validation.nameValidation());
            } else
                // otherwise, create player instance for computer with default name
                player2 = new Player("Computer");

            // main game loop
            while(playing) {
                //TODO move this statement inside a different method
                Player[] order = decideOrder(player1, player2); // decide which player goes first
                CurrentGame.startGame(order[0], order[1]); // game loop

                // after game is finished ask if user would like to play again
                System.out.println("Would you like to play another game?");
                playing = Validation.playingValidation();
                if(!playing)
                    System.out.println("Thanks for playing, goodbye!");
            }
        }
    }

    private static Player[] decideOrder(Player player1, Player player2){
        Player[] order = new Player[2];
        //generate 1 or 2 randomly to decide which player goes first
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
        if(randomNum == 1) {
            order[0] = player1;
            player1.setPlayerMarker("X");
            order[1] = player2;
            player2.setPlayerMarker("O");
            System.out.println("Order has been randomly generated and " +
                    player1.getPlayerName() + " goes first.");
        } else {
            order[0] = player2;
            player2.setPlayerMarker("X");
            order[1] = player1;
            player1.setPlayerMarker("O");
            System.out.println("Order has been randomly generated and " +
                    player2.getPlayerName() + " goes first.");
        }
        return order;
    }
}
