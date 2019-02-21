package test.java.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.calculator.StringCalculator;

public class StringCalculatorTest {

	@Rule
    public ExpectedException thrown= ExpectedException.none();

	
	@Test
	public void addWithInputEmptyStringShouldReturnZero() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void addWithInputOneShouldReturnOne() {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void addWithInputOneAndTwoShouldReturnThree(){
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
	public void addWithInputOneTwoThreeFourShouldReturnTen(){
		assertEquals(10, StringCalculator.add("1,2,3,4"));
	}
	
	@Test
	public void addWithInputsWith1NewLine2ShouldReturn3(){
		assertEquals(4, StringCalculator.add("1\n3"));
	}
	
	@Test
	public void addWithSpecifiedDelimiterSemiColonAndInputNumbers6And3ShouldReturn9(){
		assertEquals(9, StringCalculator.add("//;\n6;3"));
	}
	
	@Test
	public void addMethodWithNegativeNumberShouldThrowExceptionWithMessageAndNumber()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("negatives not allowed -1");
		StringCalculator.add("-1");
	}
	
	@Test
	public void addMethodWithNegativeNumbersShouldThrowExceptionWithMessageAndNumbers()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("negatives not allowed -1,-2,-3");
		StringCalculator.add("-1,-2,-3");
	}
	
}
