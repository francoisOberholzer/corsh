package functions;

import java.util.Vector;

public class C16 extends AbstractFunction {
    private double[] o = new double[]{0.365972807627352,	0.429881383400138,	-0.420917679577772,	0.984265986788929,	0.324792771198785,	0.463737106835568,	0.989554882052943,	0.307453878359996,	0.625094764380575,	-0.358589007202526,	0.24624504504104, -0.96149609569083, -0.184146201911073,	-0.030609388103067,	0.13366054512765,	0.450280168292005,	-0.662063233352676,	0.720384516339946,	0.518473305175091,	-0.969074121149791,	-0.221655317677079,	0.327361832246864,	-0.695097713581401,	-0.671724285177815,	-0.534907819936839,	-0.003991036739113,	0.486452090756303,	-0.689962754053575,	-0.138437260109118,	-0.626943354458217};
	private final double e = 0.0001;
	private static int dimension = -1;
	private static double[] domainsMin = new double[]{-10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10, -10};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

    public Double f(Vector<Double> x) {
        double[] z;
		double f1, f2;

		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	

		//Function  
	    f1 = 0.0;
		f2 = 1.0;

		for (int i = 0; i < x.size(); i++) {
			f1 = f1 + z[i] * z[i];
			f2 = f2 * Math.cos(z[i]/Math.sqrt(((double) (i+1))));
		}

		f1 = f1/4000.0 - f2 + 1.0;

		return f1;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g1, g2, h1, h2;

		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    h1 = 0.0;
		h2 = 0.0;
		g1 = 0.0;
		g2 = 1.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 + (z[i] * z[i] - 100 * Math.cos(Math.PI * z[i]) + 10);
			g2 = g2 * z[i];
			h1 = h1 - z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
			h2 = h2 + z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		h1 = Math.abs(h1);
		h2 = Math.abs(h2);

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}

		return (g1 + g2 + h1 + h2)/4;
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
