package functions;

import java.util.Vector;

public class C05 extends AbstractFunction {
    private double[] o = new double[]{72.10900225247575,	9.007673762322495,	51.86632637302316,	41.365704820161,	93.18768763916974,	74.53341902482204,	63.745479932407655,	7.496986033468282,	56.16729598807964,	17.71630810614085,	28.009655663065143,	29.36357615570272,	26.966653374740996,	6.892189514516317,	44.29071160734624,	84.35803966449319,	81.16906730972529,	92.76919270133271,	3.826058034047476,	7.231864548985054,	14.446069444832405,	46.49943418775763,	22.155722253817412,	69.11723738661682,	88.99628570349459,	58.74823912291344,	52.265369214509846,	47.030120955005074,	53.23321779503931,	5.778976086909701};
	private final double e = 0.0001;
	private static int dimension = -1;
	private static double[] domainsMin = new double[]{-600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600, -600};	
	private static double[] domainsMax = new double[]{600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600};

    public Double f(Vector<Double> x) {
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
		double h1, h2;
		
		//z = x - o
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		 
		//Constraints   
		h1 = 0.0;
		h2 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			h1 = h1 - z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
			h2 = h2 - z[i] * Math.cos(0.5 * Math.sqrt(Math.abs(z[i])));
		}

		h1 = h1/x.size();
		h2 = h2/x.size();

		h1 = Math.abs(h1);
		h2 = Math.abs(h2);

		//Mean Violations
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}

		return (h1 + h2)/2;
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
