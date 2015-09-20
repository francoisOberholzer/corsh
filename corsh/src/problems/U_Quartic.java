package problems;

import java.util.Vector;

/**
 * Created by David on 2015-09-17.
 */
public class U_Quartic extends AbstractProblem {
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Quartic(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 1.28;
            domainsMin[i] = -1.28;
        }
    }

    public Double f(Vector<Double> x) {
        double tmp = 0;
        for (int i = 0; i < getDimension(); i++) {
            tmp += (i+1) * Math.pow(x.get(i),4);
        }
        return tmp;
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
        return "Quartic";
    }
}
