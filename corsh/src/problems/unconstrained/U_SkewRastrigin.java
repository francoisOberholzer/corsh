package problems.unconstrained;

import problems.AbstractProblem;

import java.util.Vector;

/**
 * Created by David on 2015-09-29.
 */
public class U_SkewRastrigin extends AbstractProblem {

private static int dimension;
private static double[] domainsMin;
private static double[] domainsMax;

        public U_SkewRastrigin(){
            new U_SkewRastrigin(30);
        }

        public U_SkewRastrigin(int dim) {
            dimension = dim;
            domainsMin = new double[dimension];
            domainsMax = new double[dimension];
            for (int i = 0; i < getDimension(); i++) {
                domainsMax[i] = 5;
                domainsMin[i] = -5;
            }
        }

        public Double fitness(Vector<Double> x) {
            double tmp = 0;
            int dim = getDimension();
            for (int i = 0; i < dim; ++i) {
                double val = x.get(i);
                double y;
                if (val > 0)
                    y = 10 * val;
                else
                    y = val;
                tmp += y * y - 10.0 * Math.cos(2 * Math.PI * y);
            }
            return 10 * dim + tmp;
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
            return "Skew Rastrigin";
        }
}
