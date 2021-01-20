public class Fraction {
	
	final int denom; // Below ./d
	final int num; // Above n/.
	
	Fraction(int num, int denom) {
		int gcd = greatestCommonDivisor(Math.abs(num), Math.abs(denom));
		this.denom = denom/gcd;
		this.num = num/gcd;
	}
	
	public double toDecimalNotation() {
		double dFrac = num / (double) denom;
		return dFrac;
	}
	
    public String toString() {
		return num + "/" + denom;
	}
	
    public Fraction add(int number) {
		int newNum = num + number * denom;
		Fraction out = new Fraction(newNum, denom);
		return out;
	}
	
	public Fraction add(Fraction addition) {
		int newNum = num * addition.denom + denom * addition.num;
		int newDenom = denom * addition.denom;
		Fraction out = new Fraction(newNum, newDenom);
		return out;
	}
	
	public Fraction subtract(int number) {
		int newNum = num - number * denom;
		Fraction out = new Fraction(newNum, denom);
		return out;
	}
	
	public Fraction subtract(Fraction substracted) {
		int newNum = num * substracted.denom - denom * substracted.num;
		int newDenom = denom * substracted.denom;
		Fraction out = new Fraction(newNum, newDenom);
		return out;
	}
	
	public Fraction multiply(int number) {
		int newNum = number * num;
		Fraction out = new Fraction(newNum, denom);
		return out;
	}
	
	public Fraction multiply(Fraction fraction) {
		int newNum = num * fraction.num;
		int newDenom = denom * fraction.denom;
		Fraction out = new Fraction(newNum, newDenom);
		return out;
	}
	
	public Fraction divide(int number) {
		int newDenom = denom * number;
		Fraction out = new Fraction(num, newDenom);
		return out;
	}
	
	public Fraction divide(Fraction divFrac) {
		/** Dividing by fraction = multiplying by reverse
		**/
		Fraction multfrac = new Fraction(divFrac.denom, divFrac.num);
		return multiply(multfrac);
	}
	
	private int greatestCommonDivisor(int a, int b) {
		/** Find the GCD using Euclid's algorithm
		**/
		int large = (a > b)? a: b;
		int small = (a < b)? a: b;
		int res = large % small;
		while (res > 0) {
			large = small;
			small = res;
			res = large % small;
		}
		int gcd = small;
		return gcd;
	}
}