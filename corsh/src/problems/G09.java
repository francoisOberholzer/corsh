package problems;

import java.util.Vector;

//CEC 2006
public class G09 extends AbstractProblem {
	private static int dimension = 7;
	private static double[] domainsMin = new double[]{-10, -10, -10, -10, -10, -10, -10};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10};
	
    public Double f(Vector<Double> x) {
    	double f;
    	
    	f = (x.get(0) - 10.0) * (x.get(0) - 10.0) + 5.0 * (x.get(1) - 12.0) * (x.get(1) - 12.0) + Math.pow(x.get(2), 4) + 3.0 * (x.get(3) - 11.0) * (x.get(3) - 11.0) + 10.0 * Math.pow(x.get(4), 6) + 7.0 * x.get(5) * x.get(5) + Math.pow(x.get(6), 4) - 4.0 * x.get(5) * x.get(6) - 10.0 * x.get(5) - 8.0 * x.get(6);
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, g3, g4;
    	
    	g1 = -127.0 + 2 * x.get(0) * x.get(0) + 3.0 * Math.pow(x.get(1), 4) + x.get(2) + 4.0 * x.get(3) * x.get(3) + 5.0 * x.get(4);
    	g2 = -282.0 + 7.0 * x.get(0) + 3.0 * x.get(1) + 10.0 * x.get(2) * x.get(2) + x.get(3) - x.get(4);
  	  	g3 = -196.0 + 23.0 * x.get(0) + x.get(1) * x.get(1) + 6.0 * x.get(5) * x.get(5) - 8.0 * x.get(6);
  	  	g4 = 4.0 * x.get(0) * x.get(0) + x.get(1) * x.get(1) - 3.0 * x.get(0) * x.get(1) + 2.0 * x.get(2) * x.get(2) + 5.0 * x.get(5) - 11.0 * x.get(6);
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}

		return (g1 + g2 + g3 + g4)/4;
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
