package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G08 extends AbstractProblem {
	private static int dimension = 2;
	private static double[] domainsMin = new double[]{0, 0};	
	private static double[] domainsMax = new double[]{10, 10};
	
    public Double fitness(Vector<Double> x) {
    	double f;

    	f = Math.pow(Math.sin(2 * Math.PI * x.get(0)), 3) * Math.sin(2 * Math.PI * x.get(1)) / (Math.pow(x.get(0), 3) * (x.get(0) + x.get(1)));
    	f = -f;
    	   
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2;
    	
    	g1 = x.get(0) * x.get(0) - x.get(1) + 1.0;
 	    g2 = 1.0 - x.get(0) + (x.get(1) - 4.0) * (x.get(1) - 4.0);
    	
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
    	
    	g1 = x.get(0) * x.get(0) - x.get(1) + 1.0;
 	    g2 = 1.0 - x.get(0) + (x.get(1) - 4.0) * (x.get(1) - 4.0);
    	
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
    	return "G08_2D";
    }
}
