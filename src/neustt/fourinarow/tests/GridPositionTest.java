package neustt.fourinarow.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import neustt.fourinarow.GridPosition;

public class GridPositionTest {

	@Test
	public void shouldCreateGridPositionWithPositiveValues() {
		GridPosition position = new GridPosition();
		assertEquals(new Integer(0), position.getRow());
		assertEquals(new Integer(0), position.getColumn());
	}
	
	@Test
	public void shouldSetRowWithPositiveValue() { 
		GridPosition position = new GridPosition(); 
		position.setRow(10);
		assertEquals(new Integer(10), position.getRow());
	}
	
	@Test
	public void shouldSetRowWithValueOne() { 
		GridPosition position = new GridPosition(); 
		position.setRow(1);
		assertEquals(new Integer(1), position.getRow());
	}
	
	@Test
	public void shouldSetRowWithZeroValue() { 
		GridPosition position = new GridPosition(); 
		position.setRow(0); 
		assertEquals(new Integer(0), position.getRow()); 
	}
	
    @Test
    public void shouldSetRowWithNullValue() { 
    	GridPosition position = new GridPosition(); 
    	position.setRow(null); 
		assertEquals(new Integer(0), position.getRow()); 
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowExceptionIfRowIsNegative() { 
    	GridPosition position = new GridPosition(); 
    	position.setRow(-1);
    }
    
    @Test
	public void shouldSetColumnWithPositiveValue() { 
		GridPosition position = new GridPosition(); 
		position.setColumn(10);
		assertEquals(new Integer(10), position.getColumn());
	}
	
	@Test
	public void shouldSetColumnWithValueOne() { 
		GridPosition position = new GridPosition(); 
		position.setColumn(1);
		assertEquals(new Integer(1), position.getColumn());
	}
	
	@Test
	public void shouldSetColumnWithZeroValue() { 
		GridPosition position = new GridPosition(); 
		position.setColumn(0); 
		assertEquals(new Integer(0), position.getColumn()); 
	}
	
    @Test
    public void shouldSetColumnWithNullValue() { 
    	GridPosition position = new GridPosition(); 
    	position.setColumn(null); 
		assertEquals(new Integer(0), position.getColumn()); 
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowExceptionIfColumnIsNegative() { 
    	GridPosition position = new GridPosition(); 
    	position.setColumn(-1);
    }

}
