package functions;

import java.util.Vector;

public class Schwefel1 extends AbstractFunction {
	public Double f(Vector<Double> x) {
		return 0.0;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g1, g2;

		//z = x - o
		z = new double[x.size()];	
		z[0] = (double) x.get(0);
		z[0] = (double) x.get(1);
	 
		//Constraints  
	    g1 = (z[0]*Math.sin(Math.sqrt(z[0]))) + (z[1]*Math.sin(Math.sqrt(z[1]))) + 125;
		g2 = z[1] - (1/16*z[0]*z[0]) + 150;

		//Mean Violations
		if (g1 < 0) {
			g1 = 0;
		}
		if (g2 < 0) {
			g2 = 0;
		}

		return (g1 + g2)/2;
    }
}
