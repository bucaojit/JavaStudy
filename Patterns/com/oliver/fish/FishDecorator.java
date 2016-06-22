package com.oliver.fish;

public class FishDecorator implements Fish {
	Fish fish;
	   public FishDecorator(Fish fish) {
	      this.fish = fish;
	   }

	   @Override
	   public void swim() {
	      fish.swim();
	   }
}
