public class Fractional {
	
	public static void main(String[] args) {
		Fraction myFraction = new Fraction(2, 5);
		
		System.out.println("The fraction is " + myFraction.toString());
		System.out.print("As decimal: ");
		System.out.println(myFraction.toDecimalNotation());
		
		System.out.print("My fraction plus 6 is ");
		System.out.println(myFraction.add(6).toString());
		System.out.print("My fraction plus 6/17 is ");
		Fraction toBeAdded = new Fraction(6, 17);
		System.out.println(myFraction.add(toBeAdded).toString());
		
		System.out.print("My fraction minus 6 is ");
		System.out.println(myFraction.subtract(6).toString());
		System.out.print("My fraction minus 6/17 is ");
		Fraction toBeSubstrd = new Fraction(6, 17);
		System.out.println(myFraction.subtract(toBeSubstrd).toString());

		System.out.print("My fraction times 6 is ");
		System.out.println(myFraction.multiply(6).toString());
		System.out.print("My fraction times 6/17 is ");
		Fraction toBeMultied = new Fraction(6, 17);
		System.out.println(myFraction.multiply(toBeMultied).toString());
		
		System.out.print("My fraction divided by 6 is ");
		System.out.println(myFraction.divide(6).toString());
		System.out.print("My fraction divided by 3/10 is ");
		Fraction toBeDivved = new Fraction(3, 10);
		System.out.println(myFraction.divide(toBeDivved).toString());
	}
}
