package problems.unconstrained;

import java.util.Vector;

import problems.AbstractProblem;

/**
 * Created by David on 2015-09-17.
 */
public class U_Rosenbrock extends AbstractProblem {

    private static int dimension ;
    private static double[] domainsMin ;
    private static double[] domainsMax ;

    public U_Rosenbrock(){
        new U_Rosenbrock(30);
    }

    public U_Rosenbrock(int dim){
        dimension=dim;
        domainsMin = new double[dimension];
        domainsMax = new double[dimension];
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 2.048;
            domainsMin[i] = -2.048;
        }
    }

    public Double fitness(Vector<Double> x) {
        double tmp = 0.0;
        for (int i = 0; i < getDimension()-1; ++i) {
            double a = x.get(i);
            double b = x.get(i + 1);
            tmp += ((100 * (b - a * a) * (b - a * a)) + ((a - 1.0) * (a - 1.0)));
        }
        return tmp;
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
        return "U_Rosenbrock";
    }
}
