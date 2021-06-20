//Ishan Senapati/ishanse@live.com
//Date modified: 11/24/15
import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		System.out.println("Welcome to Ishan's Frac Calc");
		System.out.println("Type an expression and press <enter>");

		String operation = console.nextLine();

		while (!operation.equals("quit")) {
			SplitFrac(operation); //calls on the SplitFrac method

			System.out.println("Type an expression and press <enter>");
			operation = console.nextLine(); //this is where you type the expression
			
			
			
		}
		
		System.out.println("Good Bye Homie!");
		console.close();

	}

	public static void SplitFrac(String input) {

		String input1 = input;

		if (input.contains(" + ")) {
			input1 = input1.replace(" + ", "   "); //replacing all + operands with spaces
		} else if (input.contains(" - ")) {
			input1 = input1.replace(" - ", "   "); //replacing all - operands with spaces
		} else if (input.contains(" * ")) {
			input1 = input1.replace(" * ", "   "); //replacing all * operands with spaces
		} else if (input.contains(" / ")) {
			input1 = input1.replace(" / ", "   "); //replacing all / operands with spaces
		}

		String[] split = input1.split("   ");
		//declaring an array that splits into two
		input1 = input1.replace('_', ' '); //replacing the _ and / with spaces
		input1 = input1.replace('/', ' ');

		String[] results = input1.split("   ");

		Scanner firstt1 = new Scanner(results[0]);

		int firstint = 0, firstnum = 0, firstdenom = 0, secondint = 0, secondnum = 0, seconddenom = 0;

		if (split[0].contains("_")) {
			firstint = firstt1.nextInt();
		}
		if (!split[0].contains("_") && !split[0].contains("/")) { //allows a whole number to be inputed as the first fraction
			firstint = firstt1.nextInt(); 

			firstnum = firstint; // 3 -> 0_3/1
			firstdenom = 1;
			firstint = 0;
		}

		if (split[0].contains("/") && !split[0].contains("_")) { //allows a fraction less than 1 to be inputed as the first fraction
			firstint = 0;
			firstnum = firstt1.nextInt();
			firstdenom = firstt1.nextInt();
		}

		if (split[0].contains("_") && split[0].contains("/")) { //allows a mixed fraction to be inputed as the first fraction
			firstnum = firstt1.nextInt();
			firstdenom = firstt1.nextInt();
		}

		int whole1 = firstint;
		int num1 = firstnum;
		int denom1 = firstdenom;

		Scanner secondt2 = new Scanner(results[1]);

		if (split[1].contains("_")) {
			secondint = secondt2.nextInt();
		}
		if (!split[1].contains("_") && !split[1].contains("/")) { //allows a whole number to be inputed as the second fraction
			secondint = secondt2.nextInt();

			secondnum = secondint; // 3 -> 0_3/1
			seconddenom = 1;
			secondint = 0;
		}

		if (split[1].contains("/") && !split[1].contains("_")) { //allows a fraction less than 1 to be inputed as the second fraction
			secondint = 0;
			secondnum = secondt2.nextInt();
			seconddenom = secondt2.nextInt();
		}

		if (split[1].contains("_") && split[1].contains("/")) { //allows a mixed fraction to be inputed as the second fraction
			secondnum = secondt2.nextInt();
			seconddenom = secondt2.nextInt();
		}

		int whole2 = secondint;
		int num2 = secondnum;
		int denom2 = seconddenom;
		

		if (input.contains(" + ")) { //code below is an if statements for compiling the expressions inputed into the console
			System.out.println(addFrac(whole1, num1, denom1, whole2, num2, denom2)); 
		}
		if (input.contains(" - ")) {
			System.out.println(subFrac(whole1, num1, denom1, whole2, num2, denom2));
		}
		if (input.contains(" * ")) {
			System.out.println(multiFrac(whole1, num1, denom1, whole2, num2, denom2));
		}
		if (input.contains(" / ")) {
			System.out.println(divideFrac(whole1, num1, denom1, whole2, num2, denom2));
		}
		
		firstt1.close();
		secondt2.close();
	}

	public static String addFrac(int whole1, int num1, int denom1, int whole2, int num2, int denom2) { //method for adding fracs

		int resnum1 = 0, resnum2 = 0;

		if (whole1 < 0) { //can now handle negatives with the first fraction/whole num.
			resnum1 = (whole1 * denom1) - num1;
		} else if (whole1 >= 0) {
			resnum1 = ((whole1 * denom1) + num1);
		}
		if (whole2 < 0) { //can now handle negatives with the second fraction/whole num.
			resnum2 = (whole2 * denom2) - num2;
		} else if (whole2 >= 0) {
			resnum2 = ((whole2 * denom2) + num2);
		}

		int resnum = (resnum1 * denom2) + (resnum2 * denom1); //finding the final numerator
		int denom = (denom1 * denom2); //finding the final denominator

		int numfinal = resnum % denom;
		int denomfinal = denom;

		for (int i = denom / 2; i > 0; i--) { //reduces the output
			if (numfinal % i == 0 && denom % i == 0) {
				numfinal /= i;
				denomfinal /= i;
				break;
			}
		}

		int resWhole = resnum / denom;

		if (resWhole < 0) { //makes output -1_-2/3 to -1_2/3
			numfinal = numfinal * -1;
		}

		String result = ((resWhole) + "_" + (numfinal) + "/" + denomfinal);

		if (resWhole == 0) { //makes output 0_1/4 to 1/4
			result = numfinal + "/" + denomfinal;
		}
		if (numfinal == 0) { //makes output 1_0/2 to 1
			result = resWhole + "";
		}

		return result;
	}

	public static String subFrac(int whole1, int num1, int denom1, int whole2, int num2, int denom2) { //method for substracting fracs

		int resnum1 = 0, resnum2 = 0;

		if (whole1 < 0) { //can now handle negatives with the first fraction/whole num.
			resnum1 = (whole1 * denom1) - num1;
		} else if (whole1 >= 0) {
			resnum1 = ((whole1 * denom1) + num1);
		}
		if (whole2 < 0) { //can now handle negatives with the second fraction/whole num.
			resnum2 = (whole2 * denom2) - num2;
		} else if (whole2 >= 0) {
			resnum2 = ((whole2 * denom2) + num2);
		}

		int resnum = (resnum1 * denom2) - (resnum2 * denom1); //finding the final numerator
		int denom = (denom1 * denom2); //finding the final denominator

		int numfinal = resnum % denom;
		int denomfinal = denom;

		for (int i = denom / 2; i > 0; i--) { //reduces the output
			if (numfinal % i == 0 && denom % i == 0) {
				numfinal /= i;
				denomfinal /= i;
				break;
			}
		}

		int resWhole = resnum / denom;

		if (resWhole < 0) { //makes output -1_-2/3 to -1_2/3
			numfinal = numfinal * -1;
		}

		String result = ((resWhole) + "_" + (numfinal) + "/" + denomfinal);

		if (resWhole == 0) { //makes output 0_1/4 to 1/4
			result = numfinal + "/" + denomfinal;
		}
		if (numfinal == 0) { //makes output 1_0/2 to 1
			result = resWhole + "";
		}

		return result;
	}

	public static String multiFrac(int whole1, int num1, int denom1, int whole2, int num2, int denom2) { //method for multiplying fracs

		int resnum1 = 0, resnum2 = 0;

		if (whole1 < 0) { //can now handle negatives with the first fraction/whole num.
			resnum1 = (whole1 * denom1) - num1;
		} else if (whole1 >= 0) {
			resnum1 = ((whole1 * denom1) + num1);
		}
		if (whole2 < 0) { //can now handle negatives with the second fraction/whole num.
			resnum2 = (whole2 * denom2) - num2;
		} else if (whole2 >= 0) {
			resnum2 = ((whole2 * denom2) + num2);
		}

		int resnum = resnum1 * resnum2; //finding the final numerator
		int denom = denom1 * denom2; //finding the final denominator

		int numfinal = resnum % denom;
		int denomfinal = denom;

		for (int i = denom / 2; i > 0; i--) { //reduces the output
			if (numfinal % i == 0 && denom % i == 0) {
				numfinal /= i;
				denomfinal /= i;
				break;
			}
		}

		int resWhole = resnum / denom;

		if (resWhole < 0) { //makes output -1_-2/3 to -1_2/3
			numfinal = numfinal * -1;
		}

		String result = ((resnum / denom) + "_" + (numfinal) + "/" + denomfinal);

		if (resWhole == 0) { //makes output 0_1/4 to 1/4
			result = numfinal + "/" + denomfinal;
		}
		if (numfinal == 0) { //makes output 1_0/2 to 1
			result = resWhole + "";
		}

		return result;
	}

	public static String divideFrac(int whole1, int num1, int denom1, int whole2, int num2, int denom2) { //method for dividing fracs

		int resnum1 = 0, resnum2 = 0;

		if (whole1 < 0) { //can now handle negatives with the first fraction/whole num.
			resnum1 = (whole1 * denom1) - num1;
		} else if (whole1 >= 0) { //can now handle negatives with the second fraction/whole num.
			resnum1 = ((whole1 * denom1) + num1);
		}
		if (whole2 < 0) {
			resnum2 = (whole2 * denom2) - num2;
		} else if (whole2 >= 0) {
			resnum2 = ((whole2 * denom2) + num2);
		}

		int resnum = resnum1 * denom2; //finding the final numerator
		int denom = denom1 * resnum2; //finding the final denominator

		int numfinal = resnum % denom;
		int denomfinal = denom;

		for (int i = denom / 2; i > 0; i--) { //reduces the output
			if (numfinal % i == 0 && denom % i == 0) {
				numfinal /= i;
				denomfinal /= i;
				break;
			}
		}

		int resWhole = resnum / denom;

		if (resWhole < 0) { //makes output -1_-2/3 to -1_2/3
			denomfinal = denomfinal * -1;
		}

		String result = ((resnum / denom) + "_" + Math.abs(numfinal) + "/" + Math.abs(denomfinal));

		if (resWhole == 0) { //makes output 0_1/4 to 1/4
			result = numfinal + "/" + denomfinal;
		}
		if (numfinal == 0) { //makes output 1_0/2 to 1
			result = resWhole + "";
		}

		return result;
	}
}
