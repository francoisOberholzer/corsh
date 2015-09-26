package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Ackley extends AbstractProblem{
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Ackley(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 32.768;
            domainsMin[i] = -32.768;
        }
    }

    public U_Ackley(int dim) {
        dimension = dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 32.768;
            domainsMin[i] = -32.768;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sumsq = 0.0;
        double sumcos = 0.0;
        for (int i = 0; i < getDimension(); ++i) {
            sumsq += x.get(i) * x.get(i);
            sumcos += Math.cos(2 * Math.PI * x.get(i));
        }
        return -20.0* Math.exp(-0.2* Math.sqrt( sumsq/getDimension() )) - Math.exp( sumcos/getDimension() ) +20+ Math.E;
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
        return "Ackley";
    }
}