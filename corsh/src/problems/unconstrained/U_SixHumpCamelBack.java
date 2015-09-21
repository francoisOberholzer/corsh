package problems.unconstrained;


import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_SixHumpCamelBack extends AbstractProblem {
    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_SixHumpCamelBack(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 5.12;
            domainsMin[i] = -5.12;
        }
    }

    public Double fitness(Vector<Double> x) {
        double x1 = x.get(0);
        double x2 = x.get(1);
        return (4 *x1*x1 - 2.1 *Math.pow(x1, 4.0) + Math.pow(x1, 6.0)/3.0  + x1 *x2 - 4*(x2 *x2) + 4*Math.pow(x2, 4.0));
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
        return "SixHumpCamelBack";
    }
}
