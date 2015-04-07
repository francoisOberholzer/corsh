package problems;

import java.util.Vector;

//CEC 2006
public class G18 extends AbstractProblem {
	private static int dimension = 9;
	private static double[] domainsMin = new double[]{-10, -10, -10, -10, -10, -10, -10, -10, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 20};
	
    public Double f(Vector<Double> x) {
    	double f;
		
    	f = 0.5 * (x.get(0) * x.get(3) - x.get(1) * x.get(2) + x.get(2) * x.get(8) - x.get(4) * x.get(8) + x.get(4) * x.get(7) - x.get(5) * x.get(6));
		f = -f;
		  
		return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13;
    	
    	g1 = -1.0 + Math.pow(x.get(2), 2.0) + Math.pow(x.get(3), 2.0);
   	    g2 = -1.0 + Math.pow(x.get(8), 2.0);
   	    g3 = -1.0 + Math.pow(x.get(4), 2.0) + Math.pow(x.get(5), 2.0);
   	    g4 = -1.0 + Math.pow(x.get(0), 2.0) + Math.pow(x.get(1) - x.get(8), 2.0);
   	    g5 = -1.0 + Math.pow(x.get(0) - x.get(4), 2.0) + Math.pow(x.get(1) - x.get(5), 2.0);
   	    g6 = -1.0 + Math.pow(x.get(0) - x.get(6), 2.0) + Math.pow(x.get(1) - x.get(7), 2.0);
   	    g7 = -1.0 + Math.pow(x.get(2) - x.get(4), 2.0) + Math.pow(x.get(3) - x.get(5), 2.0);
   	    g8 = -1.0 + Math.pow(x.get(2) - x.get(6), 2.0) + Math.pow(x.get(3) - x.get(7), 2.0);
   	    g9 = -1.0 + Math.pow(x.get(6), 2.0) + Math.pow (x.get(7) - x.get(8), 2.0);
   	    g10 = -x.get(0) * x.get(3) + x.get(1) * x.get(2);
   	    g11 = -x.get(2) * x.get(8);
   	    g12 = x.get(4) * x.get(8);
   	    g13 = -x.get(4) * x.get(7) + x.get(5) * x.get(6);
    	
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
		if (g7 <= 0) {
			g7 = 0;
		}
		if (g8 <= 0) {
			g8 = 0;
		}
		if (g9 <= 0) {
			g9 = 0;
		}
		if (g10 <= 0) {
			g10 = 0;
		}
		if (g11 <= 0) {
			g11 = 0;
		}
		if (g12 <= 0) {
			g12 = 0;
		}
		if (g13 <= 0) {
			g13 = 0;
		}

		return (g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9 + g10 + g11 + g12 + g13)/13;
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
