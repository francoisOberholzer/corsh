package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Schwefel2_22 extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Schwefel2_22(){
        new U_Schwefel2_22(30);
    }

    public U_Schwefel2_22(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sum = 0;
        double product = 0;
        for (int i = 0; i < getDimension(); ++i) {
            sum += Math.abs(x.get(i));
            if (i == 0)
                product = Math.abs(x.get(i));
            else
                product *= Math.abs(x.get(i));
        }

        return sum + product;
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
        return "Schwefel2_22";
    }
}
