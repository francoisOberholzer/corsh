package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G22 extends AbstractProblem {
	private static int dimension = 22;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 100, 100, 100.01, 100, 100, 0, 0, 0, 0.01, 0.01, -4.7, -4.7, -4.7, -4.7, -4.7};	
	private static double[] domainsMax = new double[]{20000, 1000000, 1000000, 1000000, 40000000, 40000000, 40000000, 299.99, 399.99, 300, 400, 600, 500, 500, 500, 300, 400, 6.25, 6.25, 6.25, 6.25, 6.25};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
		double f;

    	f = x.get(0);
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1;
    	double h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19;
    	
    	g1 = -x.get(0) + Math.pow (x.get(1), 0.6) + Math.pow (x.get(2), 0.6) + Math.pow (x.get(3), 0.6);
	   	h1 = x.get(4) - 100000.0 * x.get(7) + 10000000.0;
	   	h2 = x.get(5) + 100000.0 * x.get(7) - 100000.0 * x.get(8);
	   	h3 = x.get(6) + 100000.0 * x.get(8) - 50000000.0;
	   	h4 = x.get(4) + 100000.0 * x.get(9) - 33000000.0;
	   	h5 = x.get(5) + 100000 * x.get(10) - 44000000.0;
	    h6 = x.get(6) + 100000 * x.get(11) - 66000000.0;
	   	h7 = x.get(4) - 120.0 * x.get(1) * x.get(12);
	   	h8 = x.get(5) - 80.0 * x.get(2) * x.get(13);
	   	h9 = x.get(6) - 40.0 * x.get(3) * x.get(14);
	   	h10 = x.get(7) - x.get(10) + x.get(15);
	   	h11 = x.get(8) - x.get(11) + x.get(16);
	   	h12 = -x.get(17) + Math.log (x.get(9) - 100.0);
	   	h13 = -x.get(18) + Math.log (-x.get(7) + 300.0);
	   	h14 = -x.get(19) + Math.log (x.get(15));
	   	h15 = -x.get(20) + Math.log (-x.get(8) + 400.0);
	   	h16 = -x.get(21) + Math.log (x.get(16));
	   	h17 = -x.get(7) - x.get(9) + x.get(12) * x.get(17) - x.get(12) * x.get(18) + 400.0;
	   	h18 = x.get(7) - x.get(8) - x.get(10) + x.get(13) * x.get(19) - x.get(13) * x.get(20) + 400.0;
	   	h19 = x.get(8) - x.get(11) - 4.60517 * x.get(14) + x.get(14) * x.get(21) + 100.0;
    	
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
		if ((h6 - e) <= 0) {
			h6 = 0;
		}
		if ((h7 - e) <= 0) {
			h7 = 0;
		}
		if ((h8 - e) <= 0) {
			h8 = 0;
		}
		if ((h9 - e) <= 0) {
			h9 = 0;
		}
		if ((h10 - e) <= 0) {
			h10 = 0;
		}
		if ((h11 - e) <= 0) {
			h11 = 0;
		}
		if ((h12 - e) <= 0) {
			h12 = 0;
		}
		if ((h13 - e) <= 0) {
			h13 = 0;
		}
		if ((h14 - e) <= 0) {
			h14 = 0;
		}
		if ((h15 - e) <= 0) {
			h15 = 0;
		}
		if ((h16 - e) <= 0) {
			h16 = 0;
		}
		if ((h17 - e) <= 0) {
			h17 = 0;
		}
		if ((h18 - e) <= 0) {
			h18 = 0;
		}
		if ((h19 - e) <= 0) {
			h19 = 0;
		}
		
		return (g1 + h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8 + h9 + h10 + h11 + h12 + h13 + h14 + h15 + h16 + h17 + h18 + h19)/20;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g1;
    	double h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19;
    	
    	g1 = -x.get(0) + Math.pow (x.get(1), 0.6) + Math.pow (x.get(2), 0.6) + Math.pow (x.get(3), 0.6);
	   	h1 = x.get(4) - 100000.0 * x.get(7) + 10000000.0;
	   	h2 = x.get(5) + 100000.0 * x.get(7) - 100000.0 * x.get(8);
	   	h3 = x.get(6) + 100000.0 * x.get(8) - 50000000.0;
	   	h4 = x.get(4) + 100000.0 * x.get(9) - 33000000.0;
	   	h5 = x.get(5) + 100000 * x.get(10) - 44000000.0;
	    h6 = x.get(6) + 100000 * x.get(11) - 66000000.0;
	   	h7 = x.get(4) - 120.0 * x.get(1) * x.get(12);
	   	h8 = x.get(5) - 80.0 * x.get(2) * x.get(13);
	   	h9 = x.get(6) - 40.0 * x.get(3) * x.get(14);
	   	h10 = x.get(7) - x.get(10) + x.get(15);
	   	h11 = x.get(8) - x.get(11) + x.get(16);
	   	h12 = -x.get(17) + Math.log (x.get(9) - 100.0);
	   	h13 = -x.get(18) + Math.log (-x.get(7) + 300.0);
	   	h14 = -x.get(19) + Math.log (x.get(15));
	   	h15 = -x.get(20) + Math.log (-x.get(8) + 400.0);
	   	h16 = -x.get(21) + Math.log (x.get(16));
	   	h17 = -x.get(7) - x.get(9) + x.get(12) * x.get(17) - x.get(12) * x.get(18) + 400.0;
	   	h18 = x.get(7) - x.get(8) - x.get(10) + x.get(13) * x.get(19) - x.get(13) * x.get(20) + 400.0;
	   	h19 = x.get(8) - x.get(11) - 4.60517 * x.get(14) + x.get(14) * x.get(21) + 100.0;
    	
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
		if ((h6 - e) <= 0) {
			h6 = 0;
		}
		if ((h7 - e) <= 0) {
			h7 = 0;
		}
		if ((h8 - e) <= 0) {
			h8 = 0;
		}
		if ((h9 - e) <= 0) {
			h9 = 0;
		}
		if ((h10 - e) <= 0) {
			h10 = 0;
		}
		if ((h11 - e) <= 0) {
			h11 = 0;
		}
		if ((h12 - e) <= 0) {
			h12 = 0;
		}
		if ((h13 - e) <= 0) {
			h13 = 0;
		}
		if ((h14 - e) <= 0) {
			h14 = 0;
		}
		if ((h15 - e) <= 0) {
			h15 = 0;
		}
		if ((h16 - e) <= 0) {
			h16 = 0;
		}
		if ((h17 - e) <= 0) {
			h17 = 0;
		}
		if ((h18 - e) <= 0) {
			h18 = 0;
		}
		if ((h19 - e) <= 0) {
			h19 = 0;
		}
		
		return new double[] {g1, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19};
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
    	return "G22_22D";
    }
}
