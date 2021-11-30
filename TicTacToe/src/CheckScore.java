/*
Checks the gameboard for a win: horizontal, vertical, diagonal
 */
public class CheckScore {
    /*
        Given the current board it returns the heuristic value of the board
        Value of 1 means player 1 wins, -1 player 2 wins, anything in between means no win
        Each spot containing that piece in a row/column/diagonal pattern is worth .25 and
        corners with an extra .125
        */
    public static double calculateScore(String[][] board, String playerMarker, String aiMarker, boolean ai){
        double maxCount = 0;
        double count = rowScore(board, playerMarker); // rows
        if(count > maxCount)
            maxCount = count;

        count = columnScore(board, playerMarker); // columns
        if(count > maxCount)
            maxCount = count;

        count = diagonalScore(board, playerMarker); // diagonals
        if(count > maxCount)
            maxCount = count;

        // if ai is being used, otherwise 2 players
        if(ai) {
            // positive return value is for AI's piece, neg is player
            if (playerMarker.equals(aiMarker))
                return maxCount;
            else
                return -maxCount;
        }
        return maxCount;
    }

    private static double rowScore(String[][] board, String playerMarker){
        double count = 0;
        double maxCount = 0;
        for(int i = 0; i < AILogic.MAX_ROW_COL; i++){
            for(int j = 0; j < AILogic.MAX_ROW_COL; j++){
                if(board[i][j].equals(playerMarker)){
                    count += .25; // add .25 if space contains player marker
                    if(cornerChecker(i, j))
                        count += .125; // add .125 if corner space
                }
            }
            if(count > maxCount)
                maxCount = count;
            count = 0;
        }
        return maxCount;
    }

    private static double columnScore(String[][] board, String playerMarker){
        double count = 0;
        double maxCount = 0;
        for(int i = 0; i < AILogic.MAX_ROW_COL; i++){
            for(int j = 0; j < AILogic.MAX_ROW_COL; j++){
                if(board[j][i].equals(playerMarker)){
                    count += .25; // add .25 if space contains player marker
                    if(cornerChecker(i, j))
                        count += .125; // add .125 if corner space
                }
            }
            if(count > maxCount)
                maxCount = count;
            count = 0;
        }
        return maxCount;
    }

    private static double diagonalScore(String[][] board, String playerMarker){
        double count = 0;
        double maxCount = 0;
        if(board[0][0].equals(playerMarker)) {
            count += .375; // regular space and corner value
            if (board[1][1].equals(playerMarker)) {
                count += .25;
                if(board[2][2].equals(playerMarker))
                    count += .375;
            }
        }
        if(count > maxCount)
            maxCount = count;
        count = 0;
        if(board[2][0].equals(playerMarker)){
            count += .375; // regular and corner space
            if(board[1][1].equals(playerMarker)){
                count += .25;
                if(board[0][2].equals(playerMarker))
                    count += .375;
            }
        }
        if(count > maxCount)
            maxCount = count;
        return maxCount;
    }

    /*
   Checks if the provided row/column is a corner space on the board
    */
    private static boolean cornerChecker(int row, int column){
        if(row == 0 && column == 0)
            return true;
        else if(row == 0 && column == 2)
            return true;
        else if(row == 2 && column == 0)
            return true;
        else if(row == 2 && column == 2)
            return true;
        return false;
    }
}
