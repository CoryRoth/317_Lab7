package lab7;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

	@Test
	void actionPerformedTest1() {

		ActionEvent e = new ActionEvent("Object", 1, "TestMessage");
		
		String actual = e.getActionCommand();
		String expected = "TestMessage";		
		
		assertEquals(expected, actual);
	}
	
	@Test
	void actionPerformedTest2() {

		ActionEvent e = new ActionEvent("Object", 1, "Action1");
		
		String actual = e.getActionCommand();
		String expected = "Action1";		
		
		assertEquals(expected, actual);
	}
	
	@Test
	void actionPerformedTest3() {

		ActionEvent e = new ActionEvent("Object", 1, "Add Nums");
		
		String actual = e.getActionCommand();
		String expected = "Add Nums";		
		
		assertEquals(expected, actual);
	}

}
