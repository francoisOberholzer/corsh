package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G21 extends AbstractProblem {
	private static int dimension = 7;
	private static double[] domainsMin = new double[]{0, 0, 0, 100, 6.3, 5.9, 4.5};	
	private static double[] domainsMax = new double[]{1000, 40, 40, 300, 6.7, 6.4, 6.25};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
    	double f;

    	f = x.get(0);
    	  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, h1, h2, h3, h4, h5;
    	
    	g1 = -x.get(0) + 35.0 * Math.pow(x.get(1), 0.6) + 35.0 * Math.pow(x.get(2), 0.6);
    	h1 = -300.0 * x.get(2) + 7500 * x.get(4) - 7500 * x.get(5) - 25.0 * x.get(3) * x.get(4) + 25.0 * x.get(3) * x.get(5) + x.get(2) * x.get(3);
    	h2 = 100.0 * x.get(1) + 155.365 * x.get(3) + 2500 * x.get(6) - x.get(1) * x.get(3) - 25.0 * x.get(3) * x.get(6) - 15536.5;
    	h3 = -x.get(4) + Math.log(-x.get(3) + 900.0);
    	h4 = -x.get(5) + Math.log(x.get(3) + 300.0);
    	h5 = -x.get(6) + Math.log(-2.0 * x.get(3) + 700.0);
    	
    	//Mean Violations
		if (g1 <= 0) {
			g1 = 0;  
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
		if ((h5 - e) <= 0) {
			h5 = 0;
		}

		return (g1 + h1 + h2 + h3 + h4 + h5)/6;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g1, h1, h2, h3, h4, h5;
    	
    	g1 = -x.get(0) + 35.0 * Math.pow(x.get(1), 0.6) + 35.0 * Math.pow(x.get(2), 0.6);
    	h1 = -300.0 * x.get(2) + 7500 * x.get(4) - 7500 * x.get(5) - 25.0 * x.get(3) * x.get(4) + 25.0 * x.get(3) * x.get(5) + x.get(2) * x.get(3);
    	h2 = 100.0 * x.get(1) + 155.365 * x.get(3) + 2500 * x.get(6) - x.get(1) * x.get(3) - 25.0 * x.get(3) * x.get(6) - 15536.5;
    	h3 = -x.get(4) + Math.log(-x.get(3) + 900.0);
    	h4 = -x.get(5) + Math.log(x.get(3) + 300.0);
    	h5 = -x.get(6) + Math.log(-2.0 * x.get(3) + 700.0);
    	
    	//Mean Violations
		if (g1 <= 0) {
			g1 = 0;  
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
		if ((h5 - e) <= 0) {
			h5 = 0;
		}

		return new double[] {g1, h1, h2, h3, h4, h5};
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
    	return "G21_7D";
    }
}
