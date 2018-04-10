package neustt.fourinarow.tests;

import neustt.fourinarow.BoardCellStatus;
import neustt.fourinarow.GameBoy;
import neustt.fourinarow.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Leo on 2018/4/9.
 */
public class TestGameBoy {

    @Test
    public void shouldCreateGameBoyWithPositiveValues() {
        //Arrange
        GameBoy gameBoy = new GameBoy();

        //Act

        //Assert
        assertEquals(Player.ONE,gameBoy.getPlayer());
        assertEquals(null, gameBoy.getBoard());
    }

    @Test
    public void testInitialiseBoard(){
        //Arrange
        GameBoy gameBoy = new GameBoy();

        //ACT
        BoardCellStatus[][] board  = new BoardCellStatus[6][7];
        for(int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[0].length; column++) {
                board[row][column] = BoardCellStatus.EMPTY;
            }
        }

        //Assert
        assertEquals(board,
                gameBoy.initialiseBoard());
    }


    @Test
    public void testTakeTurn(){
        //Arrange
        GameBoy gameBoy = new GameBoy();

        //ACT

        //Assert
//        assertEquals(Player.TWO,gameBoy.takeTurn());
        gameBoy.takeTurn();
        assertEquals(BoardCellStatus.PLAYER_TWO,gameBoy.takeTurn());
    }
}
