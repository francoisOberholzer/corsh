package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Bohachevsky extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Bohachevsky(){
        new U_Bohachevsky(30);
    }

    public U_Bohachevsky(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public Double fitness(Vector<Double> x) {
        return x.get(0)*x.get(0) + 2*x.get(1)*x.get(1) - 0.3*Math.cos(3*Math.PI*x.get(0))
                - 0.4*Math.cos(4*Math.PI*x.get(1))+0.7;
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
        return "Bohachevsky";
    }
}
