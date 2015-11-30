package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Step extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Step(){
        new U_Step(30);
    }

    public U_Step(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sum = 0.0;
        for (int i = 0; i < getDimension(); ++i) {
            sum += Math.floor(x.get(i) + 0.5) * Math.floor(x.get(i) + 0.5);
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
        return "Step";
    }

}
