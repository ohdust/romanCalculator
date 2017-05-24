//Spring 2015
//COSC 211 and 212



import java.util.Scanner;

public class RomanNumeralCalculator {

	public static void main(String[] args) 
	{	// ask for the first roman numeral
		String firstNumeral = get_Data();
		
		// turn 1st roman numeral into an integer
		int number1 = convert_From_Roman(firstNumeral);
		
		// ask for the second roman numeral
		String secondNumeral = get_Data();
		
		// turn 2nd roman numeral into an integer
		int number2 = convert_From_Roman(secondNumeral); 
		
		// ask for a math operator
		char operAtor = get_Operator();

		// perform selected math operation on the 2 integers
		int resultInteger = calc_Romans(number1, number2, operAtor);
		
		// turn the result into a roman numeral
		String resultRomanNumeral = convert_To_Roman(resultInteger); 
		
		print_Result(resultRomanNumeral);
		
	}

	
	// Asks the user to input a roman numeral, and passes that as a string.
	public static String get_Data()
	{
		Scanner keyboard = new Scanner(System.in);
		String firstInput;
		
		System.out.println("Enter a Roman Numeral and press Enter.");
		firstInput = keyboard.nextLine();
		firstInput = firstInput.toUpperCase();

		// Uses the class is_bad_Roman_Numeral to decide whether to repeat
		while (is_bad_Roman_Numeral(firstInput))
		{
			System.out.println("That is not a valid Roman Numeral. Try that one again.");
			firstInput = keyboard.nextLine();
			firstInput = firstInput.toUpperCase();
		}
		return firstInput;
	}

	
	// checks for valid Roman Numeral
	public static boolean is_bad_Roman_Numeral(String romanNumeral)
	{
		for (int i = 0; i < romanNumeral.length(); i++)
		{
			switch (romanNumeral.charAt(i)) 
			{
			case 'M':
			case 'D':
			case 'C':
			case 'L':
			case 'X':
			case 'V':
			case 'I':
				break;
			default:
			return true;
			}
		}
		return false;
	}

	
	// takes a Roman Numeral as a string, converts it to, & passes, an integer.
	public static int convert_From_Roman(String romanNumeral)
	{
		int number1 = 0;
		
			for (int i = 0; i < romanNumeral.length(); i++)
			{
				switch (romanNumeral.charAt(i)) 
				{
				case 'M':
					number1 += 1000;
					break;
				case 'D':
					number1 += 500;
					break;
				case 'C':
					number1 += 100;
					break;
				case 'L':
					number1 += 50;
					break;
				case 'X':
					number1 += 10;
					break;
				case 'V':
					number1 += 5;
					break;
				case 'I':
					number1 += 1;
					break;
				default:
					System.out.println("That is not a valid Roman Numeral.");
				break;
				}
			}
		return number1;
	}
	
	
	// Asks the user what math operation to perform, & passes it as a character.
	public static char get_Operator()
	{	
	System.out.println("Enter an operator character and press Enter.");
	Scanner keyboard = new Scanner(System.in);
	String operatorInput;
	operatorInput = keyboard.nextLine();
	char operAtor = operatorInput.charAt(0);
	return operAtor;
	}
	
	
	/* Performs the desired type of calculation on two integers and returns the
	resulting integer. Be aware that this method performs integer division.*/
	public static int calc_Romans(int number1, int number2, char operAtor)
	{
		if (operAtor == '+')
			return number1 + number2;
		else if (operAtor == '-')
			return number1 - number2;
		else if (operAtor == '*')
			return number1 * number2;
		else
			return number1 / number2;
	}
	
	
	// Takes an integer and turns it into a Roman Numeral.
	public static String convert_To_Roman(int Nnum)
	{
		int Mnum = Nnum / 1000;
		int Mmod = Nnum % 1000;

		int Dnum = Mmod / 500;
		int Dmod = Mmod % 500;

		int Cnum = Dmod / 100;
		int Cmod = Dmod % 100;

		int Lnum = Cmod / 50;
		int Lmod = Cmod % 50;

		int Xnum = Lmod / 10;
		int Xmod = Lmod % 10;

		int Vnum = Xmod / 5;

		int Inum = Xmod % 5;

		String romanNumeral = "";
		while (Mnum > 0)
		{
			romanNumeral = romanNumeral += "M";
			Mnum--;
		}
		while (Dnum > 0)
		{
			romanNumeral = romanNumeral += "D";
			Dnum--;
		}
		while (Cnum > 0)
		{
			romanNumeral = romanNumeral += "C";
			Cnum--;
		}
		while (Lnum > 0)
		{
			romanNumeral = romanNumeral += "L";
			Lnum--;
		}
		while (Xnum > 0)
		{
			romanNumeral = romanNumeral += "X";
			Xnum--;
		}
		while (Vnum > 0)
		{
			romanNumeral = romanNumeral += "V";
			Vnum--;
		}
		while (Inum > 0)
		{
			romanNumeral = romanNumeral += "I";
			Inum--;
		}
		return romanNumeral;
	}

	
	public static void print_Result(String romanNumeral)
	{
		System.out.println("The result is: " + romanNumeral);
	}
}
