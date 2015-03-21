package functions;

import java.util.Vector;

//CEC 2006
public class G06 extends AbstractFunction {
	private static int dimension = 2;
	private static double[] domainsMin = new double[]{13, 0};	
	private static double[] domainsMax = new double[]{100, 100};
	
    public Double f(Vector<Double> x) {
    	double f;
    	
    	f = Math.pow((x.get(0) - 10.), 3) + Math.pow((x.get(1) - 20.), 3);
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g1, g2;
    	
    	g1 = 100. - (x.get(0) - 5.) * (x.get(0) - 5.) - (x.get(1) - 5.) * (x.get(1) - 5.0);
  	  	g2 = (x.get(0) - 6.) * (x.get(0) - 6.) + (x.get(1) - 5.) * (x.get(1) - 5.) - 82.81;
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}

		return (g1 + g2)/2;
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
