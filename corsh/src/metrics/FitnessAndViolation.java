package metrics;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Vector;

import functions.AbstractFunction;

public class FitnessAndViolation {
	public static void write(AbstractFunction funct, double min, double max) {
		try {
			PrintWriter writerFit = new PrintWriter("Fitness.dat");
			PrintWriter writerVal = new PrintWriter("Violation.dat");
		
			Vector<Double> in = new Vector<Double>();
			in.add(0.0);
			in.add(0.0);

			writerFit.println("# Fitness Coordinates");
			writerVal.println("# Violation Coordinates");
			
			double i = min;
			double j = min;

			while (i <= max) {
				while (j <= max) {
					in.set(0, i);
					in.set(1, j);
					double resFit = (double) funct.f(in);
					double resVal = (double) funct.violation(in);

					writerFit.println(i + " " + j + " " + new DecimalFormat("00.0000").format(resFit));
					writerVal.println(i + " " + j + " " + new DecimalFormat("00.0000").format(resVal));

					j += Math.abs(max-min)/100;
					j = (double) Math.round(j * 100) / 100;
				}

				i += Math.abs(max-min)/100;
				i = (double) Math.round(i * 100) / 100;
				j = min;
			}

			writerFit.close();
			writerVal.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
}

