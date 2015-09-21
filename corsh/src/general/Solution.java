package general;

import java.util.Vector;

//To be returned by all algorithms, a list of these are sent to Print by Simulation
public class Solution {
	private double fitness;
	private double violation;
	private Vector<Double> position;
	
	public Solution(double fit, double vio, Vector<Double> pos) {
		fitness = fit;
		violation = vio;
		position = pos;
	}
	
	public Solution(double fit, Vector<Double> pos) {
		fitness = fit;
		violation = 0.0;
		position = pos;
	}
	
	public double getFitness() {
		return fitness;
	}
	
	public double getViolation() {
		return violation;
	}
	
	public String getPosition() {
		return position.toString();
	}
}
