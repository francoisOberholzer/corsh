package problems.cec2010;

import java.util.Vector;

import problems.AbstractProblem;

public class C18_30D extends AbstractProblem {
    private double[] o = new double[]{-2.494401436611803,	-0.306408781638572,	-2.271946840536718,	0.381278325914122,	2.394875929583502,	0.418708663782934,	-2.082663588220074,	0.776060342716238,	-0.374312845903175,	0.352372662321828,	1.172942728375508,	-0.24450210952894,	1.049793874089803,	-1.716285448140795,	-1.026167671845868,	-1.223031642604231,	0.924946651665792,	0.93270056541258,	-2.312880521655027,	-0.671857644927313,	-0.312276658254605,	-0.973986111708943, -0.454151248193331, 2.420597958989111,	0.050346805172393,	1.050203106200361,	-0.05420584346617,	-0.081533357726523,	-0.968176219532845,	1.682281307624435};
	private final double e = 0.0001;
	private static int dimension = 30;
	private static double[] domainsMin = new double[]{-50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50, -50};	
	private static double[] domainsMax = new double[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
	
    public Double fitness(Vector<Double> x) {
        double[] z;
		double f;

		//Status
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	

		//Function  
	    f = 0.0;

		for (int i = 0; i < x.size()-1; i++) {
			f = f + Math.pow((z[i] - z[i+1]),2);
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g, h;

		//Status
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    h = 0.0;
		g = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g = g - z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
			h = h + z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		h = h/((double) x.size());
		g = g/((double) x.size());	

		h = Math.abs(h);	

		//Mean Violations
		if (g <= 0) {
			g = 0;
		}
		if ((h - e) <= 0) {
			h = 0;
		}

		return (g + h)/2;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double g, h;

		//Status
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    h = 0.0;
		g = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g = g - z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
			h = h + z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		h = h/((double) x.size());
		g = g/((double) x.size());	

		h = Math.abs(h);	

		//Mean Violations
		if (g <= 0) {
			g = 0;
		}
		if ((h - e) <= 0) {
			h = 0;
		}

		return new double[] {g, h};
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
    	return "C18_30D";
    }
}
