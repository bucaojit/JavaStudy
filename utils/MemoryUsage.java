package com.bucaojit.utils;

public class MemoryUsage {
	public final static int MB = 1024*1024;
	public final static boolean SWITCH_MB = true;
	
	public static void memUsage() {
		memUsage(MemoryUsage.SWITCH_MB);
	}
	
	public static void memUsage(boolean mb_option) {
		StringBuilder sb = new StringBuilder("Used Memory: ");
		Runtime runtime = Runtime.getRuntime();
		if(mb_option) {
			sb.append((runtime.totalMemory() - runtime.freeMemory()) / MemoryUsage.MB);
			
		}
		else {
			sb.append((runtime.totalMemory() - runtime.freeMemory()));
		}
		System.out.println(sb.toString());
	}
}
