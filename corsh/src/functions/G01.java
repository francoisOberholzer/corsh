package functions;

import java.util.Vector;

//CEC 2006
public class G01 extends AbstractFunction {
	private static int dimension = 13;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 100, 100, 100, 1};
	
    public Double f(Vector<Double> x) {
		double f;  

		f = 5.0 * (x.get(0) + x.get(1) + x.get(2) + x.get(3)) - 5.0 * (x.get(0) * x.get(0) + x.get(1) * x.get(1) + x.get(2) * x.get(2) + x.get(3) * x.get(3));
		
		for (int i = 4; i < 13; i++) {
		    f = f - x.get(i);
		}
		
		return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6, g7, g8, g9;
    	
    	g1 = 2.0 * x.get(0) + 2.0 * x.get(1) + x.get(9) + x.get(10) - 10.;
    	g2 = 2.0 * x.get(0) + 2.0 * x.get(2) + x.get(9) + x.get(11) - 10.;
    	g3 = 2.0 * x.get(1) + 2.0 * x.get(2) + x.get(10) + x.get(11) - 10.;
    	g4 = -8.0 * x.get(0) + x.get(9);
    	g5 = -8.0 * x.get(1) + x.get(10);
    	g6 = -8.0 * x.get(2) + x.get(11);
    	g7 = -2.0 * x.get(3) - x.get(4) + x.get(9);
    	g8 = -2.0 * x.get(5) - x.get(6) + x.get(10);
    	g9 = -2.0 * x.get(7) - x.get(8) + x.get(11);
    	
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

		return (g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9)/9;
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
