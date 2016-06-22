package com.oliver.fish;

public class FishTester {
	public static void main(String[] args) {
		Barracuda bc = new Barracuda();
		bc.swim();
		
		// FlyingFish added a decorator to the Fish
		FlyingFish ff = new FlyingFish(bc);
		
		ff.swim();
		ff.fly();
		System.out.println("----");
		FishTester.doSwim(ff);
	}
	
	public static void doSwim(Fish f) {
		f.swim();
	}
}
