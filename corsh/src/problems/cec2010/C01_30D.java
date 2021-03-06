package problems.cec2010;

import java.util.Vector;

import problems.AbstractProblem;

public class C01_30D extends AbstractProblem {
	private double[] o = new double[]{0.030858718087483,	-0.078632292353156, 0.048651146638038,	-0.069089831066354,	-0.087918542941928,	0.088982639811141, 0.074143235639847,	-0.086527593580149,	-0.020616531903907,	0.055586106499231, 0.059285954883598,	-0.040671485554685,	-0.087399911887693,	-0.01842585125741, -0.005184912793062,	-0.039892037937026, 0.036509229387458,	0.026046414854433, -0.067133862936029,	0.082780189144943,	-0.049336722577062,	0.018503188080959, 0.051610619131255, 0.018613117768432, 0.093448598181657,	-0.071208840780873,	-0.036535677894572,	-0.03126128526933, 0.099243805247963,	0.053872445945574};
	private static int dimension = 30;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	
    public Double fitness(Vector<Double> x) {
        double[] z;
		double f1, f2, f3, f4;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	    

		//Function  
	    f1 = 0.0;
		f2 = 1.0;
		f3 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			f1 = f1 + Math.pow(Math.cos(z[i]), 4);
			f2 = f2 * Math.cos(z[i]) * Math.cos(z[i]); 
			f3 = f3 + ((z[i] * z[i]) * (double) (i+1));
		}

		f4 = Math.abs((f1 - 2 * f2) / Math.sqrt (f3));
		f4 = 0 - f4;

		return f4;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g1, g2;

		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	    
	 
		//Constraints  
	    g1 = 1.0;
		g2 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 * z[i];
			g2 = g2 + z[i];
		}

		g1 = 0.75 - g1;
		g2 = g2 - (7.5 * x.size());

		//Mean Violations
		if (g1 < 0) {
			g1 = 0;
		}
		if (g2 < 0) {
			g2 = 0;
		}

		return (g1 + g2)/2;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double g1, g2;

		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	    
	 
		//Constraints  
	    g1 = 1.0;
		g2 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 * z[i];
			g2 = g2 + z[i];
		}

		g1 = 0.75 - g1;
		g2 = g2 - (7.5 * x.size());

		//Mean Violations
		if (g1 < 0) {
			g1 = 0;
		}
		if (g2 < 0) {
			g2 = 0;
		}

		return new double[] {g1, g2};
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
    	return "C01_30D";
    }
}
