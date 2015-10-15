package start;

import algorithms.AbstractAlgorithm;
import algorithms.unconstrained.DE_Best_1_Bin;
import algorithms.unconstrained.DE_Rand_1_Bin_Classic;
import general.Simulation;
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
        Simulation sim = new Simulation(algorithms, problems, 10000);
        sim.run();
    }


    private static AbstractProblem[] getProblemsList() {
        AbstractProblem[] problems = new AbstractProblem[25];

        problems[0] = new U_Ackley();
        problems[1] = new U_Alpine();
        problems[2] = new U_Beale();
        problems[3] = new U_Bohachevsky();
        problems[4] = new U_GoldsteinPrice();
        problems[5] = new U_EggHolder();
        problems[6] = new U_GoldsteinPrice();
        problems[7] = new U_Griewank();
        problems[8] = new U_Levy();
        problems[9] = new U_Michalewicz();
        problems[10] = new U_Pathological();
        problems[11] = new U_Quadric();
        problems[12] = new U_Quartic();
        problems[13] = new U_Rana();
        problems[14] = new U_Rastigrin();
        problems[15] = new U_Rosenbrock();
        problems[16] = new U_Salomon();
        problems[17] = new U_Schwefel2_22();
        problems[18] = new U_Schwefel2_26();
        problems[19] = new U_SixHumpCamelBack();
        problems[20] = new U_SkewRastrigin();
        problems[21] = new U_Spherical();
        problems[22] = new U_Step();
        problems[23] = new U_Weierstrass();
        problems[24] = new U_Zakharov();
        return problems;
    }

    private static AbstractAlgorithm[] getAlgorithmsList(){
        AbstractAlgorithm[] algorithmsList = new AbstractAlgorithm[4];

        algorithmsList[0] = new DE_Rand_1_Bin_Classic();
        //algorithmsList[1] = new DE_Target_to_Best_1_Bin();
        algorithmsList[2] = new DE_Best_1_Bin();
       // algorithmsList[3] = new DE_Rand_1_Either_Or();

        return algorithmsList;
    }
}
