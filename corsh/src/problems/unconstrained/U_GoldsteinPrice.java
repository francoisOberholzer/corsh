package problems.unconstrained;


import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-17.
 */
public class U_GoldsteinPrice extends AbstractProblem{
    private static int dimension = 2;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_GoldsteinPrice(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 2;
            domainsMin[i] = -2;
        }
    }

    public U_GoldsteinPrice(int dim){
        if(dim>2){
            System.out.println(getName()+ " should work in up to 2 dimensions");
        }
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 2;
            domainsMin[i] = -2;
        }
    }

    public Double f(Vector<Double> x) {
        double part1 = 1 + (x.get(0)+x.get(1)+1.0)*(x.get(0)+x.get(1)+1.0)*(19.0 - 14.0*x.get(0) + 3*x.get(0)*x.get(0)
                - 14*x.get(1) + 6*x.get(0)*x.get(1) + 3*x.get(1)*x.get(1));
        double part2 = 30 + (2*x.get(0)-3*x.get(1))*(2*x.get(0)-3*x.get(1)) * (18 - 32*x.get(0) + 12*x.get(0)*x.get(0)
                + 48*x.get(1) - 36*x.get(0)*x.get(1) + 27*x.get(1)*x.get(1));
        return part1 * part2;
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
        return "GoldsteinPrice";
    }
}
