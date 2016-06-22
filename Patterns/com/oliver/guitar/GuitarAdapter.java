package com.oliver.guitar;

public class GuitarAdapter implements ElectricGuitar{

	ElectricGuitar electricGuitar;
	//String guitarType;
	
	public GuitarAdapter(String guitarType) {
		if(guitarType.equalsIgnoreCase("flyingv")) {
		   electricGuitar = new FlyingV();
		   //guitarType = "flyingv";
		}
		else if(guitarType.equalsIgnoreCase("myelectric")){
			electricGuitar = new MyElectricGuitar();
			//guitarType = "myelectric";
		}
		 
	}
	/*
	@Override
	public void twang(String type) {
		if("flyingv".equalsIgnoreCase(type)) {
			electricGuitar.bend();
		}
		else if("myelectric".equalsIgnoreCase(type)) {
			electricGuitar.tremoloPedal();
		}
		
	}
	*/

	@Override
	public void bend() {
		electricGuitar.bend();
		
	}

	@Override
	public void tremoloPedal() {
		electricGuitar.tremoloPedal();
		
	}

}
