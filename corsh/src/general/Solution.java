package general;

import java.util.Arrays;
import java.util.Vector;

//To be returned by all algorithms, a list of these are sent to Print by Simulation
public class Solution {
	private double fitness;
	private double violation;
	private Vector<Double> position;
	private double miscellaneous;
	
	public Solution(double fit, double vio, Vector<Double> pos) { //For use by constrained
		fitness = fit;
		violation = vio;
		position = pos;
		miscellaneous = 0.0;
	}
	
	public Solution(double fit, Vector<Double> pos) { //For use by unconstrained
		fitness = fit;
		violation = 0.0;
		position = pos;
		miscellaneous = 0.0;
	}
	
	public Solution(double misc) { //For use by metrics
		fitness = 0.0;
		violation = 0.0;
		position = new Vector<Double>(Arrays.asList(0.0));
		miscellaneous = misc;
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
	
	public double getMiscellaneous() {
		return miscellaneous;
	}
}
