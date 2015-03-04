package general;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import metrics.*;
import functions.*;
import algorithms.*;

public class Start {
	public static void main(String[] args) {
		String input = (String) JOptionPane.showInputDialog(null,"Function:","Harness",JOptionPane.PLAIN_MESSAGE,null,null,"");
		int fun = Integer.parseInt(input);
		AbstractFunction funct = null;
		double min = 0;
		double max = 0;

		switch (fun) {
            case 1: {
				min = 0;
				max = 10;
  				funct = new C01();
			}
			break;
			case 2: {
				min = -5.12;
				max = 5.12;
  				funct = new C02();
			}
			break;
			case 3: {
				min = -1000;
				max = 1000;
  				funct = new C03();
			}
			break;
			case 4: {
				min = -50;
				max = 50;
  				funct = new C04();
			}
			break;
			case 5: {
				min = -600;
				max = 600;
  				funct = new C05();
			}
			break;
			case 6: {
				min = -600;
				max = 600;
  				funct = new C06();
			}
			break;
			case 7: {
				min = -140;
				max = 140;
  				funct = new C07();
			}
			break;
			case 8: {
				min = -140;
				max = 140;
  				funct = new C08();
			}
			break;
			case 9: {
				min = -500;
				max = 500;
  				funct = new C09();
			}
			break;
			case 10: {
				min = -500;
				max = 500;
  				funct = new C10();
			}
			break;
			case 11: {
				min = -100;
				max = 100;
  				funct = new C11();
			}
			break;
			case 12: {
				min = -1000;
				max = 1000;
  				funct = new C12();
			}
			break;
			case 13: {
				min = -500;
				max = 500;
  				funct = new C13();
			}
			break;
			case 14: {
				min = -1000;
				max = 1000;
  				funct = new C14();
			}
			break;
			case 15: {
				min = -1000;
				max = 1000;
  				funct = new C15();
			}
			break;
			case 16: {
				min = -10;
				max = 10;
  				funct = new C16();
			}
			break;
			case 17: {
				min = -10;
				max = 10;
  				funct = new C17();
			}
			break;
			case 18: {
				min = -50;
				max = 50;
  				funct = new C18();
			}
			break;
			case 19: {
				min = 0;
				max = 15;
  				funct = new Branin1();
			}
			break;
			case 20: {
				min = -5;
				max = 5;
  				funct = new Rastrigin1();
			}
			break;
			case 21: {
				min = -150;
				max = 150;
  				funct = new Schwefel1();
			}
			break;
			
			default: System.out.println("ERROR no such function.");
            break;
        }
		
		if (funct == null) {
			System.out.println("ERROR");
		}
		else {
			Object[] options = { "Metrics", "DE Algorithm"};
			Object selectedOption = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			if(selectedOption.toString().equals("Metrics")) {
				try {	
					PrintWriter writer = new PrintWriter("MetricResult" + fun + ".txt");
					System.out.println("Starting Simulation for " + fun + "...");
					
					FitnessAndViolation.write(funct, min, max);
					System.out.println("Fitness and Violation Done...");
					writer.println(FVC.write(funct, min, max));
					System.out.println("FVC Done...");
					writer.println(FsR.write(funct, min, max));
					System.out.println("FsR Done...");
					writer.println(RFBx.write(funct, min, max));
					System.out.println("RFBx Done...");
					writer.println(PiIZ_001.write(funct, min, max));
					System.out.println("PiIZ001 Done...");
					writer.println(PiIZ_025.write(funct, min, max));		
					System.out.println("PiIZ025 Done...");
					
					writer.close();
					System.out.println("Finished.");
				}
				catch (FileNotFoundException fnfe) {
					System.out.println("Error file not found.");
					return;
				}
			}
			else {
				try {	
					PrintWriter writer = new PrintWriter("AlgorithmDE" + fun + ".txt");
					System.out.println("Starting Simulation for " + fun + "...");
					
					writer.println(DE.write(funct, min, max));		
					System.out.println("DE Done...");
					
					writer.close();
					System.out.println("Finished.");
				}
				catch (FileNotFoundException fnfe) {
					System.out.println("Error file not found.");
					return;
				}
			}
			
				
		}
	}
}
