package lab7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorModelTest {

	CalculatorModel model;
	
	@BeforeEach
	void Setup()
	{
		model = new CalculatorModel();
	}
	
	@Test
	void memoryClear() {
		
		double expected = 0.0;
		
		model.setMemory(5.0);
		model.clearMemory();
		
		assertEquals(model.getMemory(), expected);
	}
	
	@Test
	void memorySet() {
		
		double expected = 6.0;
		
		model.setMemory(6.0);
		
		assertEquals(model.getMemory(), expected);
	}
	
	@Test
	void initialMemoryIsZero() {
		
		double expected = 0.0;
		
		assertEquals(model.getMemory(), expected);
	}
	
	@Test
	void divideByZero() {
		
		double expected = Double.NaN;
		
		double actual = CalculatorModel.calculate(1, 0, "/");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void divisionTest1() {
		
		double expected = 4.0/6.0;
		
		double actual = CalculatorModel.calculate(4, 6, "/");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void divisionTest2() {
		
		double expected = -25.0/10.0;
		
		double actual = CalculatorModel.calculate(-25, 10, "/");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void divisionTest3() {
		
		double expected = 700.0/9000.0;
		
		double actual = CalculatorModel.calculate(700, 9000, "/");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void divisionTestMax() {
		
		double expected = Double.MAX_VALUE/Double.MAX_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MAX_VALUE, Double.MAX_VALUE, "/");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void additionOverMax() {
		
		double expected = Double.MAX_VALUE + 1.0;
		
		double actual = CalculatorModel.calculate(Double.MAX_VALUE, 1.0, "+");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void additionNegatives() {
		
		double expected = -5.0 + -1.0;
		
		double actual = CalculatorModel.calculate(-5.0, -1.0, "+");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void additionPositives() {
		
		double expected = 1.0 + 1.0;
		
		double actual = CalculatorModel.calculate(1.0, 1.0, "+");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void additionNegativeAndPositive() {
		
		double expected = -5.0 + 7.0;
		
		double actual = CalculatorModel.calculate(-5.0, 7.0, "+");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void additionUnderMin() {
		
		double expected = Double.MIN_VALUE + Double.MIN_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MIN_VALUE, Double.MIN_VALUE, "+");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void subtractionMax() {
		
		double expected = Double.MAX_VALUE - Double.MAX_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MAX_VALUE, Double.MAX_VALUE, "-");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void subtractionMin() {
		
		double expected = Double.MIN_VALUE - Double.MIN_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MIN_VALUE, Double.MIN_VALUE, "-");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void subtractionNegatives() {
		
		double expected = -2.0 - -6.0;
		
		double actual = CalculatorModel.calculate(-2.0, -6.0, "-");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void subtractionPositives() {
		
		double expected = 7.0 - 34.0;
		
		double actual = CalculatorModel.calculate(7.0, 34.0, "-");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void subtractionNegativeAndPositive() {
		
		double expected = -2.0 - 20.0;
		
		double actual = CalculatorModel.calculate(-2.0, 20.0, "-");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void multiplyMax() {
		
		double expected = Double.MAX_VALUE * Double.MAX_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MAX_VALUE, Double.MAX_VALUE, "*");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void multiplyMin() {
		
		double expected = Double.MIN_VALUE * Double.MIN_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MIN_VALUE, Double.MIN_VALUE, "*");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void multiplyNegatives() {
		
		double expected = -550.0 * -6.5;
		
		double actual = CalculatorModel.calculate(-550.0, -6.5, "*");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void multiplyPositives() {
		
		double expected = 4.2 * 2.0;
		
		double actual = CalculatorModel.calculate(4.2, 2.0, "*");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void multiplyNegativeAndPositive() {
		
		double expected = 7330.0 * 20.8;
		
		double actual = CalculatorModel.calculate(7330, 20.8, "*");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squarePositive() {
		
		double expected = 20 * 20;
		
		double actual = CalculatorModel.calculate(20, 50, "sq");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squareNegative() {
		
		double expected = -20 * -20;
		
		double actual = CalculatorModel.calculate(-20, 50, "sq");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squareMaxTest() {
		
		double expected = Double.MAX_VALUE * Double.MAX_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MAX_VALUE, 50, "sq");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squareMinTest() {
		
		double expected = Double.MIN_VALUE * Double.MIN_VALUE;
		
		double actual = CalculatorModel.calculate(Double.MIN_VALUE, 50, "sq");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squareRootTest1() {
		
		double expected = Math.sqrt(16);
		
		double actual = CalculatorModel.calculate(16, 50, "sqrt");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squareRootTest2() {
		
		double expected = Math.sqrt(40);
		
		double actual = CalculatorModel.calculate(40, 50, "sqrt");
		
		assertEquals(actual, expected);
	}
	
	@Test
	void squareRootTest3() {
		
		double expected = Math.sqrt(2048);
		
		double actual = CalculatorModel.calculate(2048, 50, "sqrt");
		
		assertEquals(actual, expected);
	}

}
