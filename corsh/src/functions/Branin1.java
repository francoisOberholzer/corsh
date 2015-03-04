package functions;

import java.util.Vector;

public class Branin1 extends AbstractFunction {
    public Double f(Vector<Double> x) {
		return 0.0;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g1, g2;

		//z = x - o
		z = new double[x.size()];	
		z[0] = (double) x.get(0) - 5;
		z[0] = (double) x.get(1);
	 
		//Constraints  
	    g1 = Math.pow((z[1] - ((5.1*z[0]*z[0])/39.4784176) + (z[0]*1.591549431) - 6), 2) + (9.602112642*Math.cos(z[0])) + 9;
		g2 = z[1] + ((z[0]-12)/1.2);

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
