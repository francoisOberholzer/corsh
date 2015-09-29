package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_Zakharov extends AbstractProblem {

    private static int dimension = 2;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Zakharov(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public U_Zakharov(int dim) {
        dimension = dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public Double fitness(Vector<Double> x) {
        int dim = getDimension();
        double term1 = Math.pow(Math.sin(3*Math.PI*x.get(0)),2);
        double lastX = x.get(dim - 1);
        double term3 = Math.pow((lastX - 1),2)*(1 + Math.pow(Math.sin(2*Math.PI*lastX),2));
        double sum = 0;
        for(int i=0; i<dim-1; i++) {
            sum += Math.pow((x.get(i) - 1),2)*(1 + Math.pow(Math.sin(3*Math.PI*x.get(i+1)),2));
        }
        return term1 + sum + term3;
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
        return "Zakharov";
    }
}
