package start;

import algorithms.AbstractAlgorithm;
import algorithms.unconstrained.DE_Best_1_Bin;
import algorithms.unconstrained.DE_Rand_1_Bin_Classic;
import algorithms.unconstrained.DE_Rand_1_Either_Or;
import algorithms.unconstrained.DE_Target_to_Best_1_Bin;
import problems.*;
import problems.unconstrained.*;

/**
 * Created by David on 2015-09-17.
 */
public class Start_Unconstrained_DEs {
    public static void main(String[] args) {
        //Setup Simulation
        AbstractAlgorithm[] algorithms = getAlgorithmsList();
        AbstractProblem[] problems = getProblemsList();

        //Run Simulation
        for (int i = 0; i < algorithms.length; i++) {
            System.out.println("Starting " + algorithms[i].getName());
            for (int j = 0; j < problems.length; j++) {
                System.out.println("Starting with run " + j + ": " + problems[j].getName());
                algorithms[i].run(problems[j], 100); //10000
            }
        }
    }


    private static AbstractProblem[] getProblemsList() {
        AbstractProblem[] problems = new AbstractProblem[16];

        problems[0] = new U_Ackley();
        problems[1] = new U_Beale();
        problems[2] = new U_Bohachevsky();
        problems[3] = new U_GoldsteinPrice();
        problems[4] = new U_Griewank();
        problems[5] = new U_Quadric();
        problems[6] = new U_Quartic();
        problems[7] = new U_Rana();
        problems[8] = new U_Rastigrin();
        problems[9] = new U_Rosenbrock();
        problems[10] = new U_Salomon();
        problems[11] = new U_Schwefel2_22();
        problems[12] = new U_Schwefel2_26();
        problems[13] = new U_SixHumpCamelBack();
        problems[14] = new U_Spherical();
        problems[15] = new U_Step();
        return problems;
    }

    private static AbstractAlgorithm[] getAlgorithmsList(){
        AbstractAlgorithm[] algorithmsList = new AbstractAlgorithm[4];

        algorithmsList[0] = new DE_Rand_1_Bin_Classic();
        algorithmsList[1] = new DE_Target_to_Best_1_Bin();
        algorithmsList[2] = new DE_Best_1_Bin();
        algorithmsList[3] = new DE_Rand_1_Either_Or();

        return algorithmsList;
    }
}
