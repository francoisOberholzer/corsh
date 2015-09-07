package problems;

import java.util.Vector;

public class C07_30D extends AbstractProblem {
    private double[] o = new double[]{-1.46823271282738,	47.51401860909492,	-30.421056514069576,	-7.707941671844303,	-21.74698421666629,	-17.88116387879569,	5.274442455807971,	18.71403753778708,	-36.959734507345146,	-20.72950462154263,	25.4701966548936,	-25.439992885801573,	1.054563129830697,	-31.556579857545657,	-19.320382777005047,	17.16774285348282,	34.66536814401755,	-31.803705714749462,	-12.926898387712775,	25.489686517508602,	-45.23000430753644,	36.31774710581284,	-18.38690515559357,	34.86816378160691,	-37.530671214167334,	19.288852618585977,	0.684612418754519,	-12.636795982748637,	15.005454148879409,	-40.468678588994315};
    private static int dimension = 30;
	private static double[] domainsMin = new double[]{-140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140, -140};	
	private static double[] domainsMax = new double[]{140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140};
    
    public Double f(Vector<Double> x) {
        double[] z;
		double f;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	

		//Function  
	    f = 0.0;

		for (int i = 0; i < x.size()-1; i++) {
			f = f + (100 * Math.pow(((z[i]+1) * (z[i]+1) - (z[i+1]+1)),2) + Math.pow(((z[i]+1) - 1),2));
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g1 = 0, g2 = 0;

		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    g1 = 0.0;
		g2 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 + z[i] * z[i];
			g2 = g2 + Math.cos(0.1 * z[i]);
		}

		g1 = 0.5 - Math.exp( -0.1 * Math.sqrt(1/((double) x.size()) * g1)) -3 * Math.exp(1/((double) x.size()) * g2) + Math.exp(1);

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}

		return g1;
	}
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double g1 = 0, g2 = 0;

		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    g1 = 0.0;
		g2 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 + z[i] * z[i];
			g2 = g2 + Math.cos(0.1 * z[i]);
		}

		g1 = 0.5 - Math.exp( -0.1 * Math.sqrt(1/((double) x.size()) * g1)) -3 * Math.exp(1/((double) x.size()) * g2) + Math.exp(1);

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}

		return new double[] {g1};
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
    	return "C07_30D";
    }
}
