package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Quadric extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Quadric(){
        new U_Quadric(30);
    }

    public U_Quadric(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
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
