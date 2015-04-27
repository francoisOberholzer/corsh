package metrics;

import general.BinaryFlag;
import general.MiscFunctions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import problems.AbstractProblem;

public class RFBx {
	public static String write(AbstractProblem funct, int id) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		int dimension = funct.getDimension();
		
		if(dimension == -1) {
			double[] result10d = new double[30];
			double[] result30d = new double[30];
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = crossing(funct, 10);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = crossing(funct, 30);
			}
			
			try {
				PrintWriter writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "RFBx_Raw.dat");
				
				writer.println("Raw 10D");
				for(int i = 0; i < 30; i++) {
					writer.println(result10d[i]);
				}
				writer.println("Raw 30D");
				for(int i = 0; i < 30; i++) {
					writer.println(result30d[i]);
				}
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error RAW file not found.");
			}
			
			Arrays.sort(result10d);
			Arrays.sort(result30d);
			
			result.append("\nRatio of Feasibility Boundary Crossings (RFBx)\n");
			
			result.append("10D\n");
			result.append("Mean Crossings: " + m.evaluate(result10d, 0, 30) + "\n");
			result.append("Max  Crossings: " + result10d[29] + "\n");
			result.append("Min  Crossings: " + result10d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

			result.append("\n30D\n");
			result.append("Mean Crossings: " + m.evaluate(result30d, 0, 30) + "\n");
			result.append("Max  Crossings: " + result30d[29] + "\n");
			result.append("Min  Crossings: " + result30d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");
		}
		else {
			double[] resultArray = new double[30];
			
			for(int i = 0; i < 30; i++) {
				resultArray[i] = crossing(funct, dimension);
			}
			
			try {
				PrintWriter writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "RFBx_Raw.dat");

				writer.println("Raw " + dimension + "D");
				for(int i = 0; i < 30; i++) {
					writer.println(resultArray[i]);
				}
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error RAW file not found.");
			}
			
			Arrays.sort(resultArray);
			
			result.append("\nRatio of Feasibility Boundary Crossings (RFBx)\n");
			
			result.append("Mean Crossings: " + m.evaluate(resultArray, 0, dimension) + "\n");
			result.append("Max  Crossings: " + resultArray[29] + "\n");
			result.append("Min  Crossings: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	private static double crossing(AbstractProblem funct, int dimension) {
		int numSteps = 1000;
		int numWalks = dimension;
		double[] min = funct.getDomainsMin();
		double[] max = funct.getDomainsMax();
		//double stepSize = (max-min) * 0.01;
		double newValue = 0;
		double sumCrossings = 0;
		int numStartingZones = (int)Math.pow(2,dimension);
		int numSkips = (int)Math.round(numStartingZones/numWalks);
		BinaryFlag walkSpecifier = new BinaryFlag(dimension);
		
		for(int k = 0; k < numWalks; k++) {
			ArrayList<Vector<Double>> steps = new ArrayList<Vector<Double>>();
			Vector<Double> temp = new Vector<Double>();
			double smallRandomChange = 0;
			BinaryFlag bf = new BinaryFlag(dimension);
			
    	    try {
                walkSpecifier = (BinaryFlag) walkSpecifier.clone();
            }catch(Exception e) {
    	        e.printStackTrace();
    	        return 0;
    	    }
			
			//Initialize
			for(int i = 0; i < dimension; i++) {
	    	    double offset = MiscFunctions.getRandom(0,1)*((max[i] - min[i])*0.5);
	    	    if (bf.isSet(i))
	    	       temp.add(max[i] - offset);
	            else
	    	       temp.add(min[i] + offset); 
	    	}
	        int randDim = (int)Math.floor(MiscFunctions.getRandom(0,1)*dimension);
		    if (bf.isSet(randDim))
	            temp.set(randDim, max[randDim]);
	        else
	            temp.set(randDim, min[randDim]);
				
			//Walk
	        for(int i = 0; i < numSteps; i++) {
	        	steps.add(new Vector<Double>(dimension));
	        	for(int j = 0; j < dimension; j++) {
	        		steps.get(i).add(temp.get(j));
	        		smallRandomChange = (MiscFunctions.getRandom(0,1)*(max[j]-min[j]) * 0.01);
	                
	                if (bf.isSet(j)) 
	                    smallRandomChange = -smallRandomChange;
	
	                newValue = temp.get(j) + smallRandomChange;
	
	                if (newValue < min[j]) {
	                    double diff = min[j] - newValue;
	                    newValue = min[j] + diff;
	                    bf.flipBit(j);
	                }
	                else if (newValue > max[j]) {
	                    double diff = newValue - max[j];
	                    newValue = max[j] - diff;
	                    bf.flipBit(j);
	                }
	                
	                temp.set(j, newValue);
	            }
	        }
	        
	        //Calculate
	        boolean previousValid = validity(funct.violation(steps.get(0)));
	        double counter = 0;
	        
	        for(int i = 1; i < numSteps; i++) {
	        	if(previousValid != validity(funct.violation(steps.get(i)))) {
	        		counter++;
	        	}
	        	previousValid = validity(funct.violation(steps.get(i)));
	        }
	        
	        sumCrossings += counter/(numSteps-1);
	        
	        for(int s = 0; s < numSkips; s++) {
	        	walkSpecifier.next();
	        }
		}
        
        return sumCrossings/numWalks;
	}
	
	private static boolean validity(double in) {
		if(in < 0.000000001)
			return true;
		else
			return false;
	}
}
