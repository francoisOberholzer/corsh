package metrics;

import general.MiscFunctions;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import java.util.Arrays;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import problems.AbstractProblem;

public class FVC {
	public static String write(AbstractProblem funct, int id) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		int dimension = funct.getDimension();
		
		if(dimension == -1) {
			double[] result10d = new double[30];
			double[] result30d = new double[30];
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = correlation(funct, 10, false, id);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = correlation(funct, 30, false, id);
			}
			
			correlation(funct, 2, true, id);
			correlation(funct, 10, true, id);
			correlation(funct, 30, true, id);
			
			Arrays.sort(result10d);
			Arrays.sort(result30d);
			
			result.append("\n Correlation Ratio \n");
			
			result.append("10D\n");
			result.append("Mean Correlation: " + m.evaluate(result10d, 0, 30) + "\n");
			result.append("Max  Correlation: " + result10d[29] + "\n");
			result.append("Min  Correlation: " + result10d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

			result.append("\n30D\n");
			result.append("Mean Correlation: " + m.evaluate(result30d, 0, 30) + "\n");
			result.append("Max  Correlation: " + result30d[29] + "\n");
			result.append("Min  Correlation: " + result30d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");
		}
		else {
			double[] resultArray = new double[30];
			
			for(int i = 0; i < 30; i++) {
				resultArray[i] = correlation(funct, dimension, false, id);
			}
			
			correlation(funct, dimension, true, id);
			
			Arrays.sort(resultArray);
			
			result.append("\n Correlation Ratio \n");
			
			result.append("Mean Correlation: " + m.evaluate(resultArray, 0, 30) + "\n");
			result.append("Max  Correlation: " + resultArray[29] + "\n");
			result.append("Min  Correlation: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	private static double correlation(AbstractProblem funct, int dimension, boolean writeFile, int id) {
		double result = 0;

		try {
			int size = dimension * 1000;
				
			if(writeFile) {
				PrintWriter writer = new PrintWriter(id + "_" + dimension + "D_" + "FVC.dat");
				
				writer.println("# FVC " + dimension + "D Coordinates");
				
				for(int i = 0; i < size; i++) {
					Vector<Double> coordinates = MiscFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);

					double resFit = (double) funct.f(coordinates);
					double resVal = (double) funct.violation(coordinates);
					
					if(writer != null) {
						writer.println(new DecimalFormat("00.0000").format(resFit) + " " + new DecimalFormat("00.0000").format(resVal));
					}
				}	
				
				writer.close();
			}
			else {
				double[][] data = new double[2][size];
				
				for(int i = 0; i < size; i++) {
					Vector<Double> coordinates = MiscFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);

					double resFit = (double) funct.f(coordinates);
					double resVal = (double) funct.violation(coordinates);

					data[0][i] = resFit;
					data[1][i] = resVal;
				}
				
				result = spearmansCorrelation(data[0], data[1]);
			}
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return 0;
		}

		return result;
	}

	private static double spearmansCorrelation(double[] xArray, double[] yArray) {
		SpearmansCorrelation sc = new SpearmansCorrelation();
		return sc.correlation(xArray, yArray);
	}
}

