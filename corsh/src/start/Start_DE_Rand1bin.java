package start;

import algorithms.AbstractAlgorithm;
import algorithms.unconstrained.DE_Best_1_Bin;
import algorithms.unconstrained.DE_Rand_1_Bin_Classic;
import problems.*;
import problems.unconstrained.U_Ackley;
import problems.unconstrained.U_Griewank;
import problems.unconstrained.U_Rastigrin;
import problems.unconstrained.U_Rosenbrock;
import problems.unconstrained.U_SixHumpCamelBack;

/**
 * Created by David on 2015-09-17.
 */
public class Start_DE_Rand1bin {
    public static void main(String[] args) {
        //Setup Simulation
        AbstractAlgorithm[] algorithms = getAlgorithmsList();
        AbstractProblem[] problems = getProblemsList();

        //Run Simulation
        for (int i = 0; i < algorithms.length; i++) {
            System.out.println("Starting " + algorithms[i].getName());
            for (int j = 0; j < problems.length; j++) {
                System.out.println("Starting with run " + j + ": " + problems[j].getName());
                algorithms[i].run(problems[j], 10000);
            }
        }
    }


    private static AbstractProblem[] getProblemsList() {
        AbstractProblem[] problems = new AbstractProblem[5];

        problems[0] = new U_Ackley();
        problems[1] = new U_Griewank();
        problems[2] = new U_Rastigrin();
        problems[3] = new U_Rosenbrock();
        problems[4] = new U_SixHumpCamelBack();
        return problems;
    }

    private static AbstractAlgorithm[] getAlgorithmsList(){
        AbstractAlgorithm[] algorithmsList = new AbstractAlgorithm[2];

        algorithmsList[0] = new DE_Rand_1_Bin_Classic();
        algorithmsList[1] = new DE_Best_1_Bin();

        return algorithmsList;
    }
}
