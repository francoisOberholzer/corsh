package problems.cec2006;

import java.util.Vector;

import problems.AbstractProblem;

//CEC 2006
public class G20 extends AbstractProblem {
	private static int dimension = 24;
	private static double[] domainsMin = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	
	private static double[] domainsMax = new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	private final double e = 0.0001;
	
    public Double fitness(Vector<Double> x) {
    	double f;
    	double A[] = { 0.0693, 0.0577, 0.05, 0.2, 0.26, 0.55, 0.06, 0.1, 0.12, 0.18, 0.1, 0.09, 0.0693, 0.0577, 0.05, 0.2, 0.26, 0.55, 0.06, 0.1, 0.12, 0.18, 0.1, 0.09 }; 

    	f = 0.0;
    	for (int i = 0; i < 24; i++)
    	{
    		f += A[i] * x.get(i);
    	}
    	  
    	return f;
    }

    public double violation(Vector<Double> x) {
    	double sum1 = 0.0;
    	double sum2 = 0.0;
    	double sumtotal = 0.0;
    	double[] g = new double[6];
    	double[] h = new double[14];
    	double g1, g2, g3, g4, g5, g6;
    	double h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14;
    	
    	double B[] = { 44.094, 58.12, 58.12, 137.4, 120.9, 170.9, 62.501, 84.94, 133.425, 82.507, 46.07, 60.097, 44.094, 58.12, 58.12, 137.4, 120.9, 170.9, 62.501, 84.94, 133.425, 82.507, 46.07, 60.097 };
    	double C[] = { 123.7, 31.7, 45.7, 14.7, 84.7, 27.7, 49.7, 7.1, 2.1, 17.7, 0.85, 0.64 };
    	double D[] = { 31.244, 36.12, 34.784, 92.7, 82.7, 91.6, 56.708, 82.7, 80.8, 64.517, 49.4, 49.1 };
    	double E[] = { 0.1, 0.3, 0.4, 0.3, 0.6, 0.3 };
    	
   	  	for (int j = 0; j < 12; j++)
   	  		sum1 += x.get(j) / B[j];
   	  
   	  	for (int j = 12; j < 24; j++)
   	  		sum2 += x.get(j) / B[j];
   	  	
   	  	for (int i = 0; i < 12; i++)
   	  		h[i] = (x.get(i + 12) / (B[i + 12] * sum2)) - ((C[i] * x.get(i)) / (40.0 * B[i] * sum1));
   	  	
   	  	for (int j = 0; j < 24; j++)
   	  		sumtotal += x.get(j);
   	  	
   	  	h[12] = sumtotal - 1.0;
   	  	sum1 = 0.0;
   	  	
   	  	for (int j = 0; j < 12; j++)
   	  		sum1 += x.get(j) / D[j];
   	  	
   	  	sum2 = 0.0;
   	  	
   	 	for (int j = 12; j < 24; j++)
   	 		sum2 += x.get(j) / B[j];
   	 	
   	 	h[13] = sum1 + (0.7302 * 530.0 * (14.7 / 40)) * sum2 - 1.671;
   	 	
   	 	for (int j = 0; j < 3; j++)
   	 		g[j] = (x.get(j) + x.get(j + 12)) / (sumtotal + E[j]);
   	 	
   	 	for (int j = 3; j < 6; j++)
   	 		g[j] = (x.get(j + 3) + x.get(j + 15)) / (sumtotal + E[j]);
    
   	 	g1 = g[0];
    	g2 = g[1];
    	g3 = g[2];
    	g4 = g[3];
    	g5 = g[4];	
    	g6 = g[5];
    	
    	h1 = h[0];
    	h2 = h[1];
    	h3 = h[2];
    	h4 = h[3];
    	h5 = h[4];
    	h6 = h[5];
    	h7 = h[6];
    	h8 = h[7];
    	h9 = h[8];
    	h10 = h[9];
    	h11 = h[10];
    	h12 = h[11];
    	h13 = h[12];
    	h14 = h[13];
   	 		
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
		if (g6 <= 0) {
			g6 = 0;
		}
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
		if ((h5 - e) <= 0) {
			h5 = 0;
		}
		if ((h6 - e) <= 0) {
			h6 = 0;
		}
		if ((h7 - e) <= 0) {
			h7 = 0;
		}
		if ((h8 - e) <= 0) {
			h8 = 0;
		}
		if ((h9 - e) <= 0) {
			h9 = 0;
		}
		if ((h10 - e) <= 0) {
			h10 = 0;
		}
		if ((h11 - e) <= 0) {
			h11 = 0;
		}
		if ((h12 - e) <= 0) {
			h12 = 0;
		}
		if ((h13 - e) <= 0) {
			h13 = 0;
		}
		if ((h14 - e) <= 0) {
			h14 = 0;
		}
	
		return (g1 + g2 + g3 + g4 + g5 + g6 + h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8 + h9 + h10 + h11 + h12 + h13 + h14)/20;
    }
    
