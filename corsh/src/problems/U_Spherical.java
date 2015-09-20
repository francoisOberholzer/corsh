package problems;

import java.util.Vector;

/**
 * Created by David on 2015-09-17.
 */
public class U_Spherical extends AbstractProblem {

    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Spherical(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public Double f(Vector<Double> x) {
        double tmp = 0;
        for (int i = 0; i < getDimension(); i++) {
            tmp += x.get(i) * x.get(i);
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
        return "Spherical";
    }
}
