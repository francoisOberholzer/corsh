package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G23 extends AbstractProblem {
	private static int dimension = 9;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0.01};	
	private static double[] domainsMax = new double[]{300, 300, 100, 200, 100, 300, 100, 200, 0.03};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
    	  double f;
    	
    	  f = -9.0 * x.get(4) - 15.0 * x.get(7) + 6.0 * x.get(0) + 16.0 * x.get(1) + 10.0 * (x.get(5) + x.get(6));
    	  
    	  return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, h1, h2, h3, h4;
    	
    	g1 = x.get(8) * x.get(2) + 0.02 * x.get(5) - 0.025 * x.get(4);
  	    g2 = x.get(8) * x.get(3) + 0.02 * x.get(6) - 0.015 * x.get(7);
  	    h1 = x.get(0) + x.get(1) - x.get(2) - x.get(3);
  	    h2 = 0.03 * x.get(0) + 0.01 * x.get(1) - x.get(8) * (x.get(2) + x.get(3));
  	    h3 = x.get(2) + x.get(5) - x.get(4);
  	    h4 = x.get(3) + x.get(6) - x.get(7);
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}
		if ((h3 - e) <= 0) {
			h3 = 0;
		}
		if ((h4 - e) <= 0) {
			h4 = 0;
		}

		return (g1 + g2 + h1 + h2 + h3 + h4)/6;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g1, g2, h1, h2, h3, h4;
    	
    	g1 = x.get(8) * x.get(2) + 0.02 * x.get(5) - 0.025 * x.get(4);
  	    g2 = x.get(8) * x.get(3) + 0.02 * x.get(6) - 0.015 * x.get(7);
  	    h1 = x.get(0) + x.get(1) - x.get(2) - x.get(3);
  	    h2 = 0.03 * x.get(0) + 0.01 * x.get(1) - x.get(8) * (x.get(2) + x.get(3));
  	    h3 = x.get(2) + x.get(5) - x.get(4);
  	    h4 = x.get(3) + x.get(6) - x.get(7);
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}
		if ((h3 - e) <= 0) {
			h3 = 0;
		}
		if ((h4 - e) <= 0) {
			h4 = 0;
		}

		return new double[] {g1, g2, h1, h2, h3, h4};
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
    	return "G23_9D";
    }
}
