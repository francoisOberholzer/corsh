package problems;

import java.util.Vector;

public class C14_30D extends AbstractProblem {
    private double[] o = new double[]{-31.718907007204272, -39.536680684207184, -46.033718058035944, -42.2004014684422, -28.331307546159135, -38.64403177375364,	-11.313371899853626, -11.717383190039943, -43.345049558717875, -31.46016185891229, -35.57742732758397, -45.49638850141341, -4.177473725277878, -26.974808661067083, -46.30991533784743, -45.997883193212814, -29.479673271045964, -4.336542960830036,	-43.66244285780764,	-22.43896852522004,	-25.89273808052249,	-24.221450510218993, -30.3952886350567, -31.170730638052895, -9.859463575974534,	-16.727846507426452, -44.35226340706524,	-33.10843069426064,	-7.175153678947718,	-4.601421202670486};
    private static int dimension = 30;
    private static double[] domainsMin = new double[]{-1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000};	
	private static double[] domainsMax = new double[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
    
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
		double g1, g2, g3;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	    
		   
		//Constraints  
	    g1 = 0.0;
		g2 = 0.0;
		g3 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 - z[i] * Math.cos(Math.sqrt(Math.abs(z[i])));
			g2 = g2 + z[i] * Math.cos(Math.sqrt(Math.abs(z[i])));
			g3 = g3 + z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		g1 = g1 -((double) x.size());
		g2 = g2 -((double) x.size());
		g3 = g3 - (10 *((double) x.size()));

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}

		return (g1 + g2 + g3)/3;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double g1, g2, g3;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	    
		   
		//Constraints  
	    g1 = 0.0;
		g2 = 0.0;
		g3 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 - z[i] * Math.cos(Math.sqrt(Math.abs(z[i])));
			g2 = g2 + z[i] * Math.cos(Math.sqrt(Math.abs(z[i])));
			g3 = g3 + z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		g1 = g1 -((double) x.size());
		g2 = g2 -((double) x.size());
		g3 = g3 - (10 *((double) x.size()));

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}

		return new double[] {g1, g2, g3};
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
    	return "C14_30D";
    }
}
