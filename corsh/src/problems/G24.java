package problems;

import java.util.Vector;

//CEC 2006
public class G24 extends AbstractProblem {
	private static int dimension = 2;
	private static double[] domainsMin = new double[]{0, 0};	
	private static double[] domainsMax = new double[]{3, 4};
	
    public Double f(Vector<Double> x) {
    	double f;
    	
    	f = -x.get(0) - x.get(1); 
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2;
    	
    	g1 = -2.0 * Math.pow (x.get(0), 4.0) + 8.0 * Math.pow (x.get(0), 3.0) - 8.0 * Math.pow (x.get(0), 2.0) + x.get(1) - 2.0;
   	  	g2 = -4.0 * Math.pow (x.get(0), 4.0) + 32.0 * Math.pow (x.get(0), 3.0) - 88.0 * Math.pow (x.get(0), 2.0) + 96.0 * x.get(0) + x.get(1) - 36.0;
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}

		return (g1 + g2)/2;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g1, g2;
    	
    	g1 = -2.0 * Math.pow (x.get(0), 4.0) + 8.0 * Math.pow (x.get(0), 3.0) - 8.0 * Math.pow (x.get(0), 2.0) + x.get(1) - 2.0;
   	  	g2 = -4.0 * Math.pow (x.get(0), 4.0) + 32.0 * Math.pow (x.get(0), 3.0) - 88.0 * Math.pow (x.get(0), 2.0) + 96.0 * x.get(0) + x.get(1) - 36.0;
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}

		return new double[] {g1, g2};
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
    	return "G24_2D";
    }
}
