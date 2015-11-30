package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Quartic extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Quartic(){
        new U_Quartic(30);
    }

    public U_Quartic(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 1.28;
            domainsMin[i] = -1.28;
        }
    }

    public Double fitness(Vector<Double> x) {
        double tmp = 0;
        for (int i = 0; i < getDimension(); i++) {
            tmp += (i+1) * Math.pow(x.get(i),4);
        }
        return tmp;
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
        return "Quartic";
    }
}
