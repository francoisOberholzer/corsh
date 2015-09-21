package problems;

import java.util.Vector;

public class AbstractProblem {
	public Double fitness(Vector<Double> x) { return null; }
 	public double violation(Vector<Double> x) { return 0; }
 	public double[] violationArray(Vector<Double> x) { return null; }
    public int getDimension() { return 0; }
    public double[] getDomainsMin() { return null; }
    public double[] getDomainsMax() { return null; }
    public String getName() { return "";}
}