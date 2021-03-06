package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G15 extends AbstractProblem {
	private static int dimension = 3;
	private static double[] domainsMin = new double[]{0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
    	double f;
    	
    	f = 1000.0 - Math.pow(x.get(0), 2.0) - 2.0 * x.get(1) * x.get(1) - x.get(2) * x.get(2) - x.get(0) * x.get(1) - x.get(0) * x.get(2);
    	  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double h1, h2;
    	
    	h1 = Math.pow(x.get(0), 2.0) + Math.pow(x.get(1), 2.0) + Math.pow(x.get(2), 2.0) - 25.0;
  	  	h2 = 8.0 * x.get(0) + 14.0 * x.get(1) + 7.0 * x.get(2) - 56.0;

		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}

		return (h1 + h2)/2;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double h1, h2;
    	
    	h1 = Math.pow(x.get(0), 2.0) + Math.pow(x.get(1), 2.0) + Math.pow(x.get(2), 2.0) - 25.0;
  	  	h2 = 8.0 * x.get(0) + 14.0 * x.get(1) + 7.0 * x.get(2) - 56.0;

		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}

		return new double[] {h1, h2};
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
    	return "G15_3D";
    }
}
