package com.simon.ninjagold;

public class Location {
	private String name;
	private int min;
	private int max;
	
	public Location(String name, int min, int max) {
		this.name = name;
		this.min = min;
		this.max = max;
	}

	public String getName() {
		return name;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	public String getDescription() {
		int left;
		int right;
		if (Math.abs(min) < Math.abs(max)) {
			left = Math.abs(min);
			right = Math.abs(max);
		} else {
			left = Math.abs(max);
			right = Math.abs(min);
		}
		
		String adj = "";
		if (max > 0) {
			adj += "earns";
			if (min < 0) {
				adj += "/";
				left = 0;
			}
		}
		if (min < 0) {
			adj+= "takes";
			if (max > 0) {
				left = 0;
			}
		}
		
		return String.format("(%s %d-%d gold)", adj, left, right);
	}
}