    public double[] violationArray(Vector<Double> x) {
    	double sum1 = 0.0;
    	double sum2 = 0.0;
    	double sumtotal = 0.0;
    	double[] g = new double[6];
    	double[] h = new double[14];
    	double g1, g2, g3, g4, g5, g6;
    	double h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14;
    	
    	double B[] = { 44.094, 58.12, 58.12, 137.4, 120.9, 170.9, 62.501, 84.94, 133.425, 82.507, 46.07, 60.097, 44.094, 58.12, 58.12, 137.4, 120.9, 170.9, 62.501, 84.94, 133.425, 82.507, 46.07, 60.097 };
    	double C[] = { 123.7, 31.7, 45.7, 14.7, 84.7, 27.7, 49.7, 7.1, 2.1, 17.7, 0.85, 0.64 };
    	double D[] = { 31.244, 36.12, 34.784, 92.7, 82.7, 91.6, 56.708, 82.7, 80.8, 64.517, 49.4, 49.1 };
    	double E[] = { 0.1, 0.3, 0.4, 0.3, 0.6, 0.3 };
    	
   	  	for (int j = 0; j < 12; j++)
   	  		sum1 += x.get(j) / B[j];
   	  
   	  	for (int j = 12; j < 24; j++)
   	  		sum2 += x.get(j) / B[j];
   	  	
   	  	for (int i = 0; i < 12; i++)
   	  		h[i] = (x.get(i + 12) / (B[i + 12] * sum2)) - ((C[i] * x.get(i)) / (40.0 * B[i] * sum1));
   	  	
   	  	for (int j = 0; j < 24; j++)
   	  		sumtotal += x.get(j);
   	  	
   	  	h[12] = sumtotal - 1.0;
   	  	sum1 = 0.0;
   	  	
   	  	for (int j = 0; j < 12; j++)
   	  		sum1 += x.get(j) / D[j];
   	  	
   	  	sum2 = 0.0;
   	  	
   	 	for (int j = 12; j < 24; j++)
   	 		sum2 += x.get(j) / B[j];
   	 	
   	 	h[13] = sum1 + (0.7302 * 530.0 * (14.7 / 40)) * sum2 - 1.671;
   	 	
   	 	for (int j = 0; j < 3; j++)
   	 		g[j] = (x.get(j) + x.get(j + 12)) / (sumtotal + E[j]);
   	 	
   	 	for (int j = 3; j < 6; j++)
   	 		g[j] = (x.get(j + 3) + x.get(j + 15)) / (sumtotal + E[j]);
    
   	 	g1 = g[0];
    	g2 = g[1];
    	g3 = g[2];
    	g4 = g[3];
    	g5 = g[4];	
    	g6 = g[5];
    	
    	h1 = h[0];
    	h2 = h[1];
    	h3 = h[2];
    	h4 = h[3];
    	h5 = h[4];
    	h6 = h[5];
    	h7 = h[6];
    	h8 = h[7];
    	h9 = h[8];
    	h10 = h[9];
    	h11 = h[10];
    	h12 = h[11];
    	h13 = h[12];
    	h14 = h[13];
   	 		
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
		if (g6 <= 0) {
			g6 = 0;
		}
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
		if ((h5 - e) <= 0) {
			h5 = 0;
		}
		if ((h6 - e) <= 0) {
			h6 = 0;
		}
		if ((h7 - e) <= 0) {
			h7 = 0;
		}
		if ((h8 - e) <= 0) {
			h8 = 0;
		}
		if ((h9 - e) <= 0) {
			h9 = 0;
		}
		if ((h10 - e) <= 0) {
			h10 = 0;
		}
		if ((h11 - e) <= 0) {
			h11 = 0;
		}
		if ((h12 - e) <= 0) {
			h12 = 0;
		}
		if ((h13 - e) <= 0) {
			h13 = 0;
		}
		if ((h14 - e) <= 0) {
			h14 = 0;
		}
	
		return new double[] {g1, g2, g3, g4, g5, g6, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14};
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
    	return "G20_24D";
    }
}
