package problems.unconstrained;


import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Rastigrin extends AbstractProblem {
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Rastigrin(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 5.12;
            domainsMin[i] = -5.12;
        }
    }

    public U_Rastigrin(int dim){
        dimension=dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 5.12;
            domainsMin[i] = -5.12;
        }
    }

    public Double fitness(Vector<Double> x) {
        double tmp = 0;
        for (int i = 0; i < getDimension(); ++i) {
            tmp += x.get(i) * x.get(i) - 10.0 * Math.cos(2 * Math.PI * x.get(i));
        }
        return 10*getDimension() + tmp;
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
        return "Rastigrin";
    }
}
