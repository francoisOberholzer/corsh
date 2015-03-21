package functions;

import java.util.Vector;

public class Rastrigin1 extends AbstractFunction {
	private static int dimension = -1;
	private static double[] domainsMin = new double[]{-5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5};
	private static double[] domainsMax = new double[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
	
	public Double f(Vector<Double> x) {
		return 0.0;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g1, g2;

		//z = x - o
		z = new double[x.size()];	
		z[0] = (double) x.get(0);
		z[0] = (double) x.get(1);
	 
		//Constraints  
	    g1 = Math.pow(z[0], 2) + Math.pow(z[1], 2) + 20 - (20 * Math.cos(2 * Math.PI * z[0])) + Math.cos(2 * Math.PI * z[1]);
		g2 = z[1] - (z[0] * z[0] * z[0]);

		//Mean Violations
		if (g1 < 0) {
			g1 = 0;
		}
		if (g2 < 0) {
			g2 = 0;
		}

		return (g1 + g2)/2;
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
}
