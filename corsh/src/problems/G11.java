package problems;

import java.util.Vector;

//CEC 2006
public class G11 extends AbstractProblem {
	private static int dimension = 2;
	private static double[] domainsMin = new double[]{-1, -1};	
	private static double[] domainsMax = new double[]{1, 1};
	private final double e = 0.0001;
	
    public Double f(Vector<Double> x) {
    	double f;

    	f = x.get(0) * x.get(0) + (x.get(1) - 1.0) * (x.get(1) - 1.0);
    	  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double h;
    	
    	h = x.get(1) - x.get(0) * x.get(0);

		if ((h - e) <= 0) {
			h = 0;
		}

		return h;
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
