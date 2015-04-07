package problems;

import java.util.Vector;

public class C13 extends AbstractProblem {
    private double[] o = new double[]{69.69311714880897,	1.509803311435702,	67.6746198312362,	80.43173609273597,	80.47622449424348,	51.21092936019716,	52.7723719926014,	17.248465789326257,	52.40150903116374,	39.64846247456716,	89.86375903333635,	32.079301315169474,	43.192499277837946,	70.79294586561508,	1.48440984483988,	19.8566700417119,	29.502667246412756,	34.256788127976684,	12.643016541338264,	78.57234385195876,	26.51647349482587,	97.06430708087798,	10.180504722002471,	82.90799886855778,	63.540231382573154,	74.78243308676124,	87.20817289266436,	50.779655804893764,	43.05412185616204,	33.862234518700916};
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

		for (int i = 0; i < x.size(); i++) {
			 f = f - z[i] * Math.sin(Math.sqrt(Math.abs(z[i])));
		}

		f = f / x.size();

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
			g3 = 1.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 + (z[i] * z[i]);
			g2 = g2 + Math.sin((1/50.0) * Math.PI * z[i]);
			g3 = g3 * Math.cos(z[i]/Math.sqrt(((double) (i+1))));
		}

		g1 = -50.0 + (1/(100.0 * ((double) x.size()))) * g1;
		g2 = (50.0/((double) x.size())) * g2;
		g3 = 75.0 - 50.0 * (g1/4000.0 - g3 + 1.0);
		
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
