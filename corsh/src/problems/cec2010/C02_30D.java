package problems.cec2010;

import java.util.Vector;

import problems.AbstractProblem;

public class C02_30D extends AbstractProblem {
    private double[] o = new double[]{-0.066939099286697,	0.470966419894494,	-0.490528349401176,	-0.312203454689423,	-0.124759576300523,	-0.247823908806285,	-0.448077079941866,	0.326494954650117,	0.493435908752668,	0.061699778818925,	-0.30251101183711,	-0.274045146932175,	-0.432969960330318,	0.062239193145781,	-0.188163731545079,	-0.100709842052095,	-0.333528971180922,	-0.496627672944882,	-0.288650116941944,	0.435648113198148,	-0.348261107144255,	0.456550427329479,	-0.286843419772511,	0.145639015401174,	-0.038656025783381,	0.333291935226012,	-0.293687524888766,	-0.347859473554797,	-0.089300971656411,	0.142027393193559};
	private final double e = 0.0001;
	private static int dimension = 30;
	private static double[] domainsMin = new double[]{-5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12, -5.12};	
	private static double[] domainsMax = new double[]{5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12, 5.12};

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
		double g1, g2, h;
		
		//z = x - o		
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		 
		//Constraints   
	    g1 = 0.0;
		g2 = 0.0;
		h = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 + (z[i] * z[i] - 10 * Math.cos (2 * Math.PI * z[i]) + 10);
			g2 = g2 + (z[i] * z[i] - 10 * Math.cos(2 * Math.PI * z[i]) + 10);
			h = h + ((z[i] - 0.5) * (z[i] - 0.5) - 10 * Math.cos (2 * Math.PI * (z[i] - 0.5)) + 10);
		}

		g1 = 10.0 - g1/x.size();
		g2 = -15.0 + g2/x.size();
		h = -20.0 + h/x.size();
		h = Math.abs(h);
	
		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if ((h - e) <= 0) {
			h = 0;
		}

		return (g1 + g2 + h)/3;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double g1, g2, h;
		
		//z = x - o		
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		 
		//Constraints   
	    g1 = 0.0;
		g2 = 0.0;
		h = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 + (z[i] * z[i] - 10 * Math.cos (2 * Math.PI * z[i]) + 10);
			g2 = g2 + (z[i] * z[i] - 10 * Math.cos(2 * Math.PI * z[i]) + 10);
			h = h + ((z[i] - 0.5) * (z[i] - 0.5) - 10 * Math.cos (2 * Math.PI * (z[i] - 0.5)) + 10);
		}

		g1 = 10.0 - g1/x.size();
		g2 = -15.0 + g2/x.size();
		h = -20.0 + h/x.size();
		h = Math.abs(h);
	
		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if ((h - e) <= 0) {
			h = 0;
		}

		return new double[] {g1, g2, h};
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
    	return "C02_30D";
    }
}
