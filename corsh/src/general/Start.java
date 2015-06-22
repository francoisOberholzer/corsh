package general;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import problems.*;

import metrics.*;
import algorithms.*;

public class Start {
	public static void main(String[] args) {
		Object selectedDE = null;
		Object selectedEvaluations = null;
		
		//Input Options for use in Simulation
		Object[] optionsIntention = { "ALL", "Metrics", "DE"}; //Options
		Object selectedIntention = JOptionPane.showInputDialog(null, "What do you want to do?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsIntention, optionsIntention[0]);
		
		if(selectedIntention.toString().equals("DE") || selectedIntention.toString().equals("ALL")) { //DE Options
			Object[] optionsDE = { "ALL", "NONE", "DeathPenalty", "Penalty", "PieceWise"}; //Constraint Handling Options
			selectedDE = JOptionPane.showInputDialog(null, "Which Constraint Handling Technique do you want to use?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsDE, optionsDE[0]);
		
			Object[] optionsEvaluations = { "500000", "100000", "50000", "10000"}; //FunctionEvaluations
			selectedEvaluations = JOptionPane.showInputDialog(null, "What is the maximum amount of Function Evaluations?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsEvaluations, optionsEvaluations[0]);
		}
		
		Object[] optionsProblems = { "CEC2006", "CEC2010"}; //Problems
		Object selectedProblems = JOptionPane.showInputDialog(null, "Which Problems do you want to use?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsProblems, optionsProblems[0]);
		AbstractProblem[] problems = getProblemsList(selectedProblems.toString());
		
		//Run Simulation
		if(selectedIntention.toString().equals("Metrics")) { 
			runMetrics(selectedProblems.toString(), problems);
		}
		else if(selectedIntention.toString().equals("DE")) { 
			runDE(selectedProblems.toString(), problems, selectedDE.toString(), Integer.parseInt(selectedEvaluations.toString()));
		}
		else { //All
			runMetrics(selectedProblems.toString(), problems);
			runDE(selectedProblems.toString(), problems, selectedDE.toString(), Integer.parseInt(selectedEvaluations.toString()));
		}
	}	
	
	//Run Metrics on problems, input problem set title and list of AbstractProblems
	private static void runMetrics(String problemSet, AbstractProblem[] problems) {
		try {
			PrintWriter writer = new PrintWriter(problemSet + "_" + "Metrics.txt");
			writer.println("Results for Metrics as run on " + problemSet);
			System.out.println("Performing Metrics on " + problemSet);
			
			for(int i = 0; i < problems.length; i++) {
				writer.println();
				writer.println("*****************************************");
				writer.println("Problem: " + (i+1));
				writer.println("*****************************************");
				writer.println();
				System.out.println("Starting Simulation for " + (i+1) + "...");
				
				if((problems[i].getDimension() == -1) || (problems[i].getDimension() == 2)) {
					FitnessAndViolation.write(problems[i], i);
				}
				writer.println(FVC.write(problems[i], i));
				writer.println(FsR.write(problems[i], i));
				writer.println(RFBx.write(problems[i], i));
				writer.println(PiIZ_001.write(problems[i], i));
				writer.println(PiIZ_025.write(problems[i], i));		
			}
			
			System.out.println("Finished.");
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	//Run DE on problems, input problem set title, list of AbstractProblems, chosen technique and number of max evaluations before stopping
	private static void runDE(String problemSet, AbstractProblem[] problems, String constrainHandlingTechnique, int maxEvaluations) {
		if(constrainHandlingTechnique.equals("ALL")) {
			try {
				PrintWriter writer = new PrintWriter(problemSet + "_DE_NONE.txt");
				writer.println("Results for DE as run on " + problemSet);
				System.out.println("Performing DE on " + problemSet);
				
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");
				}
				
				System.out.println("Finished.");		
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error file not found.");
				return;
			}
			try {
				PrintWriter writer = new PrintWriter(problemSet + "_DE_DeathPenalty.txt");
				writer.println("Results for DE as run on " + problemSet);
				System.out.println("Performing DE on " + problemSet);
				
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");

					writer.println(DE.write(problems[i], 1, i, maxEvaluations));		
				}
				
				System.out.println("Finished.");		
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error file not found.");
				return;
			}
			try {
				PrintWriter writer = new PrintWriter(problemSet + "_DE_Penalty.txt");
				writer.println("Results for DE as run on " + problemSet);
				System.out.println("Performing DE on " + problemSet);
				
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");

					writer.println(DE.write(problems[i], 2, i, maxEvaluations));		
				}
				
				System.out.println("Finished.");		
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error file not found.");
				return;
			}
			try {
				PrintWriter writer = new PrintWriter(problemSet + "_DE_PieceWise.txt");
				writer.println("Results for DE as run on " + problemSet);
				System.out.println("Performing DE on " + problemSet);
				
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");

					writer.println(DE.write(problems[i], 3, i, maxEvaluations));		
				}
				
				System.out.println("Finished.");		
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error file not found.");
				return;
			}
		}
		else {
			int cht = 0;
			if(constrainHandlingTechnique.equals("DeathPenalty")) {
				cht = 1;
			}
			else if(constrainHandlingTechnique.equals("Penalty")) {
				cht = 2;
			}
			else if(constrainHandlingTechnique.equals("PieceWise")) {
				cht = 3;
			}
				
			try {
				PrintWriter writer = new PrintWriter(problemSet + "_DE_" + constrainHandlingTechnique + ".txt");
				writer.println("Results for DE as run on " + problemSet);
				System.out.println("Performing DE on " + problemSet);
				
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");

					writer.println(DE.write(problems[i], cht, i, maxEvaluations));		
				}
				
				System.out.println("Finished.");		
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error file not found.");
				return;
			}
		}	
	}
	
	//Initializes list of problems to use
	private static AbstractProblem[] getProblemsList(String set) {
		AbstractProblem[] problems = null;
		
		if(set.equals("CEC2006")) {
			problems = new AbstractProblem[24];
			problems[0] = new G01();
			problems[1] = new G02();
			problems[2] = new G03();
			problems[3] = new G04();
			problems[4] = new G05();
			problems[5] = new G06();
			problems[6] = new G07();
			problems[7] = new G08();
			problems[8] = new G09();
			problems[9] = new G10();
			problems[10] = new G11();
			problems[11] = new G12();
			problems[12] = new G13();
			problems[13] = new G14();
			problems[14] = new G15();
			problems[15] = new G16();
			problems[16] = new G17();
			problems[17] = new G18();
			problems[18] = new G19();
			problems[19] = new G20();
			problems[20] = new G21();
			problems[21] = new G22();
			problems[22] = new G23();
			problems[23] = new G24();
		} 
		else if(set.equals("CEC2010")) {
			problems = new AbstractProblem[18];
			problems[0] = new C01();
			problems[1] = new C02();
			problems[2] = new C03();
			problems[3] = new C04();
			problems[4] = new C05();
			problems[5] = new C06();
			problems[6] = new C07();
			problems[7] = new C08();
			problems[8] = new C09();
			problems[9] = new C10();
			problems[10] = new C11();
			problems[11] = new C12();
			problems[12] = new C13();
			problems[13] = new C14();
			problems[14] = new C15();
			problems[15] = new C16();
			problems[16] = new C17();
			problems[17] = new C18();
		}
		
		return problems;
	}
}
