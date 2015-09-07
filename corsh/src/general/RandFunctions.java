package general;

import java.util.Vector;
import java.lang.Math;

public class RandFunctions {
	public static Vector<Double> getCoordinates(double[] min, double[] max, int dimension) {
		Vector<Double> result = new Vector<Double>();
		for(int i = 0; i < dimension; i++) {
			result.add(getRandom(min[i], max[i]));
		}
		return result;
	}

	public static double getRandom(double min, double max) {
		double result = Math.random();
		result = result * Math.abs(max-min);
		result = result + min;
		return result;
	}
}
