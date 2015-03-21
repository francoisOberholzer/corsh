package functions;

import java.util.Vector;

//CEC 2006
public class G04 extends AbstractFunction {
	private static int dimension = 5;
	private static double[] domainsMin = new double[]{78, 33, 27, 27, 27};	
	private static double[] domainsMax = new double[]{102, 45, 45, 45, 45};
	
    public Double f(Vector<Double> x) {
    	double f;
    	
    	f = 5.3578547 * x.get(2) * x.get(2) + 0.8356891 * x.get(0) * x.get(4) + 37.293239 * x.get(0) - 40792.141;
    		
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2, g3, g4, g5, g6;
    	
    	g1 = 85.334407 + 0.0056858 * x.get(1) * x.get(4) + 0.0006262 * x.get(0) * x.get(3) - 0.0022053 * x.get(2) * x.get(4) - 92.;
    	g2 = -85.334407 - 0.0056858 * x.get(1) * x.get(4) - 0.0006262 * x.get(0) * x.get(3) + 0.0022053 * x.get(2) * x.get(4);
    	g3 = 80.51249 + 0.0071317 * x.get(1) * x.get(4) + 0.0029955 * x.get(0) * x.get(1) + 0.0021813 * x.get(2) * x.get(2) - 110.;
    	g4 = -80.51249 - 0.0071317 * x.get(1) * x.get(4) - 0.0029955 * x.get(0) * x.get(1) - 0.0021813 * x.get(2) * x.get(2) + 90.;
  	  	g5 = 9.300961 + 0.0047026 * x.get(2) * x.get(4) + 0.0012547 * x.get(0) * x.get(2) + 0.0019085 * x.get(2) * x.get(3) - 25.;
  	  	g6 = -9.300961 - 0.0047026 * x.get(2) * x.get(4) - 0.0012547 * x.get(0) * x.get(2) - 0.0019085 * x.get(2) * x.get(3) + 20.;
    	
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
