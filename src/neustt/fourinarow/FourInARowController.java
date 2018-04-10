package neustt.fourinarow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the main user interface. This will respond to the 
 * user interface events, e.g. button presses. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class FourInARowController implements Initializable {

    private GameBoy gameBoy = new GameBoy();

    public GameBoy getGameBoy() {
        return gameBoy;
    }

    public void setGameBoy(GameBoy gameBoy) {
        this.gameBoy = gameBoy;
    }

    /**
	 * Represents a board that is a 2-dimensional array
	 * of BoardCellStatus items.
	 */
    private BoardCellStatus[][] board = null;
    
    /**
     * The current player for the game. 
     */
    private Player player = Player.ONE; 
    
    /** 
     * A link to the text area that is shown at the bottom of the main window.
     */
    @FXML
    private TextArea messageArea;
    
    /**
     * Link to the undo menu item. 
     */ 
    @FXML 
    private MenuItem undoMenuItem; 
    
    /** 
     * Link to the redo menu item. 
     */
    @FXML 
    private MenuItem redoMenuItem; 
    
    /**
     * A link to the grid that shows the different squares that represent 
     * the game. 
     */
    @FXML
    private GridPane boardGrid;

    /**
     * Displays the current state of the board. This will redraw the 
     * entire board on the screen. 
     */
    private void displayBoard() {
        for(int row = 0; row < board.length; row++) { 
            for(int column = 0; column < board[0].length; column++) { 
                
                Node node = getNodeByRowColumnIndex(row + 1, column);
                String colour = "#000";
                switch(board[row][column]) { 
                    case EMPTY: 
                        colour = "#eaeaea";
                        break;
                        
                    case PLAYER_ONE:
                        colour = "#00f";
                        break;
                        
                    case PLAYER_TWO: 
                        colour = "#f00";
                        break;
                }
                
                if(node instanceof Pane) { 
                   node.setStyle("-fx-background-color: " + colour);
                }
                else { 
                    System.out.println("Found something unexpected for " + (row + 1) + " - " + column);
                    System.out.println(node);
                }
            }
        }
    }
    
    /**
     * Handles a button press from one of the buttons at the top of the 
     * screen. When the button is pressed, it checks if there is a space in 
     * the same column as the button. If there is a space, the space is 
     * set to the value for the current player. The board is then redisplayed.  
     * 
     * @param event The event that specifies which button was pressed. 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        int selectedColumn = 0;
        
        // determine which column the button is in. 
        GridPosition position = getGridPositionForNode((Node)event.getSource());
        selectedColumn = position.getColumn(); 
        messageArea.setText("Column " + (selectedColumn + 1));
      
        if(board != null) {
            int emptyRow = -1; 
            
            // check if there is an empty row
            for(int row = 5 ; row >= 0; row--) { 
                if(board[row][selectedColumn] == BoardCellStatus.EMPTY) { 
                    emptyRow = row; 
                    break;
                }
            }
            
            if(emptyRow != -1) { 
               // there is an empty row - update the turn and redisplay the board
               BoardCellStatus turn = this.getGameBoy().takeTurn();
               board[emptyRow][selectedColumn] = turn;
               displayBoard();
            }
            else { 
                messageArea.setText("No available positions in this column.");
            }
        }
    }

    /**
     * Gets the position of a node in the GridPane. From the node, the 
     * row and column position is extracted. This is then placed into 
     * a GridPosition object. 
     * 
     * @param node The node from the user interface, e.g. a Pane. 
     * @return A GridPosition object. 
     */
    public GridPosition getGridPositionForNode(Node node) { 
        GridPosition position = new GridPosition(); 
        position.setRow(GridPane.getRowIndex(node)); 
        position.setColumn(GridPane.getColumnIndex(node));
        return position;
    }
    
    /**
     * Given a row and column pair, this method identifies the Node that is held within the 
     * grid pane that shows the board. A node is a visual component. For this application, 
     * it is a Button if it is in the top column. Otherwise, this is a Pane, which is rectangular 
     * block that we are setting to a colour to represent a move played. 
     * 
     * @param row The row. 
     * @param column The column. 
     * @return If a node is found it is returned. Otherwise, null is returned. 
     */
    public Node getNodeByRowColumnIndex (int row, int column) {
        Node result = null;
        ObservableList<Node> children = boardGrid.getChildren();
        
        for (Node node : children) {
            GridPosition position = getGridPositionForNode(node);
            if (row == position.getRow() && column == position.getColumn()) { 
                result = node;
                break;
            }
        }
        return result;
    }
    
    /**
     * Shows an About dialog. 
     * @param event The event that started the action.
     */
    @FXML
    private void handleAboutDialogAction(ActionEvent event) {
        FourInARowDialogController dialogController = new FourInARowDialogController(); 
        dialogController.showDialog(boardGrid.getScene().getWindow());
    }


    /**
     * Starts a game with two human players. This will initialise an empty board and
     * display that to the screen. The default situation is that the top level buttons
     * are not enabled. This method will enable them so that the players can select
     * which column to make a move with.
     *
     * @param event The event that sarted the action.
     */
    @FXML
    private void handleStartTwoPlayerGameAction(ActionEvent event) {
        board = this.getGameBoy().initialiseBoard();
        displayBoard();
        player = Player.ONE;

        for(int column = 0; column < 7; column++) {
            Node node = getNodeByRowColumnIndex(0, column);
            if(node instanceof Button) {
                ((Button)node).setDisable(false);
            }
            else {
                System.err.println("Unexpected item found: " + node);
            }
        }

        messageArea.setText("Starting a two player game.");
    }

    /**
     * A place where you could add support for a single person game. You would use this 
     * to start a game where one of the players is your computer player. 
     * 
     * @param event The event that generated this action. 
     */
    @FXML 
    private void handleStartOnePlayerGameAction(ActionEvent event) { 
    	messageArea.setText("Not implemented - implement this when you start work on a computer player.");
    }
    
    /**
     * Quits the application by calling System.exit(0); 
     * @param event The event that specifies which user interface item generated 
     * the action. In this case, it is a menu item.
     */
    @FXML
    private void handleQuitAction(ActionEvent event) { 
       System.exit(0); 
    }
    
    /** 
     * Responds to the Undo action being called from the menu. 
     */
    @FXML
    private void handleUndoAction(ActionEvent event) { 
       messageArea.setText("undo"); 
    }
    
    /** 
     * Responds to the Redo action being called from the menu. 
     */
    @FXML
    private void handleRedoAction(ActionEvent event) { 
       messageArea.setText("redo");  
    }
    
    /** 
     * Required as part of the Initializable interface. Not used in this class.
     * @param url Not used. 
     * @param rb Not used.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
