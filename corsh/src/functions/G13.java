package functions;

import java.util.Vector;

//CEC 2006
public class G13 extends AbstractFunction {
	private static int dimension = 5;
	private static double[] domainsMin = new double[]{-2.3, -2.3, -3.2, -3.2, -3.2};	
	private static double[] domainsMax = new double[]{2.3, 2.3, -3.2, -3.2, -3.2};
	private final double e = 0.0001;
	
    public Double f(Vector<Double> x) {
    	double f;
    	
    	f = Math.exp(x.get(0) * x.get(1) * x.get(2) * x.get(3) * x.get(4));
    	  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double h1, h2, h3;
    	
    	h1 = x.get(0) * x.get(0) + x.get(1) * x.get(1) + x.get(2) * x.get(2) + x.get(3) * x.get(3) + x.get(4) * x.get(4) - 10.0;
    	h2 = x.get(1) * x.get(2) - 5.0 * x.get(3) * x.get(4);
    	h3 = Math.pow(x.get(0), 3) + Math.pow(x.get(1), 3) + 1.0;
    	
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}
		if ((h3 - e) <= 0) {
			h3 = 0;
		}
		
		return (h1 + h2 + h3)/3;
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
