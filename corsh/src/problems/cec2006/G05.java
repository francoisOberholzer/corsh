package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G05 extends AbstractProblem {
	private static int dimension = 4;
	private static double[] domainsMin = new double[]{0, 0, -0.55, -0.55};	
	private static double[] domainsMax = new double[]{1200, 1200, 0.55, 0.55};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
		double f; 
		
		f = 3.0 * x.get(0) + 0.000001 * Math.pow(x.get(0), 3) + 2.0 * x.get(1) + (0.000002 / 3.0) * Math.pow(x.get(1), 3);
		
		return f;
    }

    public double violation(Vector<Double> x) {
		double g1, g2, h1, h2, h3;
    	
    	g1 = -x.get(3) + x.get(2) - 0.55;
		g2 = -x.get(2) + x.get(3) - 0.55;
		h1 = 1000.0 * Math.sin(-x.get(2) - 0.25) + 1000.0 * Math.sin(-x.get(3) - 0.25) + 894.8 - x.get(0);
		h2 = 1000.0 * Math.sin(x.get(2) - 0.25) + 1000.0 * Math.sin(x.get(2) - x.get(3) - 0.25) + 894.8 - x.get(1);
		h3 = 1000.0 * Math.sin(x.get(3) - 0.25) + 1000.0 * Math.sin(x.get(3) - x.get(2) - 0.25) + 1294.8;
		
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
		
		return (g1 + g2 + h1 + h2 + h3)/5;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double g1, g2, h1, h2, h3;
    	
    	g1 = -x.get(3) + x.get(2) - 0.55;
		g2 = -x.get(2) + x.get(3) - 0.55;
		h1 = 1000.0 * Math.sin(-x.get(2) - 0.25) + 1000.0 * Math.sin(-x.get(3) - 0.25) + 894.8 - x.get(0);
		h2 = 1000.0 * Math.sin(x.get(2) - 0.25) + 1000.0 * Math.sin(x.get(2) - x.get(3) - 0.25) + 894.8 - x.get(1);
		h3 = 1000.0 * Math.sin(x.get(3) - 0.25) + 1000.0 * Math.sin(x.get(3) - x.get(2) - 0.25) + 1294.8;
		
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
		
		return new double[] {g1, g2, h1, h2, h3};
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
    	return "G05_4D";
    }
}
