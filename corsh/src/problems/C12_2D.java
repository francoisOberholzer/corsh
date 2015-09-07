package problems;

import java.util.Vector;

public class C12_2D extends AbstractProblem {
    private double[] o = new double[]{18.889635068428205,	-59.265426383246485,	33.25998466165768,	20.152694275194037,	-10.734106238462502,	-90.85053128520764,	-12.073899411249897,	59.72307696259165,	-37.44193247323578,	25.963111555782035,	6.251460324561279,	41.478172862575434,	86.54258849813075,	34.94822787072172,	26.864471649916382,	79.55580868986908,	-44.66218241775459,	-7.305741544994362,	87.75843366209835,	33.836473236958284,	84.53385936725138,	80.89850629751817,	48.46967726645195,	-82.0758049330533,	-98.54273249151939,	19.55069746505636,	8.33657824668768,	88.54888769408086,	-79.08282398956031,	63.254014133387614};
	private final double e = 0.0001;
	private static int dimension = 2;
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
		
		for (int i = 0; i < x.size(); i++) {
			f = f + (z[i] * Math.sin(Math.sqrt(Math.abs(z[i]))));
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double g, h;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    g = 0.0;
		h = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g = g + (z[i] - 100 * Math.cos(0.1 * z[i]) + 10);
		}
		for (int i = 0; i < x.size()-1; i++) {
			h = h + Math.pow((z[i] * z[i]  - z[i+1]),2);
		}

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

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	
		   
		//Constraints  
	    g = 0.0;
		h = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g = g + (z[i] - 100 * Math.cos(0.1 * z[i]) + 10);
		}
		for (int i = 0; i < x.size()-1; i++) {
			h = h + Math.pow((z[i] * z[i]  - z[i+1]),2);
		}

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
    	return "C12_2D";
    }
}
