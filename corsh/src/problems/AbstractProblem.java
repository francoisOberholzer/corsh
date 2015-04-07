package problems;

import java.util.Vector;

public class AbstractProblem {
	public Double f(Vector<Double> x) { return null; }
 	public double violation(Vector<Double> x) { return 0; }
    public int getDimension() { return 0; }
    public double[] getDomainsMin() { return null; }
    public double[] getDomainsMax() { return null; }
}
