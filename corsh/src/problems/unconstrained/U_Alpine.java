package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_Alpine extends AbstractProblem {

    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Alpine(){
        new U_Alpine(30);
    }

    public U_Alpine(int dim) {
        dimension = dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sum = 0;
        for (int i=0; i<getDimension(); i++) {
            sum += Math.abs((x.get(i)* Math.sin(x.get(i))) + (0.1 * x.get(i)));
        }
        return sum;
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
        return "Alpine";
    }
}