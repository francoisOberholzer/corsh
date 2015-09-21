package problems.cec2010;

import java.util.Vector;

import problems.AbstractProblem;

public class C04_30D extends AbstractProblem {
    private double[] o = new double[]{0.820202353727904, 5.260154140335203,	-1.694610371739177,	-5.589298730330406,	-0.141736605495543,	9.454675508078164,	8.795744608532939,	9.687346331423548,	-3.246522827444976,	6.647399971577617,	1.434490229836026,	-0.506531215086801,	0.558594225280784,	7.919942423520642,	1.383716002673571,	-1.520153615528276,	-2.266737465474915,	6.48052999726508,	-8.893207968949003,	-3.528743044935322,	6.063486037065154,	-4.51585211274229,	7.320477892009357,	-8.990263774675665,	9.446412007392851,	-6.41068985463494,	-9.135251626491991,	2.07763837492787,	8.051026378030816,	-1.002691032064544};
	private final double e = 0.0001;
	private static int dimension = 30;
	private static double[] domainsMin = new double[]{-50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50};	
	private static double[] domainsMax = new double[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

    public Double fitness(Vector<Double> x) {
        double[] z;
		double f;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		 
		//Function   
	    f = z[0];

		for (int i = 0; i < x.size(); i++) {
			if (z[i] > f) {
				f = z[i];
			}
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double h1, h2, h3, h4;
		
		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		 
		//Constraints   
		h1 = 0.0;
		h2 = 0.0;
		h3 = 0.0;
		h4 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			h1 = h1 + z[i] * Math.cos(Math.sqrt(Math.abs(z[i])));
			h4 = h4 + z[i];
		}

		for (int i = 0; i < (x.size()/2 - 1); i++) {
			h2 = h2 +  Math.pow((z[i] - z[i+1]),2);
		}

	    for (int i = x.size()/2; i < (x.size() - 1); i++) {
			h3 = h3 +  Math.pow((z[i] * z[i] - z[i+1]),2);
		}

		h1 = h1/x.size();
		h1 = Math.abs(h1);
		h2 = Math.abs(h2);
		h3 = Math.abs(h3);
		h4 = Math.abs(h4);

		//Mean Violations
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

		return (h1 + h2 + h3 + h4)/4;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double h1, h2, h3, h4;
		
		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		 
		//Constraints   
		h1 = 0.0;
		h2 = 0.0;
		h3 = 0.0;
		h4 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			h1 = h1 + z[i] * Math.cos(Math.sqrt(Math.abs(z[i])));
			h4 = h4 + z[i];
		}

		for (int i = 0; i < (x.size()/2 - 1); i++) {
			h2 = h2 +  Math.pow((z[i] - z[i+1]),2);
		}

	    for (int i = x.size()/2; i < (x.size() - 1); i++) {
			h3 = h3 +  Math.pow((z[i] * z[i] - z[i+1]),2);
		}

		h1 = h1/x.size();
		h1 = Math.abs(h1);
		h2 = Math.abs(h2);
		h3 = Math.abs(h3);
		h4 = Math.abs(h4);

		//Mean Violations
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

		return new double[] {h1, h2, h3, h4};
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
    	return "C04_30D";
    }
}
