package generics;

public class UpperBound {
	// Have the method be generic
	// Use an inner class that 'extends' something
	
	private Integer number = 123;
	public <J extends UpperBound> Integer practice(J j) {
		return j.getNumber();
	}
	
	public Integer getNumber() {
		return number;
	}
	
	
	
	public static void main(String[] str) {
		UpperBound upperbound = new UpperBound();
		AnotherBound anotherbound = new AnotherBound();
		
		System.out.println(upperbound.practice(upperbound));
		
		System.out.println(upperbound.practice(anotherbound));
		
	}
}
