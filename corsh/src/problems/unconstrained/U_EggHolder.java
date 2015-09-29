package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_EggHolder extends AbstractProblem {

    private static int dimension = 2;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_EggHolder(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 512;
            domainsMin[i] = -512;
        }
    }

    public U_EggHolder(int dim) {
        dimension = dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 512;
            domainsMin[i] = -512;
        }
    }

    public Double fitness(Vector<Double> input) {
        double x = input.get(0);
        double y = input.get(1);
        double sum = -1*(y + 47)*Math.sin(Math.sqrt(Math.abs(y + x/2 + 47)))
                + Math.sin(Math.sqrt(Math.abs(x - (y+47)))) *(-1*x);
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
        return "EggHolder";
    }
}
