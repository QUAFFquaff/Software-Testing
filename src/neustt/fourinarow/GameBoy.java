package neustt.fourinarow;

/**
 * Created by Leo on 2018/4/9.
 */
public class GameBoy {
    /**
     * The current player for the game.
     */
    private Player player = Player.ONE;

    public Player getPlayer() {
        return player;
    }

    public BoardCellStatus[][] getBoard() {
        return board;
    }

    /**
     * Represents a board that is a 2-dimensional array
     * of BoardCellStatus items.
     */
    private BoardCellStatus[][] board = null;

    /**
     * Initialises the two dimensional array with empty positions.
     */
    public BoardCellStatus[][] initialiseBoard() {
        board = new BoardCellStatus[6][7];
        for(int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[0].length; column++) {
                board[row][column] = BoardCellStatus.EMPTY;
            }
        }
        return board;
    }

    /**
     * Takes the turn and returns the status that should be recorded on the board.
     * If the current player is ONE, the next player is set to TWO. And, the returned
     * value to be recorded this time is TWO.
     *
     * @return The status (PLAYER_ONE or PLAYER_TWO) that is to be recorded for
     * the cell on the board.
     */
    public BoardCellStatus takeTurn() {
        if(player == Player.ONE) {
            player = Player.TWO;
            return BoardCellStatus.PLAYER_ONE;
        }
        else {
            player = Player.ONE;
            return BoardCellStatus.PLAYER_TWO;
        }
    }


}
