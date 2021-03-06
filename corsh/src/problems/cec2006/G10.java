package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G10 extends AbstractProblem {
	private static int dimension = 8;
	private static double[] domainsMin = new double[]{100, 1000, 1000, 10, 10, 10, 10, 10};	
	private static double[] domainsMax = new double[]{10000, 10000, 10000, 1000, 1000, 1000, 1000, 1000};
	
    public Double fitness(Vector<Double> x) {
    	double f;  
    	
    	f = x.get(0) + x.get(1) + x.get(2);
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6;
    	
    	g1 = -1.0 + 0.0025 * (x.get(3) + x.get(5));
    	g2 = -1.0 + 0.0025 * (x.get(4) + x.get(6) - x.get(3));
    	g3 = -1.0 + 0.01 * (x.get(7) - x.get(4));
  	  	g4 = -x.get(0) * x.get(5) + 833.33252 * x.get(3) + 100.0 * x.get(0) - 83333.333;
  	  	g5 = -x.get(1) * x.get(6) + 1250.0 * x.get(4) + x.get(1) * x.get(3) - 1250.0 * x.get(3);
  	  	g6 = -x.get(2) * x.get(7) + 1250000.0 + x.get(2) * x.get(4) - 2500.0 * x.get(4);
    	
    	//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}
		if (g4 <= 0) {
			g4 = 0;
		}
		if (g5 <= 0) {
			g5 = 0;
		}
		if (g6 <= 0) {
			g6 = 0;
		}
		
		return (g1 + g2 + g3 + g4 + g5 + g6)/6;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6;
    	
    	g1 = -1.0 + 0.0025 * (x.get(3) + x.get(5));
    	g2 = -1.0 + 0.0025 * (x.get(4) + x.get(6) - x.get(3));
    	g3 = -1.0 + 0.01 * (x.get(7) - x.get(4));
  	  	g4 = -x.get(0) * x.get(5) + 833.33252 * x.get(3) + 100.0 * x.get(0) - 83333.333;
  	  	g5 = -x.get(1) * x.get(6) + 1250.0 * x.get(4) + x.get(1) * x.get(3) - 1250.0 * x.get(3);
  	  	g6 = -x.get(2) * x.get(7) + 1250000.0 + x.get(2) * x.get(4) - 2500.0 * x.get(4);
    	
    	//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}
		if (g4 <= 0) {
			g4 = 0;
		}
		if (g5 <= 0) {
			g5 = 0;
		}
		if (g6 <= 0) {
			g6 = 0;
		}
		
		return new double[] {g1, g2, g3, g4, g5, g6};
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
    	return "G10_8D";
    }
}
