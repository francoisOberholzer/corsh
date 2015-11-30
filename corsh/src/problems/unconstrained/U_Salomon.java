package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Salomon extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin;
    private static double[] domainsMax;

    public U_Salomon(){new U_Salomon(30);
    }

    public U_Salomon(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 100;
            domainsMin[i] = -100;
        }
    }

    public Double fitness(Vector<Double> x) {
        double sumSquares = 0.0;
        for (int i = 0; i < getDimension(); i++) {
            sumSquares += x.get(i) * x.get(i);
        }
        return -(Math.cos(2 * Math.PI * Math.sqrt(sumSquares))) + (0.1 * Math.sqrt(sumSquares)) + 1;
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
        return "Salomon";
    }
}
