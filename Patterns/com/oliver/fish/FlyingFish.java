package com.oliver.fish;

public class FlyingFish extends FishDecorator {
 
	   public FlyingFish(Fish fish) {
	      super(fish);
	   }

	   @Override
	   public void swim() {
	      fish.swim();
	   }
	   
	   public void fly() {
	      System.out.println("Flying with the birds");
	   }
}
