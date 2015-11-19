package problems.unconstrained;


import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Rastrigrin extends AbstractProblem {
    private static int dimension;
    private static double[] domainsMin ;
    private static double[] domainsMax ;

    public U_Rastrigrin(){
        new U_Rastrigrin(30);
    }

    public U_Rastrigrin(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
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
        return "Rastrigrin";
    }
}
