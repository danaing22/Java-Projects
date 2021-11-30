public class SuccessorLogic {/*
    Takes the current board state and generates all possible moves for current player and the resulting
     boards, returns a Successor object holding ArrayLists of both the board states and moves with
     corresponding indices
     */
    public static SuccessorListObj getSuccessors(String[][] board, String playerMarker) {
        SuccessorListObj succ = new SuccessorListObj(); // create new successor object to hold generated boards and moves
        String[][] boardCopy = makeBoardCopy(board); // create a copy so original board is not modified

        //generate all possible moves
        for (int i = 0; i < AILogic.MAX_ROW_COL; i++) {
            for (int j = 0; j < AILogic.MAX_ROW_COL; j++) {
                // if spot is blank then marker can be placed
                if (boardCopy[i][j].equals(" ")) {
                    boardCopy[i][j] = playerMarker; // add marker to spot
                    succ.addToBoardList(boardCopy); // add this new board to successor list
                    succ.addToMoveList(new int[]{i, j}); // add move to list
                    boardCopy = makeBoardCopy(board); // reset copy to original board
                }
            }
        }
        return succ;
    }

    private static String[][] makeBoardCopy(String[][] board){
        String[][] copy = new String[3][3];
        for (int i = 0; i < AILogic.MAX_ROW_COL; i++) {
            for (int j = 0; j < AILogic.MAX_ROW_COL; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}