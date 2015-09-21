package problems.cec2010;

import java.util.Vector;

import problems.AbstractProblem;

public class C03_30D extends AbstractProblem {
    private double[] o = new double[]{111.17633500088529,	92.07880492633424,	417.9818592609036,	253.16188128024302,	363.5279986597767,	314.334093889305,	187.32739056163342,	240.4363027535162,	422.60090880560665,	327.63042902581515,	62.04762897064405,	25.435663968682125,	360.56773191905114,	154.9226721156832,	33.161292034425806,	177.8091733067186,	262.58198940407755,	436.9800562237075,	476.6400624069227,	331.2167787340325,	75.205948242522,	484.33624811710115,	258.4696246506982,	419.8919566566751,	357.51468895930395,	166.3771729386268,	47.59455935830133,	188.20606700809785,	184.7964918401363,	267.9201349178807};
	private final double e = 0.0001;
	private static int dimension = 30;
	private static double[] domainsMin = new double[]{-1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000};	
	private static double[] domainsMax = new double[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

    public Double fitness(Vector<Double> x) {
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
			f = f + (100 * Math.pow((z[i] * z[i] - z[i+1]),2) + Math.pow((z[i] - 1),2));
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double h;
		
		//z = x - o		
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		 
		//Constraints   
		h = 0.0;

		for (int i = 0; i < x.size()-1; i++) {
			h = h +  Math.pow((z[i] - z[i+1]),2);
		}

		h = Math.abs(h);

		//Mean Violations
		if ((h - e) <= 0) {
			h = 0;
		}

		return h;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double h;
		
		//z = x - o		
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		 
		//Constraints   
		h = 0.0;

		for (int i = 0; i < x.size()-1; i++) {
			h = h +  Math.pow((z[i] - z[i+1]),2);
		}

		h = Math.abs(h);

		//Mean Violations
		if ((h - e) <= 0) {
			h = 0;
		}

		return new double[] {h};
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
    	return "C03_30D";
    }
}
