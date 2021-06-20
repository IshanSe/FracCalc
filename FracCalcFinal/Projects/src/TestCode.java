public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(FracCalc.addFrac(1, 1, 2, 4, 5, 6)); //expressions with mixed fractions/improper fractions
		System.out.println(FracCalc.subFrac(1, 1, 2, 4, 5, 6));
		System.out.println(FracCalc.multiFrac(1, 1, 2, 4, 5, 6));
		System.out.println(FracCalc.divideFrac(1, 1, 2, 4, 5, 6));
		
		System.out.println(FracCalc.addFrac(-1, 1, 2, 4, 5, 6));//expressions with negative fractions
		System.out.println(FracCalc.subFrac(-1, 1, 2, 4, 5, 6));
		System.out.println(FracCalc.multiFrac(-1, 1, 2, 4, 5, 6));
		System.out.println(FracCalc.divideFrac(-1, 1, 2, 4, 5, 6));
		
		System.out.println(FracCalc.addFrac(0, 1, 2, 0, 5, 6)); //expressions with fractions less than 1
		System.out.println(FracCalc.subFrac(0, 1, 2, 0, 5, 6));
		System.out.println(FracCalc.multiFrac(0, 1, 2, 0, 5, 6));
		System.out.println(FracCalc.divideFrac(0, 1, 2, 0, 5, 6));
		
		System.out.println(FracCalc.addFrac(0, 1, 1, 0, 4, 1));//expressions with whole numbers
		System.out.println(FracCalc.subFrac(0, 1, 1, 0, 4, 1));
		System.out.println(FracCalc.multiFrac(0, 1, 1, 0, 4, 1));
		System.out.println(FracCalc.divideFrac(0, 1, 1, 0, 4, 1)); 
	//whole numbers are changed to improper fractions in split method
 




	}

}
