package problems;

import java.util.Vector;

//CEC 2006
public class G12 extends AbstractProblem {
	private static int dimension = 3;
	private static double[] domainsMin = new double[]{0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10};
	
    public Double f(Vector<Double> x) {
    	double f;
    	
    	f = (100.0 - (x.get(0) - 5.) * (x.get(0) - 5.) - (x.get(1) - 5.) * (x.get(1) - 5.) - (x.get(2) - 5.) * (x.get(2) - 5.)) / 100.0;
    	f = -f;
    	
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double g, gt;
    	
    	g = (x.get(0) - 1.) * (x.get(0) - 1.) + (x.get(1) - 1.) * (x.get(1) - 1.) + (x.get(2) - 1.) * (x.get(2) - 1.) - 0.0625;
    	
  	  	for(int i = 1; i <= 9; i++)
  	    {
  	    	for(int j = 1; j <= 9; j++)
  	    	{
  	    		for(int k = 1; k <= 9; k++)
  	    		{
  	    			gt = (x.get(0) - i) * (x.get(0) - i) + (x.get(1) - j) * (x.get(1) - j) + (x.get(2) - k) * (x.get(2) - k) - 0.0625;
  	    			if (gt < g)
  	    				g = gt;
  	    		}
  	    	}
  	    }
    	
		if (g <= 0) {
			g = 0;
		}

		return g;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double g, gt;
    	
    	g = (x.get(0) - 1.) * (x.get(0) - 1.) + (x.get(1) - 1.) * (x.get(1) - 1.) + (x.get(2) - 1.) * (x.get(2) - 1.) - 0.0625;
    	
  	  	for(int i = 1; i <= 9; i++)
  	    {
  	    	for(int j = 1; j <= 9; j++)
  	    	{
  	    		for(int k = 1; k <= 9; k++)
  	    		{
  	    			gt = (x.get(0) - i) * (x.get(0) - i) + (x.get(1) - j) * (x.get(1) - j) + (x.get(2) - k) * (x.get(2) - k) - 0.0625;
  	    			if (gt < g)
  	    				g = gt;
  	    		}
  	    	}
  	    }
    	
		if (g <= 0) {
			g = 0;
		}

		return new double[] {g};
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
    	return "G12_3D";
    }
}
