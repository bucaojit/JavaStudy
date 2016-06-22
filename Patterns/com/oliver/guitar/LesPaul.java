package com.oliver.guitar;

public class LesPaul implements Guitar{
	GuitarAdapter guitarAdapter;
	
	@Override
	public void twang(String type) {
		if(type.equalsIgnoreCase("lespaul")) {
			System.out.println("LesPaul has tone");
		}
		else if(type.equalsIgnoreCase("flyingv")) {
			guitarAdapter = new GuitarAdapter("flyingv");
			guitarAdapter.bend();
		}
		else if(type.equalsIgnoreCase("myelectric"))
		{
			guitarAdapter = new GuitarAdapter("myelectric");
			guitarAdapter.tremoloPedal();
		}
	}

}
