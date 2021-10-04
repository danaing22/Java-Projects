public class AILogic {
    //starts with current state of the board and decides next move using minimax algorithm
    // returns int array[row, column] which is location to place piece
    //DOES NOT MODIFY BOARD
    private static int[] decideMove(GameBoard board){
        int[] move = new int[2];
        //todo make a deep copy of board?

        //check how many moves have been made- if the first one then find a random spot
        if(board.getSpacesOpen() == 9){

        }else { // otherwise if not first move implement minimax algorithm
            int depth = 0; // depth for algo starts at 0 //TODO possibly make these final static class vars?
            //TODO or possibly if implmenting multiple difficulties the cutoff value can be initialized upon
            //TODO starting game with whatever value needed
            int cutoff = 3; // depth tree cutoff is 3 moves
            //first call to minimax in recursive maxValue method
            MiniMaxObj item = maxValue(board, depth, cutoff);
            move = item.getMove();
        }
        return move;
    }
    // implement minimax algorithm. returns list with: heuristic value, new board state, new move location
    //TODO possibly also take a player object so we know which piece to track?
    private static MiniMaxObj maxValue(GameBoard board, int depth, int cutoff){
        MiniMaxObj obj = new MiniMaxObj(board);
        // check if depth cutoff has been met, if yes return the heuristic for the state
        if(depth >= cutoff){
            int heuristic = heuristicValue(board);
            obj.setHeuristic(heuristic);
            obj.setMove(new int[]{10, 10}); //arbitrary move value TODO circle back to why i need this
            return obj;
        }
        //todo verify which player (marker) is currently being tracked

        //check if game has been won?

        depth++; // increment depth for some reason


        return obj;
    }


    private static int heuristicValue(GameBoard board){

        return 0;
    }

    /*
    Takes the current board state and generates all possible moves and the resulting boards, returns
    a Successor object holding ArrayLists of both the board states and moves with corresponding indices
     */
    private static Successors getSuccessors(GameBoard gameBoard, Player player){
        Successors succ = new Successors(); // create new successor object to hold generated boards and moves
        String[][] boardCopy = gameBoard.getBoard().clone(); // create a copy so original board is not modified

        //generate all possible moves
        for(int i = 0; i < gameBoard.MAX_ROWS; i++){
            for(int j = 0; j < gameBoard.MAX_COLUMNS; j++){
                // if spot is blank then marker can be placed
                if(boardCopy[i][j] == " "){
                    boardCopy[i][j] = player.getPlayerMarker(); // add marker to spot
                    succ.addToBoardList(boardCopy);
                    succ.addToMoveList(new int[]{i, j});
                    boardCopy = gameBoard.getBoard().clone(); // reset copy to original value
                }
            }
        }
        return succ;
    }
}
