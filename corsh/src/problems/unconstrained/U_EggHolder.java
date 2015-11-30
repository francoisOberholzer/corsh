package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_EggHolder extends AbstractProblem {

    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_EggHolder(){
        new U_EggHolder(2);
    }

    public U_EggHolder(int dim) {
        dimension = dim;
        if ((getDimension() != 2))
        {
            System.out.println(getName() + " is only known/defined for 2 dimensions. You tried "+ getDimension() + " dimensions. Things may break...");
        }
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
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
