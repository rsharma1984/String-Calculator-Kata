package main.java.calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	public static Object add(String input) {
		if(input=="") return 0;
		
		return sumOf(extractedValuesFrom(equationUsing(customDelimiterIfExists(input))));
	}
	
	private static String[] customDelimiterIfExists(String input) {
		
		String[] splittedInput = {",|\n", input};
		if(input.startsWith("//")) {
			splittedInput = input.split("\n");
			splittedInput[0]=splittedInput[0].substring(2);
		}
		return splittedInput;
	}

	private static String[] equationUsing(String[] delimiterAndInputString) {
		return delimiterAndInputString[1].split(delimiterAndInputString[0]);
	}

	private static List<Integer> extractedValuesFrom(String[] equation) {
		return Stream.of(equation).map(i -> Integer.parseInt(i)).collect(Collectors.toList());	
	}
	
	private static int sumOf(List<Integer> values) {
		if(values.stream().anyMatch(x -> x < 0)){
			String negativeValues = values.stream().filter(x -> x < 0).map(y -> y.toString()).collect(Collectors.joining(","));			
			throw new IllegalArgumentException("negatives not allowed "+negativeValues);
		}
		return values.stream().reduce((x, y) -> x + y).get();
	}
	
}
