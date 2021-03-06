package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G11 extends AbstractProblem {
	private static int dimension = 2;
	private static double[] domainsMin = new double[]{-1, -1};	
	private static double[] domainsMax = new double[]{1, 1};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
    	double f;

    	f = x.get(0) * x.get(0) + (x.get(1) - 1.0) * (x.get(1) - 1.0);
    	  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double h;
    	
    	h = x.get(1) - (x.get(0) * x.get(0));

		if ((h - e) <= 0) {
			h = 0;
		}

		return h;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double h;
    	
    	h = x.get(1) - (x.get(0) * x.get(0));

		if ((h - e) <= 0) {
			h = 0;
		}

		return new double[] {h};
    }
    
    public int getDimension() {
    	return dimension;
    }
    
    public double[] getDomainsMin() {
    	return domainsMin;
    }
    
    public double[] getDomainsMax() {
    	return domainsMax;
    }
    
    public String getName() { 
    	return "G11_2D";
    }
}
