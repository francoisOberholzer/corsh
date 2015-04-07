package problems;

import java.util.Vector;

//CEC 2006
public class G02 extends AbstractProblem {
	private static int dimension = 20;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	
    public Double f(Vector<Double> x) {
    	 double f1, f2, f3, f;

    	 f1 = 0.0;
    	 f2 = 1.0;
		 f3 = 0.0;
		 
		 for (int i = 0; i < dimension; i++)
		 {
			 f1 = f1 + Math.pow(Math.cos(x.get(i)), 4);
		     f2 = f2 * Math.cos(x.get(i)) * Math.cos(x.get(i));
		     f3 = f3 + ((double) (i + 1)) * x.get(i) * x.get(i);
		 }
		 f = Math.abs((f1 - (2 * f2)) / Math.sqrt(f3));
		 f = -f;
		 
		 return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2;
    	g1 = 1.0;
		g2 = 0.0;
    	
    	for(int i = 0; i < dimension; i++)
		{
    		g1 = g1 * x.get(i);
		    g2 = g2 + x.get(i);
		}
    	
    	g1 = 0.75 - g1;
    	g2 = g2 - 7.5 * ((double) dimension);
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
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
