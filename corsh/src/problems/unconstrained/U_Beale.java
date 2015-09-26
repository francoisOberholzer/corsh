package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Beale extends AbstractProblem {
    private static int dimension = 2;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Beale(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 4.5;
            domainsMin[i] = -4.5;
        }
    }
    public U_Beale(int dim){
        if(dim>2){
            System.out.println(getName()+ " should work in up to 2 dimensions");
        }
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 4.5;
            domainsMin[i] = -4.5;
        }
    }

    public Double fitness(Vector<Double> x) {
        double x1 = x.get(0);
        double x2 = x.get(1);

        return (1.5-x1+x1*x2)*(1.5-x1+x1*x2) + (2.25-x1+x1*x2*x2)*(2.25-x1+x1*x2*x2)
                + (2.625-x1+x1*x2*x2*x2)*(2.625-x1+x1*x2*x2*x2);
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
        return "Beale";
    }
}
