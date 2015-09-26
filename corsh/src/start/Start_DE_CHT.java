package start;

import general.Simulation;

import javax.swing.JOptionPane;
import problems.*;
import problems.cec2006.G01;
import problems.cec2006.G02;
import problems.cec2006.G03;
import problems.cec2006.G04;
import problems.cec2006.G05;
import problems.cec2006.G06;
import problems.cec2006.G07;
import problems.cec2006.G08;
import problems.cec2006.G09;
import problems.cec2006.G10;
import problems.cec2006.G11;
import problems.cec2006.G12;
import problems.cec2006.G13;
import problems.cec2006.G14;
import problems.cec2006.G15;
import problems.cec2006.G16;
import problems.cec2006.G17;
import problems.cec2006.G18;
import problems.cec2006.G19;
import problems.cec2006.G20;
import problems.cec2006.G21;
import problems.cec2006.G22;
import problems.cec2006.G23;
import problems.cec2006.G24;
import problems.cec2010.C01_10D;
import problems.cec2010.C01_2D;
import problems.cec2010.C01_30D;
import problems.cec2010.C02_10D;
import problems.cec2010.C02_2D;
import problems.cec2010.C02_30D;
import problems.cec2010.C03_10D;
import problems.cec2010.C03_2D;
import problems.cec2010.C03_30D;
import problems.cec2010.C04_10D;
import problems.cec2010.C04_2D;
import problems.cec2010.C04_30D;
import problems.cec2010.C05_10D;
import problems.cec2010.C05_2D;
import problems.cec2010.C05_30D;
import problems.cec2010.C06_10D;
import problems.cec2010.C06_2D;
import problems.cec2010.C06_30D;
import problems.cec2010.C07_10D;
import problems.cec2010.C07_2D;
import problems.cec2010.C07_30D;
import problems.cec2010.C08_10D;
import problems.cec2010.C08_2D;
import problems.cec2010.C08_30D;
import problems.cec2010.C09_10D;
import problems.cec2010.C09_2D;
import problems.cec2010.C09_30D;
import problems.cec2010.C10_10D;
import problems.cec2010.C10_2D;
import problems.cec2010.C10_30D;
import problems.cec2010.C11_10D;
import problems.cec2010.C11_2D;
import problems.cec2010.C11_30D;
import problems.cec2010.C12_10D;
import problems.cec2010.C12_2D;
import problems.cec2010.C12_30D;
import problems.cec2010.C13_10D;
import problems.cec2010.C13_2D;
import problems.cec2010.C13_30D;
import problems.cec2010.C14_10D;
import problems.cec2010.C14_2D;
import problems.cec2010.C14_30D;
import problems.cec2010.C15_10D;
import problems.cec2010.C15_2D;
import problems.cec2010.C15_30D;
import problems.cec2010.C16_10D;
import problems.cec2010.C16_2D;
import problems.cec2010.C16_30D;
import problems.cec2010.C17_10D;
import problems.cec2010.C17_2D;
import problems.cec2010.C17_30D;
import problems.cec2010.C18_10D;
import problems.cec2010.C18_2D;
import problems.cec2010.C18_30D;
import algorithms.*;
import algorithms.cht.DE_0_NoCHT;
import algorithms.cht.DE_1_Brickwall;
import algorithms.cht.DE_2_Penalty_Mean;
import algorithms.cht.DE_3_Penalty_Max;
import algorithms.cht.DE_4_PieceWise_Standard;
import algorithms.cht.DE_5_PieceWise_POC;
import algorithms.cht.DE_6_PieceWise_Epsilon;
import algorithms.metrics.MET_FVC;
import algorithms.metrics.MET_FsR;
import algorithms.metrics.MET_PiIZ_001;
import algorithms.metrics.MET_PiIZ_025;
import algorithms.metrics.MET_RFBx;

