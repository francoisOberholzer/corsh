package start;

import algorithms.AbstractAlgorithm;
import algorithms.unconstrained.*;
import general.Simulation;
import problems.*;
import problems.unconstrained.*;

import java.util.ArrayList;

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
        ArrayList<AbstractProblem> pl = new ArrayList<AbstractProblem>(); //problemsList

        //Beale?Goldstein?SixHump?

        int[] dimensions = {1, 2, 5, 10, 15, 30};

        for (int i = 0; i < dimensions.length; i++) {

            //1, 2, 5, 10, 15, 30
            pl.add(new U_Ackley(dimensions[i]));
            pl.add(new U_Alpine(dimensions[i]));
            pl.add(new U_Griewank(dimensions[i]));
            pl.add(new U_Quadric(dimensions[i]));
            pl.add(new U_Quartic(dimensions[i]));
            pl.add(new U_Rastrigrin(dimensions[i]));
            pl.add(new U_Salomon(dimensions[i]));
            pl.add(new U_Schwefel2_22(dimensions[i]));
            pl.add(new U_Schwefel2_26(dimensions[i]));
            pl.add(new U_SkewRastrigin(dimensions[i]));
            pl.add(new U_Spherical(dimensions[i]));
            pl.add(new U_Step(dimensions[i]));
            pl.add(new U_Weierstrass(dimensions[i]));

            //2, 5, 10, 15, 30
            if(dimensions[i] > 1) {
                pl.add(new U_Bohachevsky(dimensions[i]));
                pl.add(new U_Levy(dimensions[i]));
                pl.add(new U_Pathological(dimensions[i]));
                pl.add(new U_Rana(dimensions[i]));
                pl.add(new U_Rosenbrock(dimensions[i]));
                pl.add(new U_Zakharov(dimensions[i]));

                //2, 5, 10, 30
                if (dimensions[i] != 15){
                    pl.add(new U_Michalewicz(dimensions[i]));
                }
            }
        }


        AbstractProblem[] problems = new AbstractProblem[pl.size()];
        for (int i = 0; i < pl.size(); i++) {
            problems[i] = pl.get(i);
        }

        return problems;
    }

    private static AbstractAlgorithm[] getAlgorithmsList(){
        AbstractAlgorithm[] algorithmsList = new AbstractAlgorithm[5];

        algorithmsList[0] = new DE_Best_1_Bin();
        algorithmsList[1] = new DE_Best_1_Bin_Jitter();
        algorithmsList[2] = new DE_Rand_1_Bin_Classic();
        algorithmsList[3] = new DE_Rand_1_Either_Or();
        algorithmsList[4] = new DE_Target_to_Best_1_Bin();

        return algorithmsList;
    }
}
