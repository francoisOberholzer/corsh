package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G14 extends AbstractProblem {
	private static int dimension = 10;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
    	double f;
 
    	double sumlog = 0.0, sum = 0.0;
    	double[] C = { -6.089, -17.164, -34.054, -5.914, -24.721, -14.986, -24.100, -10.708, -26.662, -22.179 };

    	for (int i = 0; i < 10; i++)
    		sumlog += x.get(i);
    	for (int i = 0; i < 10; i++)
    		sum += x.get(i) * (C[i] + Math.log(x.get(i) / sumlog));
    	f = sum;  
  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double h1, h2, h3;
    	
    	h1 = x.get(0) + 2.0 * x.get(1) + 2.0 * x.get(2) + x.get(5) + x.get(9) - 2.0;
    	h2 = x.get(3) + 2.0 * x.get(4) + x.get(5) + x.get(6) - 1.0;
  	  	h3 = x.get(2) + x.get(6) + x.get(7) + 2.0 * x.get(8) + x.get(9) - 1.0;
  	  
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}
		if ((h3 - e) <= 0) {
			h3 = 0;
		}

		return (h1 + h2 + h3)/3;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double h1, h2, h3;
    	
    	h1 = x.get(0) + 2.0 * x.get(1) + 2.0 * x.get(2) + x.get(5) + x.get(9) - 2.0;
    	h2 = x.get(3) + 2.0 * x.get(4) + x.get(5) + x.get(6) - 1.0;
  	  	h3 = x.get(2) + x.get(6) + x.get(7) + 2.0 * x.get(8) + x.get(9) - 1.0;
  	  
		if ((h1 - e) <= 0) {
			h1 = 0;
		}
		if ((h2 - e) <= 0) {
			h2 = 0;
		}
		if ((h3 - e) <= 0) {
			h3 = 0;
		}

		return new double[] {h1, h2, h3};
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
    	return "G14_10D";
    }
}
