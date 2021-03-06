package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G19 extends AbstractProblem {
	private static int dimension = 15;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	
    public Double fitness(Vector<Double> x) {
    	double f;
    	double sum1 = 0.0, sum2 = 0.0, sum3 = 0.0;
    	
    	double B[] = { -40.0, -2.0, -0.25, -4.0, -4.0, -1.0, -40.0, -60.0, 5.0, 1.0 };
    	double C[][] = { 
    			  {30.0, -20.0, -10.0, 32.0, -10.0}, 
    			  {-20.0, 39.0, -6.0, -31.0, 32.0},
    			  {-10.0, -6.0, 10.0, -6.0, -10.0},
    			  {32.0, -31.0, -6.0, 39.0, -20.0},
    			  {-10.0, 32.0, -10.0, -20.0, 30.0}
    	};
    	double D[] = { 4.0, 8.0, 10.0, 6.0, 2.0 };

    	for (int i = 0; i < 10; i++)
    	{
    		sum1 += B[i] * x.get(i);
		}
    	for (int i = 0; i < 5; i++)
    	{
    		for (int j = 0; j < 5; j++)
    		{
    		  sum2 += C[i][j] * x.get(10 + i) * x.get(10 + j);
    		}
    	}
    	for (int i = 0; i < 5; i++)
        {
    	    sum3 += D[i] * Math.pow(x.get(10 + i), 3.0);
    	}
    	f = sum1 - sum2 - 2.0 * sum3;
    	f = -f;

    	return f;
    }
    
    public double violation(Vector<Double> x) {
    	double[] g = { 0, 0, 0, 0, 0};
    	double g1, g2, g3, g4, g5;
    	double A[][] = { 
  			  {-16.0, 2.0, 0.0, 1.0, 0.0},
  			  {0.0, -2.0, 0.0, 0.4, 2.0},  
  			  {-3.5, 0.0, 2.0, 0.0, 0.0},
  			  {0.0, -2.0, 0.0, -4.0, -1.0},
  			  {0.0, -9.0, -2.0, 1.0, -2.8},
  			  {2.0, 0.0, -4.0, 0.0, 0.0},
  			  {-1.0, -1.0, -1.0, -1.0, -1.0},
  			  {-1.0, -2.0, -3.0, -2.0, -1.0},
  			  {1.0, 2.0, 3.0, 4.0, 5.0},
  			  {1.0, 1.0, 1.0, 1.0, 1.0}
    	};
    	double C[][] = { 
  			  {30.0, -20.0, -10.0, 32.0, -10.0}, 
  			  {-20.0, 39.0, -6.0, -31.0, 32.0},
  			  {-10.0, -6.0, 10.0, -6.0, -10.0},
  			  {32.0, -31.0, -6.0, 39.0, -20.0},
  			  {-10.0, 32.0, -10.0, -20.0, 30.0}
    	};
    	double D[] = { 4.0, 8.0, 10.0, 6.0, 2.0 };
    	double E[] = { -15.0, -27.0, -36.0, -18.0, -12.0 };
    	double sum1 = 0.0, sum2 = 0.0;
    	
    	for(int i = 0; i < 5; i++)
	    {
    		sum1 = 0.0;
    		for(int j = 0; j < 5; j++)
    			sum1 += C[j][i] * x.get(10 + j);
    		sum2 = 0.0;
    		for(int j = 0; j < 10; j++)
    			sum2 += A[j][i] * x.get(j);
    		g[i] = -((2.0 * sum1) + (3.0 * D[i] * Math.pow(x.get(10 + i), 2.0)) + E[i] - sum2);
	    }

    	g1 = g[0];
    	g2 = g[1];
    	g3 = g[2];
    	g4 = g[3];
    	g5 = g[4];
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}
		if (g4 <= 0) {
			g4 = 0;
		}
		if (g5 <= 0) {
			g5 = 0;
		}

		return (g1 + g2 + g3 + g4 + g5)/5;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double[] g = { 0, 0, 0, 0, 0};
    	double g1, g2, g3, g4, g5;
    	double A[][] = { 
  			  {-16.0, 2.0, 0.0, 1.0, 0.0},
  			  {0.0, -2.0, 0.0, 0.4, 2.0},  
  			  {-3.5, 0.0, 2.0, 0.0, 0.0},
  			  {0.0, -2.0, 0.0, -4.0, -1.0},
  			  {0.0, -9.0, -2.0, 1.0, -2.8},
  			  {2.0, 0.0, -4.0, 0.0, 0.0},
  			  {-1.0, -1.0, -1.0, -1.0, -1.0},
  			  {-1.0, -2.0, -3.0, -2.0, -1.0},
  			  {1.0, 2.0, 3.0, 4.0, 5.0},
  			  {1.0, 1.0, 1.0, 1.0, 1.0}
    	};
    	double C[][] = { 
  			  {30.0, -20.0, -10.0, 32.0, -10.0}, 
  			  {-20.0, 39.0, -6.0, -31.0, 32.0},
  			  {-10.0, -6.0, 10.0, -6.0, -10.0},
  			  {32.0, -31.0, -6.0, 39.0, -20.0},
  			  {-10.0, 32.0, -10.0, -20.0, 30.0}
    	};
    	double D[] = { 4.0, 8.0, 10.0, 6.0, 2.0 };
    	double E[] = { -15.0, -27.0, -36.0, -18.0, -12.0 };
    	double sum1 = 0.0, sum2 = 0.0;
    	
    	for(int i = 0; i < 5; i++)
	    {
    		sum1 = 0.0;
    		for(int j = 0; j < 5; j++)
    			sum1 += C[j][i] * x.get(10 + j);
    		sum2 = 0.0;
    		for(int j = 0; j < 10; j++)
    			sum2 += A[j][i] * x.get(j);
    		g[i] = -((2.0 * sum1) + (3.0 * D[i] * Math.pow(x.get(10 + i), 2.0)) + E[i] - sum2);
	    }

    	g1 = g[0];
    	g2 = g[1];
    	g3 = g[2];
    	g4 = g[3];
    	g5 = g[4];
    	
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}
		if (g4 <= 0) {
			g4 = 0;
		}
		if (g5 <= 0) {
			g5 = 0;
		}

		return new double[] {g1, g2, g3, g4, g5};
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
    	return "G19_15D";
    }
}
