package functions;

import java.util.Vector;

//CEC 2006
public class G03 extends AbstractFunction {
	private static int dimension = 10;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	private final double e = 0.0001;
	
    public Double f(Vector<Double> x) {
    	double f1, f2 = Math.sqrt((double) dimension), f;

    	f1 = 1.0;
    	
    	for(int i = 0; i < dimension; i++)
    	{
    		f1 = f2 * f1 * x.get(i);
    	}
    	
    	f = -f1;
    	 
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double h, h1;
    	
    	h1 = 0.0;
    	
    	for(int i = 0; i < dimension; i++)
    	{
    	    h1 = h1 + x.get(i) * x.get(i);
    	}
    	
    	h = h1 - 1.0;

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
