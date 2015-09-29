package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_Pathological extends AbstractProblem{

    private static int dimension = 2;
    private static double[] domainsMin = new double[dimension];
    private static double[] domainsMax = new double[dimension];

    public U_Pathological(){
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public U_Pathological(int dim) {
        dimension = dim;
        for (int i = 0; i < getDimension(); i++) {
            domainsMax[i] = 10;
            domainsMin[i] = -10;
        }
    }

    public Double fitness(Vector<Double> input) {
        double sum = 0;

        for (int i = 0; i < getDimension()-1; i++) {
            double xi = input.get(i);
            double xj = input.get(i + 1);
            double sinSquared = Math.sin(Math.sqrt((100 * (xi*xi)) + (xj*xj)));
            sinSquared *= sinSquared;

            double squaredVal = (xi * xi) - (2 * xi * xj) + (xj * xj);
            squaredVal *= squaredVal;

            sum += 0.5 + ((sinSquared - 0.5) / (1 + (0.001 * squaredVal)));
        }
        return sum;
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
        return "Pathological";
    }
}
