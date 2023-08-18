package DiceCounterCLI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiceCounter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of dice rolls: ");
		
		int numberOfRolls = scanner.nextInt();
		
		int[] rolls = new int[numberOfRolls];
		
		for (int i = 0; i < numberOfRolls; i++) {
			System.out.print("Enter the value for roll " + (i + 1) + ": ");
			rolls[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		double average = CalculateMean(rolls);
		System.out.println("The average is " + average + "");
		
		double median = CalculateMedian(rolls);
		System.out.println("The median is " + median + "");
		
		double mode = CalculateMode(rolls);
		System.out.println("The mode is " + mode + "");
		
		int even = CalculateEven(rolls);
		System.out.println("The number of even numbers is " + even + "");
		
		int odd = CalculateOdd(rolls);
		System.out.println("The number of odd numbers is " + odd + "");


	}
	
	private static double CalculateMean(int[] rolls) {
		if(rolls.length == 0) {
			return 0.0;
		}
		
		int sum = 0;
		for(int roll : rolls) {
			sum += roll;
        }
		return (double) sum / rolls.length;
	}
	

	
	private static double CalculateMedian(int[] rolls) {
		if(rolls.length == 0) {
			return 0.0;
		}
		
		Arrays.sort(rolls);
		
		if(rolls.length % 2 == 0) {
			int middle1 = rolls.length / 2;
			int middle2 = middle1 - 1;
			
			return (rolls[middle1] + rolls[middle2]) / 2;
		} else {
			int middle = rolls.length / 2;
			return rolls[middle];
		}
	}
	
	private static int CalculateMode(int[] rolls) {
		if(rolls.length == 0) {
			return 0;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxFrequency = 0;
		int mode = 0;
		
		for(int roll : rolls) {
			int frequency = map.getOrDefault(rolls, 0) + 1;
			map.put(roll, frequency);
			
            if(frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = roll;
            }
		}
		
		return mode;
	}
	
	private static int CalculateEven(int[] rolls) {
		int count = 0;
		for(int roll : rolls) {
			if(roll % 2 == 0) {
                count++;
            }
		}
		return count;
	}
	
	private static int CalculateOdd(int[] rolls) {
		int count = 0;
		for(int roll : rolls) {
			if(roll % 2 == 1) {
                count++;
            }
		}
		return count;
	}

	
}
