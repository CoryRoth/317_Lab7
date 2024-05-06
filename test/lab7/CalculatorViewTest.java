package lab7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Observable;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorViewTest {
	
	CalculatorView view;
	
	@BeforeEach
	void Initialize()
	{
		view = new CalculatorView();
	}

	@Test
	void updateTest1() {
		double num = 5.0;
	
		String expected = String.valueOf(num);
		view.update(new Observable(), num);
		
		assertEquals(expected, view.GetDisplayField().getText());
	}
	
	@Test
	void updateTest2() {
		double num = -500.34;
		
		String expected = String.valueOf(num);
		view.update(new Observable(), num);
		
		assertEquals(expected, view.GetDisplayField().getText());
	}

}
