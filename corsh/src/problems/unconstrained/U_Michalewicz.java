package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_Michalewicz extends AbstractProblem{

    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Michalewicz(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = Math.PI;
            domainsMin[i] = 0;
        }
    }

    public U_Michalewicz(int dim) {
        dimension = dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = Math.PI;
            domainsMin[i] = 0;
        }
    }

    public Double fitness(Vector<Double> v) {
        double sumsq = 0.0;

        for (int i = 0; i < getDimension(); i++) {
            double x = v.get(i);
            sumsq += Math.sin(x) * Math.pow(Math.sin(((i+1) * x * x)/Math.PI), 2*10);
        }
        return -sumsq;
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
        return "Michalewicz";
    }
}
