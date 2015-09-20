package problems;

import java.util.Vector;

/**
 * Created by David on 2015-09-17.
 */
public class U_Salomon extends AbstractProblem {
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Salomon(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public Double f(Vector<Double> x) {
        double sumSquares = 0.0;
        for (int i = 0; i < getDimension(); i++) {
            sumSquares += x.get(i) * x.get(i);
        }
        return -(Math.cos(2 * Math.PI * Math.sqrt(sumSquares))) + (0.1 * Math.sqrt(sumSquares)) + 1;
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
        return "Salomon";
    }
}
