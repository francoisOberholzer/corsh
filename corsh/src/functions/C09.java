package functions;

import java.util.Vector;

public class C09 extends AbstractFunction {
    private double[] o = new double[]{-41.03250252873486,	-35.70280591875908,	-48.66938576680659,	94.51946988004894,	31.68700466174738,	99.69508270219342,	30.778279925351967,	-31.041222172110807,	-46.21010370947247,	27.26190010072706,	-2.093622677920422,	22.246274570582585,	-42.887366421312436,	89.88377145577851,	-6.731523713182725,	97.86439204258224,	49.49993772881544,	23.210695390854696,	-81.36716857155828,	-20.15688556597543,	36.692155371634726,	44.37408948075327,	-15.984549833405907,	-49.68391424581281,	98.3715576810595,	0.127593155843627,	61.709914317965655,	-84.0189999580673,	-35.39565398431638,	-5.143979333218638};
	private final double e = 0.0001;
	private static int dimension = -1;
	private static double[] domainsMin = new double[]{-500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500, -500};	
	private static double[] domainsMax = new double[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};

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
		double h;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		     z[i] = (double) x.get(i) - o[i];
		}
		   
		//Constraints  
	    h = 0.0;

		for (int i = 0; i < x.size(); i++) {
			h = h + z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		h = Math.abs(h);

		//Mean Violations
		if ((h - e) <= 0) {
			h = 0;
		}

		return h;
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