public class Start_DE_CHT {
	public static void main(String[] args) {
		Object selectedDE = null;
		
		//Input Options for use in Simulation
		//Metrics or Algorithms?
		Object[] optionsType = {"Metrics", "DE"};
		Object selectedType = JOptionPane.showInputDialog(null, "What do you want to do?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsType, optionsType[0]);
		
		//If choose Algorithm
		if(selectedType.toString().equals("DE")) {
			Object[] optionsDE = {"NoCHT", "BrickWall", "PenaltyMean", "PenaltyMax", "PieceWiseStandard", "PieceWisePOC", "PieceWiseEpsilon"};
			selectedDE = JOptionPane.showInputDialog(null, "Which Constraint Handling Technique do you want to use?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsDE, optionsDE[0]);
		}
		
		//Which problems to use?
		Object[] optionsProblems = { "CEC2006", "CEC2010", "ALL"}; //Problems
		Object selectedProblems = JOptionPane.showInputDialog(null, "Which Problems Set do you want to use?", "CORSH", JOptionPane.INFORMATION_MESSAGE, null, optionsProblems, optionsProblems[0]);
		
		//Setup Simulation
		AbstractAlgorithm[] algorithms = getAlgorithmsList(selectedType.toString(), selectedDE.toString());
		AbstractProblem[] problems = getProblemsList(selectedProblems.toString());
		Simulation sim;
		if(selectedType.toString().equals("Algorithm")) {
			sim = new Simulation(algorithms, problems, 10000);
		}
		else {
			sim = new Simulation(algorithms, problems, 1000);
		}
		
		//Run Simulation
		sim.run();
		//End
	}	
	
	//Initializes list of algorithms to use
	private static AbstractAlgorithm[] getAlgorithmsList(String type, String set) {
		AbstractAlgorithm[] algorithms = new AbstractAlgorithm[1];
		
		if(type.equals("Metrics")) {
			algorithms = new AbstractAlgorithm[5];
			algorithms[1] = new MET_FVC();
			algorithms[2] = new MET_FsR();
			algorithms[3] = new MET_RFBx();
			algorithms[4] = new MET_PiIZ_001();
			algorithms[5] = new MET_PiIZ_025();
		}
		else if(set.equals("NoCHT")) {
			algorithms[0] = new DE_0_NoCHT();
		}
		else if(set.equals("BrickWall")) {
			algorithms[0] = new DE_1_Brickwall();
		}
		else if(set.equals("PenaltyMean")) {
			algorithms[0] = new DE_2_Penalty_Mean();
		}
		else if(set.equals("PenaltyMax")) {
			algorithms[0] = new DE_3_Penalty_Max();
		}
		else if(set.equals("PieceWiseStandard")) {
			algorithms[0] = new DE_4_PieceWise_Standard();
		}
		else if(set.equals("PieceWisePOC")) {
			algorithms[0] = new DE_5_PieceWise_POC();
		}
		else if(set.equals("PieceWiseEpsilon")) {
			algorithms[0] = new DE_6_PieceWise_Epsilon();
		}
		
		return algorithms;
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
			problems = new AbstractProblem[54];
			problems[0] = new C01_2D();
			problems[1] = new C02_2D();
			problems[2] = new C03_2D();
			problems[3] = new C04_2D();
			problems[4] = new C05_2D();
			problems[5] = new C06_2D();
			problems[6] = new C07_2D();
			problems[7] = new C08_2D();
			problems[8] = new C09_2D();
			problems[9] = new C10_2D();
			problems[10] = new C11_2D();
			problems[11] = new C12_2D();
			problems[12] = new C13_2D();
			problems[13] = new C14_2D();
			problems[14] = new C15_2D();
			problems[15] = new C16_2D();
			problems[16] = new C17_2D();
			problems[17] = new C18_2D();
			problems[18] = new C01_10D();
			problems[19] = new C02_10D();
			problems[20] = new C03_10D();
			problems[21] = new C04_10D();
			problems[22] = new C05_10D();
			problems[23] = new C06_10D();
			problems[24] = new C07_10D();
			problems[25] = new C08_10D();
			problems[26] = new C09_10D();
			problems[27] = new C10_10D();
			problems[28] = new C11_10D();
			problems[29] = new C12_10D();
			problems[30] = new C13_10D();
			problems[31] = new C14_10D();
			problems[32] = new C15_10D();
			problems[33] = new C16_10D();
			problems[34] = new C17_10D();
			problems[35] = new C18_10D();
			problems[36] = new C01_30D();
			problems[37] = new C02_30D();
			problems[38] = new C03_30D();
			problems[39] = new C04_30D();
			problems[40] = new C05_30D();
			problems[41] = new C06_30D();
			problems[42] = new C07_30D();
			problems[43] = new C08_30D();
			problems[44] = new C09_30D();
			problems[45] = new C10_30D();
			problems[46] = new C11_30D();
			problems[47] = new C12_30D();
			problems[48] = new C13_30D();
			problems[49] = new C14_30D();
			problems[50] = new C15_30D();
			problems[51] = new C16_30D();
			problems[52] = new C17_30D();
			problems[53] = new C18_30D();
		}
		else {
			problems = new AbstractProblem[78];
			problems[0] = new C01_2D();
			problems[1] = new C02_2D();
			problems[2] = new C03_2D();
			problems[3] = new C04_2D();
			problems[4] = new C05_2D();
			problems[5] = new C06_2D();
			problems[6] = new C07_2D();
			problems[7] = new C08_2D();
			problems[8] = new C09_2D();
			problems[9] = new C10_2D();
			problems[10] = new C11_2D();
			problems[11] = new C12_2D();
			problems[12] = new C13_2D();
			problems[13] = new C14_2D();
			problems[14] = new C15_2D();
			problems[15] = new C16_2D();
			problems[16] = new C17_2D();
			problems[17] = new C18_2D();
			problems[18] = new C01_10D();
			problems[19] = new C02_10D();
			problems[20] = new C03_10D();
			problems[21] = new C04_10D();
			problems[22] = new C05_10D();
			problems[23] = new C06_10D();
			problems[24] = new C07_10D();
			problems[25] = new C08_10D();
			problems[26] = new C09_10D();
			problems[27] = new C10_10D();
			problems[28] = new C11_10D();
			problems[29] = new C12_10D();
			problems[30] = new C13_10D();
			problems[31] = new C14_10D();
			problems[32] = new C15_10D();
			problems[33] = new C16_10D();
			problems[34] = new C17_10D();
			problems[35] = new C18_10D();
			problems[36] = new C01_30D();
			problems[37] = new C02_30D();
			problems[38] = new C03_30D();
			problems[39] = new C04_30D();
			problems[40] = new C05_30D();
			problems[41] = new C06_30D();
			problems[42] = new C07_30D();
			problems[43] = new C08_30D();
			problems[44] = new C09_30D();
			problems[45] = new C10_30D();
			problems[46] = new C11_30D();
			problems[47] = new C12_30D();
			problems[48] = new C13_30D();
			problems[49] = new C14_30D();
			problems[50] = new C15_30D();
			problems[51] = new C16_30D();
			problems[52] = new C17_30D();
			problems[53] = new C18_30D();
			problems[54] = new G01();
			problems[55] = new G02();
			problems[56] = new G03();
			problems[57] = new G04();
			problems[58] = new G05();
			problems[59] = new G06();
			problems[60] = new G07();
			problems[61] = new G08();
			problems[62] = new G09();
			problems[63] = new G10();
			problems[64] = new G11();
			problems[65] = new G12();
			problems[66] = new G13();
			problems[67] = new G14();
			problems[68] = new G15();
			problems[69] = new G16();
			problems[70] = new G17();
			problems[71] = new G18();
			problems[72] = new G19();
			problems[73] = new G20();
			problems[74] = new G21();
			problems[75] = new G22();
			problems[76] = new G23();
			problems[77] = new G24();
		}
		
		return problems;
	}
}