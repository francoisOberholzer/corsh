package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Griewank extends AbstractProblem{
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Griewank(){
        new U_Griewank(30);
    }

    public U_Griewank(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 600;
            domainsMin[i] = -600;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sumsq = 0;
        double prod = 1;
        for (int i = 0; i < getDimension(); i++) {
            sumsq += x.get(i) * x.get(i);
            prod *= (Math.cos(x.get(i) / Math.sqrt(i + 1)));
        }
        return 1 + sumsq * (1.0/4000.0) - prod;
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
        return "Griewank";
    }
}
