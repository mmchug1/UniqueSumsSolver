import java.util.Random;

public class ProblemSolver {
	
	public static int[] fillArray(int[] numbers, int[] array)
	{
		Random rand = new Random();
		int[] temp;
		int numbersLeft;
		int randNum = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			numbersLeft = numbers.length - 1;
			randNum = rand.nextInt(numbers.length);
			array[i] = numbers[randNum];
			if (randNum < numbersLeft)
				numbers[randNum] = numbers[numbersLeft];
			if (i < array.length - 1) {
				temp = new int[numbersLeft];
				for (int j = 0; j < temp.length; j++)
				{
					temp[j] = numbers[j];
				}
				numbers = temp;
			}
		}
		return array;
	}
	
	public static int combineDigits(int[] numberArray)
	{
		String number = "";
		for (int i = 0; i < numberArray.length; i++)
		{
			number += numberArray[i];
		}
		return Integer.parseInt(number);
	}
	
	public static int[] removeUsedNumbers(int[] numberArray, int[] usedArray)
	{
		int[] newArray = new int[numberArray.length - usedArray.length];
		int numUsed = usedArray.length;
		int numTotal = numberArray.length;
		int numChecked = 0; 
		int matchesFound = 0;
		int numUnused = 0;
		boolean match;

		
		for (int i = 0; matchesFound < numUsed; i++)
		{
			match = false;
			for (int j = 0; j < numUsed && match == false; j++)
			{
				if(numberArray[i] == usedArray[j]) {
					match = true;
					matchesFound++;
				}
			}
			if (match == false) {
				newArray[numUnused] = numberArray[i];
				numUnused++;
			}
			numChecked++;
		}
		if (numChecked < numTotal)
		{
			for (int i = numChecked; i < numTotal; i++)
			{
				newArray[numUnused] = numberArray[i];
				numUnused++;
			}
		}
		return newArray;
	}
	
	public static void main(String[] args) {

		boolean solved = false;
		int[] numArray1 = new int[3], numArray2 = new int[3], sumArray = new int[3];
		int num1 = 0, num2 = 0, sum = 0;
		
		
		while (!solved)
		{
			int[] numbers = {1,2,3,4,5,6,7,8,9};

			num1 = combineDigits(numArray1 = fillArray(numbers.clone(), numArray1));
			numbers = removeUsedNumbers(numbers, numArray1);
			num2 = combineDigits(fillArray(numbers.clone(), numArray2));
			numbers = removeUsedNumbers(numbers, numArray2);
			sum = combineDigits(fillArray(numbers, sumArray));
			
			if ((num1 + num2) == sum)
				solved = true;
		}
		System.out.println(num1 + "," + num2 + "," + sum);
	}
}
