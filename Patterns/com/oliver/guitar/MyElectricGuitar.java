package com.oliver.guitar;

public class MyElectricGuitar implements ElectricGuitar{

	@Override
	public void bend() {
		System.out.println("Guitar Bend");
		
	}

	@Override
	public void tremoloPedal() {
		System.out.println("Hit the Tremolo Pedal");
		
	}

}
