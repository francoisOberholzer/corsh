package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Quadric extends AbstractProblem {
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Quadric(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public U_Quadric(int dim){
        dimension=dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sumsq = 0.0;
        double sum;
        for (int i = 0; i < getDimension(); ++i) {
            sum = 0;
            for (int j = 0; j <= i; ++j) {
                sum += x.get(j);
            }
            sumsq += sum * sum;
        }
        return sumsq;
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
        return "Quadric";
    }
}
