package problems;

import java.util.Vector;

/**
 * Created by David on 2015-09-17.
 */
public class U_Schwefel2_26 extends AbstractProblem {
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Schwefel2_26(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public Double f(Vector<Double> x) {
        double sum = 0;
        for (int i = 0; i < getDimension(); ++i) {
            sum += x.get(i) * Math.sin(Math.sqrt(Math.abs(x.get(i))));
        }

        return -sum;
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
        return "Schwefel2_26";
    }
}
