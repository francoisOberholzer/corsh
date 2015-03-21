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

		switch (fun) {
            case 1: {
  				funct = new C01();
			}
			break;
			case 2: {
  				funct = new C02();
			}
			break;
			case 3: {
  				funct = new C03();
			}
			break;
			case 4: {
  				funct = new C04();
			}
			break;
			case 5: {
  				funct = new C05();
			}
			break;
			case 6: {
  				funct = new C06();
			}
			break;
			case 7: {
  				funct = new C07();
			}
			break;
			case 8: {
  				funct = new C08();
			}
			break;
			case 9: {
  				funct = new C09();
			}
			break;
			case 10: {
  				funct = new C10();
			}
			break;
			case 11: {
  				funct = new C11();
			}
			break;
			case 12: {
  				funct = new C12();
			}
			break;
			case 13: {
  				funct = new C13();
			}
			break;
			case 14: {
  				funct = new C14();
			}
			break;
			case 15: {
  				funct = new C15();
			}
			break;
			case 16: {
  				funct = new C16();
			}
			break;
			case 17: {
  				funct = new C17();
			}
			break;
			case 18: {
  				funct = new C18();
			}
			break;
			case 19: {
  				funct = new Branin1();
			}
			break;
			case 20: {
  				funct = new Rastrigin1();
			}
			break;
			case 21: {
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
					
					if(funct.getDimension() == -1) {
						FitnessAndViolation.write(funct);
						System.out.println("Fitness and Violation Done...");
					}
					writer.println(FVC.write(funct));
					System.out.println("FVC Done...");
					writer.println(FsR.write(funct));
					System.out.println("FsR Done...");
					writer.println(RFBx.write(funct));
					System.out.println("RFBx Done...");
					writer.println(PiIZ_001.write(funct));
					System.out.println("PiIZ001 Done...");
					writer.println(PiIZ_025.write(funct));		
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
					
					writer.println(DE.write(funct));		
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
