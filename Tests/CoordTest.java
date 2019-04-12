package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;
import Text.*;

public class CoordTest{
	/**
	 * tests constructor to see if it correctly set the coordinate to 3
	 **/
	@Test
	public void testXValueCoordContructor(){
		Coord initializer = new Coord(3, 4);
		
		assertEquals("Expected x position to be 3", 3, initializer.getXCoord());
		
	}
	/**
	 * tests constructor to see if it correctly set the coordinate to 4
	 **/
	@Test
	public void testYValueCoordContructor(){
		Coord initializer = new Coord(3, 4);
		
		assertEquals("Expected y position to be 4", 4, initializer.getYCoord());
		
	}
	
	@Test
	public void testXCoordCopy(){
		
		Coord copy = new Coord(3, 4);
		Coord initializer = new Coord(copy);
		
		assertEquals("Expected x position for cordinate to be 3", 3, initializer.getXCoord());
	
	}
	
	@Test
	public void testYCoordCopy(){
		
		Coord copy = new Coord(3, 4);
		Coord initializer = new Coord(copy);
		
		assertEquals("Expected Y position for cordinate to be 4", 4, initializer.getYCoord());
	
	}
	/**
	 * tests the getter and setter to make sure the coord is set properly
	 **/
	@Test
	public void testXGetterAndSetter(){
		Coord initializer = new Coord();
		initializer.setXCoord(2);
		
		assertEquals("Expected x position to be 2", 2, initializer.getXCoord());
		
	}
	/**
	 * tests the getter and setter to make sure the coord is set properly
	 **/
	@Test
	public void testYGetterAndSetter(){
		Coord initializer = new Coord();
		initializer.setYCoord(1);
		
		assertEquals("Expected y position to be 1", 1, initializer.getYCoord());
		
	}
	
	@Test
	public void testCopyConstructor(){
		Coord initializer = new Coord();
		Coord beingCopied = new Coord(2, 4);
		
		assertEquals("Expected x position to be 0", 0, initializer.getXCoord());
		
	}
	/**
	 * tests the toString method
	 **/
	@Test
	public void testToString(){
		
		Coord initializer = new Coord(3, 4);
		String i = initializer.toString();
			
		assertEquals("Expected string to be (3, 4)", "(3, 4)", i);
	
	
	}
	/**
	 * tests the toString method
	 **/
	@Test
	public void testToString2(){
		Coord initializer = new Coord(2, 0);
		String i = initializer.toString();
			
		assertEquals("Expected string to be (2, 0)", "(2, 0)", i);
		
		
	}

	/**
	 * tests the add method when it changes the coord
	 **/
	@Test
	
	public void testAddMethodY(){

		Coord initializer = new Coord(1, 0);
		
		initializer.add(1, 1);
		
		assertEquals("Expected y after adding is 1", 1, initializer.getYCoord());
	
	
	}
	/**
	 * tests the add method when it changes the coord
	 **/
	@Test
	
	public void testAddMethodX(){

		Coord initializer = new Coord(1, 0);
		
		initializer.add(2, 2);
		
		assertEquals("Expected y after adding is 3", 3, initializer.getXCoord());
	
	
	}
	
	@Test
	/**
	 * tests the add method when it changes the coord
	 **/
	public void testAddMethodCoordY(){

		Coord initializer = new Coord(1, 0);
		Coord anotherOne = new Coord(2, 2);
		
		initializer.add(anotherOne);
		
		assertEquals("Expected y after adding is 3", 3, initializer.getXCoord());
	
	
	}
	/**
	 * Creates two equal coordinates and tests the equals to make sure the coordinates are the same.
	 * Tests to make sure it returns true
	 **/
	@Test
	public void testEqualsTrue(){
		Coord initializer = new Coord(2, 0);
		Coord other = new Coord(2, 0);
		
		assertEquals("Expected boolean true", true, initializer.equals(other));		
		
	}

	/**
	 * Creates two equal coordinates and tests the equals to make sure the coordinates are the same.
	 * Tests to make sure it returns false
	 **/
	@Test
	public void testEqualsFalse(){
		Coord initializer = new Coord(1, 3);
		Coord other = new Coord(4, 2);
		
		assertEquals("Expected boolean true", false, initializer.equals(other));		
		
	}

}

