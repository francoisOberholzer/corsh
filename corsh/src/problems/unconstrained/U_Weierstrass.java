package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_Weierstrass extends AbstractProblem {

    private static int dimension = 30;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];
    private double a;
    private double b;
    private int kMax;
    private double constant;

    public U_Weierstrass(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -5;
        }
        computeConstant();
    }

    public U_Weierstrass(int dim) {
        dimension = dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -5;
        }
        computeConstant();
    }

    public Double fitness(Vector<Double> x) {
        double tmp = 0;

        for (int i = 0; i < getDimension(); i++) {
            for(int k = 0; k <= kMax; k++) {
                tmp += Math.pow(a, k) * Math.cos(2 * Math.PI * Math.pow(b, k) * (x.get(i) + 0.5));
            }
        }
        return tmp - getDimension() * constant;
    }

    /**
     * This computes the second term which is a constant so it can be stored
     * separately and only needs to be computed when the function parameters
     * change.
     */
    private void computeConstant() {
        this.a = 0.5;
        this.b = 3.0;
        this.kMax = 20;
        double tmp = 0.0;
        for(int k = 0; k <= kMax; k++) {
            tmp += Math.pow(a, k) * Math.cos(2 * Math.PI * Math.pow(b, k) * 0.5);
        }
        constant = tmp;
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
        return "Weierstrass";
    }
}
