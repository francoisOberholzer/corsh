package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G07 extends AbstractProblem {
	private static int dimension = 10;
	private static double[] domainsMin = new double[]{-10, -10, -10, -10, -10, -10, -10, -10, -10, -10};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	
    public Double fitness(Vector<Double> x) {
    	double f;
    	
    	f = x.get(0) * x.get(0) + x.get(1) * x.get(1) + x.get(0) * x.get(1) - 14.0 * x.get(0) - 16.0 * x.get(1) + (x.get(2) - 10.0) * (x.get(2) - 10.0) + 4.0 * (x.get(3) - 5.0) * (x.get(3) - 5.0) + (x.get(4) - 3.0) * (x.get(4) - 3.0) + 2.0 * (x.get(5) - 1.0) * (x.get(5) - 1.0) + 5.0 * x.get(6) * x.get(6) + 7.0 * (x.get(7) - 11) * (x.get(7) - 11) + 2.0 * (x.get(8) - 10.0) * (x.get(8) - 10.0) + (x.get(9) - 7.0) * (x.get(9) - 7.0) + 45.0;
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6, g7, g8;
    	
    	g1 = -105.0 + 4.0 * x.get(0) + 5.0 * x.get(1) - 3.0 * x.get(6) + 9.0 * x.get(7);
    	g2 = 10.0 * x.get(0) - 8.0 * x.get(1) - 17.0 * x.get(6) + 2.0 * x.get(7);
    	g3 = -8.0 * x.get(0) + 2.0 * x.get(1) + 5.0 * x.get(8) - 2.0 * x.get(9) - 12.0;
    	g4 = 3.0 * (x.get(0) - 2.0) * (x.get(0) - 2.0) + 4.0 * (x.get(1) - 3.0) * (x.get(1) - 3.0) + 2.0 * x.get(2) * x.get(2) - 7.0 * x.get(3) - 120.0;
    	g5 = 5.0 * x.get(0) * x.get(0) + 8.0 * x.get(1) + (x.get(2) - 6.0) * (x.get(2) - 6.0) - 2.0 * x.get(3) - 40.0;
    	g6 = x.get(0) * x.get(0) + 2.0 * (x.get(1) - 2.0) * (x.get(1) - 2.0) - 2.0 * x.get(0) * x.get(1) + 14.0 * x.get(4) - 6.0 * x.get(5);
    	g7 = 0.5 * (x.get(0) - 8.0) * (x.get(0) - 8.0) + 2.0 * (x.get(1) - 4.0) * (x.get(1) - 4.0) + 3.0 * x.get(4) * x.get(4) - x.get(5) - 30.0;
    	g8 = -3.0 * x.get(0) + 6.0 * x.get(1) + 12.0 * (x.get(8) - 8.0) * (x.get(8) - 8.0) - 7.0 * x.get(9);

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

		return (g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8)/8;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6, g7, g8;
    	
    	g1 = -105.0 + 4.0 * x.get(0) + 5.0 * x.get(1) - 3.0 * x.get(6) + 9.0 * x.get(7);
    	g2 = 10.0 * x.get(0) - 8.0 * x.get(1) - 17.0 * x.get(6) + 2.0 * x.get(7);
    	g3 = -8.0 * x.get(0) + 2.0 * x.get(1) + 5.0 * x.get(8) - 2.0 * x.get(9) - 12.0;
    	g4 = 3.0 * (x.get(0) - 2.0) * (x.get(0) - 2.0) + 4.0 * (x.get(1) - 3.0) * (x.get(1) - 3.0) + 2.0 * x.get(2) * x.get(2) - 7.0 * x.get(3) - 120.0;
    	g5 = 5.0 * x.get(0) * x.get(0) + 8.0 * x.get(1) + (x.get(2) - 6.0) * (x.get(2) - 6.0) - 2.0 * x.get(3) - 40.0;
    	g6 = x.get(0) * x.get(0) + 2.0 * (x.get(1) - 2.0) * (x.get(1) - 2.0) - 2.0 * x.get(0) * x.get(1) + 14.0 * x.get(4) - 6.0 * x.get(5);
    	g7 = 0.5 * (x.get(0) - 8.0) * (x.get(0) - 8.0) + 2.0 * (x.get(1) - 4.0) * (x.get(1) - 4.0) + 3.0 * x.get(4) * x.get(4) - x.get(5) - 30.0;
    	g8 = -3.0 * x.get(0) + 6.0 * x.get(1) + 12.0 * (x.get(8) - 8.0) * (x.get(8) - 8.0) - 7.0 * x.get(9);

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

		return new double[] {g1, g2, g3, g4, g5, g6, g7, g8};
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
    	return "G07_10D";
    }
}
