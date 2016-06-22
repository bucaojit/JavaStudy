package com.oliver.guitar;

public class FlyingV implements ElectricGuitar{

	@Override
	public void bend() {
		System.out.println("V bend");
		
	}

	@Override
	public void tremoloPedal() {
		System.out.println("Tremolo V");
		
	}

}
