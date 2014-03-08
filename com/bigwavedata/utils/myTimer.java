package com.bigwavedata.utils;

// methods to create a timer, start and stop with output on stop
public class myTimer {
	static long beginTime;
	// static methods will keep it simple, start/stop
	public static void beginTime() {
		beginTime = System.nanoTime();		
	}
	public static void endTime() {
		if(beginTime == 0)  {
			System.out.println("WARN: Get begin time first");
		}
		long elapsedTime = System.nanoTime() - beginTime;
		double seconds = (double) elapsedTime / 1000000000.0;
		System.out.println("Elapsed Time: " + seconds);
		System.out.flush();
	}
}

/*
// Timer examples
class SayHello extends TimerTask {
public void run() {
   System.out.println("Hello World!"); 
}
}

// And From your main() method or any other method
Timer timer = new Timer();
timer.schedule(new SayHello(), 5000);
*/