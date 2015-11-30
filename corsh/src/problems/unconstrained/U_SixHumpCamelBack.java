package problems.unconstrained;


import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_SixHumpCamelBack extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_SixHumpCamelBack(){
        new U_SixHumpCamelBack(30);
    }

    public U_SixHumpCamelBack(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
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
