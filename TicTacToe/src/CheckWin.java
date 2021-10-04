/*
Checks the gameboard for a win: horizontal, vertical, diagonal
 */
public class CheckWin {

    public static boolean checkWin(String[][] board, String marker){
        boolean horizontal = false;
        boolean vertical = false;
        boolean diagonal = false;
        // must check horizontal, vertical, and diagonal
        horizontal = checkHorizontal(board, marker);
        if(!horizontal)
            vertical = checkVertical(board, marker);
        if(!horizontal && !vertical)
            diagonal = checkDiagonal(board, marker);
        if(horizontal || vertical || diagonal)
            return true;
        return false;
    }

    private static boolean checkHorizontal(String[][] board, String marker){
        for(int i = 0; i < board.length; i++){
            int count = 0; // counts how many of the player's marker is found in row
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == marker)
                    count++;
            }
            if(count == 3)
                return true;
        }
        return false;
    }

    private static boolean checkVertical(String[][] board, String marker){
        for(int i = 0; i < board.length; i++){
            int count = 0; // counts how many of the player's marker is found in column
            for(int j = 0; j < board[i].length; j++){
                if(board[j][i] == marker)
                    count++;
            }
            if(count == 3)
                return true;
        }
        return false;
    }

    private static boolean checkDiagonal(String[][] board, String marker){
        int count = 0;
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == marker)
                count++;
        }
        if(count == 3)
            return true;
        else
            count = 0;
        //todo code case for other diagonal
        for(int i = 0; i < board.length; i++){
            count = 0;
            for(int j = board.length - 1; j >= 0; j--){
                if(board[i][j] == marker)
                    count++;
            }
        }
        if(count == 3)
                return true;
        else
            return false;
    }
}
