package neustt.fourinarow;

/**
 * Represents a cell in the Grid that is shown in the main window. This allows 
 * a pair of values to be represented and returned from a search in the grid.
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class GridPosition {
    
	/** The row */ 
    private Integer row;
    
    /** The column */ 
    private Integer column; 
    
    /**
     * Creates a new instance with default values of 0 and 0.
     */
    public GridPosition() { 
    	row = 0; 
    	column = 0; 
    }
    
    /**
     * Gets the row value.
     * 
     * @return The number, which is 0 or greater.
     */
    public Integer getRow() { 
        return row;
    }
    
    /**
     * Sets the row value. 
     * 
     * @param row The row value. If null is passed in, it will be converted to a 0.
     * @throws IllegalArgumentException if the value is negative.
     */
    public void setRow(Integer row) { 
        if(row == null) { 
            this.row = 0; 
        }
        else if(row >= 0) { 
            this.row = row;
        }
        else { 
        	throw new IllegalArgumentException("Column value must be 0 or more.");
        }
    }
    
    /**
     * Gets the column value.
     * @return The column value, which is 0 or greater.
     */
    public Integer getColumn() { 
        return column;
    }
    
    /**
     * Sets the column number.
     * 
     * @param column The number for the column. If the parameter is null, the value is converted to 0.
     * @throws IllegalArgumentException if the parameter is less than 0.
     */
    public void setColumn(Integer column) {
    	if(column == null) { 
            this.column = 0; 
        }
        else if(column >= 0) { 
            this.column = column;
        }
        else { 
        	throw new IllegalArgumentException("Column value must be 0 or more."); 
        }
    }
    
    /** 
     * Creates a string representation, showing the format <code>[row,column]</code>.
     */
    @Override 
    public String toString() { 
        return "[" + row + "," + column + "]";
    }
    
}
