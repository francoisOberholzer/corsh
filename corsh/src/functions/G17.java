package functions;

import java.util.Vector;

//CEC 2006
public class G17 extends AbstractFunction {
	private static int dimension = 6;
	private static double[] domainsMin = new double[]{0, 0, 340, 340, -1000, 0};	
	private static double[] domainsMax = new double[]{400, 1000, 420, 420, 1000, 0.5236};
	private final double e = 0.0001;
	
    public Double f(Vector<Double> x) {
    	double f;
    	double f1 = 0, f2 = 0, x1, x2, x3, x4, x6;
		double aux1, aux2;
		
		x1 = x.get(0);
		x2 = x.get(1);
		x3 = x.get(2);
		x4 = x.get(3);
		x6 = x.get(5);
				
		aux1 = 300.0 - (((x3 * x4) * Math.cos(1.48477 - x6)) - ((0.90798 * Math.pow(x3, 2.0)) * Math.cos(1.47588))) / 131.078;
		aux2 = -(((x3 * x4)  * Math.cos(1.48477 + x6)) - ((0.90798 * Math.pow(x4, 2.0)) * Math.cos(1.47588)))/ 131.078;
				
		if (x1 >= 0.0 && x1 < 300.0)
		{
			f1 = 30.0 * aux1;
		}
		else
		{
			if (x1 >= 300.0 && x1 <= 400.0)
			{
				f1 = 31.0 * aux1;
			}
		}
		if (x2 >= 0.0 && x2 < 100.0)
		{
			f2 = 28.0 * aux2;
		}
		else
		{
			if (x2 >= 100.0 && x2 < 200.0)
			{
				f2 = 29.0 * aux2;
			}
			else
			{
				if (x2 >= 200.0 && x2 <= 1000.0)
				{
					f2 = 30.0 * aux2;
				}
			}
		}
    	f = f1 + f2;
    	  
    	return f;  
    }

    public double violation(Vector<Double> x) {
    	double x1, x2, x3, x4, x5, x6;
		double aux1, aux2, aux5, aux4;
		double h1, h2, h3, h4;
		
		x1 = x.get(0);
		x2 = x.get(1);
		x3 = x.get(2);
		x4 = x.get(3);
		x5 = x.get(4);
		x6 = x.get(5);
				
		aux1 = 300.0 - (((x3 * x4) * Math.cos(1.48477 - x6)) - ((0.90798 * Math.pow(x3, 2.0)) * Math.cos(1.47588))) / 131.078;
		aux2 = -(((x3 * x4)  * Math.cos(1.48477 + x6)) - ((0.90798 * Math.pow(x4, 2.0)) * Math.cos(1.47588)))/ 131.078;
		aux5 = -(((x3 * x4)  * Math.sin(1.48477 + x6)) - ((0.90798 * Math.pow(x4, 2.0)) * Math.sin(1.47588)))/ 131.078;
		aux4 = 200.0 - (((x3 * x4)  * Math.sin(1.48477 - x6)) - ((0.90798 * Math.pow(x3, 2.0))  * Math.sin(1.47588)))/ 131.078;
    	
    	h1 = aux1 - x1;
  	  	h2 = aux2 - x2;
  	  	h3 = aux5 - x5;
  	  	h4 = aux4;
    	
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
