package general;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import problems.*;

import metrics.*;
import algorithms.*;

public class Start {
	public static void main(String[] args) {
		Object[] optionsProblems = { "CEC2006", "CEC2010"};
		Object selectedProblems = JOptionPane.showInputDialog(null, "Choose one", "Problems", JOptionPane.INFORMATION_MESSAGE, null, optionsProblems, optionsProblems[0]);
		
		Object[] optionsAlgorithm = { "Metrics", "DE Algorithm"};
		Object selectedAlgorithm = JOptionPane.showInputDialog(null, "Choose one", "Algorithm", JOptionPane.INFORMATION_MESSAGE, null, optionsAlgorithm, optionsAlgorithm[0]);
		
		//Problem
		AbstractProblem[] problems;	
		if(selectedProblems.toString().equals("CEC2006")) {
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
		} else if(selectedProblems.toString().equals("CEC2010")) {
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
		} else {
			System.out.println("Problems not initialized");
			return;
		}
		
		//Algorithm
		try {
			PrintWriter writer = new PrintWriter(selectedProblems.toString() + "_" + selectedAlgorithm.toString() + ".txt");
			writer.println("Results for " + selectedAlgorithm.toString() + " as run on " + selectedProblems.toString());
			System.out.println("Performing " + selectedAlgorithm.toString() + " on " + selectedProblems.toString());
			
			if(selectedAlgorithm.toString().equals("Metrics")) {
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");
					
					if(problems[i].getDimension() == -1) {
						FitnessAndViolation.write(problems[i], i);
					}
					writer.println(FVC.write(problems[i], i));
					writer.println(FsR.write(problems[i]));
					writer.println(RFBx.write(problems[i]));
					writer.println(PiIZ_001.write(problems[i]));
					writer.println(PiIZ_025.write(problems[i]));		
				}
				
				System.out.println("Finished.");
			}
			else if(selectedAlgorithm.toString().equals("DE Algorithm")) {
				for(int i = 0; i < problems.length; i++) {
					writer.println();
					writer.println("*****************************************");
					writer.println("Problem: " + (i+1));
					writer.println("*****************************************");
					writer.println();
					System.out.println("Starting Simulation for " + (i+1) + "...");

					writer.println(DE.write(problems[i]));		
				}
				
				System.out.println("Finished.");			
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
}
