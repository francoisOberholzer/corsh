package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Rana extends AbstractProblem {
    private static int dimension = 2;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Rana(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 512;
            domainsMin[i] = -512;
        }
    }

    private double f102(double x, double y) {
        double term1 = x * Math.sin(Math.sqrt(Math.abs(y+1-x)))
                * Math.cos(Math.sqrt(Math.abs(x+y+1)));
        double term2 = (y + 1) * Math.cos(Math.sqrt(Math.abs(y+1-x)))
                * Math.sin(Math.sqrt(Math.abs(x+y+1)));
        return term1 + term2;
    }

    public Double fitness(Vector<Double> x) {
        int d = getDimension();
        double sumTotal = 0.0;
        for (int i = 0; i < d; ++i) {
            int index1 = i;
            int index2 = (i + 1) % (d);
            sumTotal += f102(x.get(index1), x.get(index2));
        }
        return  sumTotal;
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
        return "Rana";
    }
}
