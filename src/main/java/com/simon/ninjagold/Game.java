package com.simon.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Game {
	private HashMap<String, Location> locations;
	private int gold;
	private Random r;
	final private int debtLine = -10;
	private ArrayList<LogLine> log;
	
	public Game() {
		locations = new HashMap<>();
		locations.put("Farm", new Location("Farm", 10, 20));
		locations.put("Cave", new Location("Cave", 5, 10));
		locations.put("House", new Location("House", 2, 5));
		locations.put("Casino!", new Location("Casino!", -50, 50));
		locations.put("Spa", new Location("Spa", -20, -5));
		
		gold = 0;
		r = new Random();
		log = new ArrayList<>();
	}

	public int getGold() {
		return gold;
	}
	
	public ArrayList<LogLine> getLog() {
		return log;
	}
	
	// boolean = tooMuchDebt
	public boolean play(String name) {
		Location l = locations.get(name);
		int delta = r.nextInt(l.getMax() - l.getMin()) + l.getMin();
		gold += delta;
		
		// Log encounter
		String line = "";
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MMMM dd yyyy h:mm a");
		boolean isPositive = delta > 0 ? true : false;
		if (isPositive) {
			line = String.format("You entered a %s and earned %d gold. (%s)", l.getName(), delta, df.format(d));
		} else {
			line = String.format("You entered a %s and lost %d gold..Ouch. (%s)", l.getName(), -delta, df.format(d));
		}
		log.add(0, (new LogLine(line, isPositive ? "green" : "red")));
		
		if (gold < debtLine) {
			return true;
		} else {
			return false;
		}
	}
	
	public Collection<Location> getLocations() {
		return locations.values();
	}
	

}
