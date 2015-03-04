package metrics;

import functions.AbstractFunction;
import general.BinaryFlag;
import general.MiscFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class RFBx {
	public static String write(AbstractFunction funct, double min, double max) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		
		double[] result10d = new double[30];
		double[] result30d = new double[30];
		
		for(int i = 0; i < 30; i++) {
			result10d[i] = crossing(funct, min, max, 10);
		}
		
		for(int i = 0; i < 30; i++) {
			result30d[i] = crossing(funct, min, max, 30);
		}
		
		Arrays.sort(result10d);
		Arrays.sort(result30d);
		
		result.append("\nRatio of Feasibility Boundary Crossings \n");
		
		result.append("10D \n");
		result.append("Mean Crossings: " + m.evaluate(result10d, 0, 30) + "\n");
		result.append("Max  Crossings: " + result10d[29] + "\n");
		result.append("Min  Crossings: " + result10d[0] + "\n");
		result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

		result.append("\n30D \n");
		result.append("Mean Crossings: " + m.evaluate(result30d, 0, 30) + "\n");
		result.append("Max  Crossings: " + result30d[29] + "\n");
		result.append("Min  Crossings: " + result30d[0] + "\n");
		result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");

		return result.toString();
	}
	
	private static double crossing(AbstractFunction funct, double min, double max, int dimension) {
		int numSteps = 1000;
		int numWalks = dimension;
		double stepSize = (max-min) * 0.01;
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
	    	    double offset = MiscFunctions.getRandom(0,1)*((max - min)*0.5);
	    	    if (bf.isSet(i))
	    	       temp.add( max - offset);
	            else
	    	       temp.add( min + offset); 
	    	}
	        int randDim = (int)Math.floor(MiscFunctions.getRandom(0,1)*dimension);
		    if (bf.isSet(randDim))
	            temp.set(randDim, max);
	        else
	            temp.set(randDim, min);
				
			//Walk
	        for(int i = 0; i < numSteps; i++) {
	        	steps.add(new Vector<Double>(dimension));
	        	for(int j = 0; j < dimension; j++) {
	        		steps.get(i).add(temp.get(j));
	        		smallRandomChange = (MiscFunctions.getRandom(0,1)*stepSize);
	                
	                if (bf.isSet(j)) 
	                    smallRandomChange = -smallRandomChange;
	
	                newValue = temp.get(j) + smallRandomChange;
	
	                if (newValue < min) {
	                    double diff = min - newValue;
	                    newValue = min + diff;
	                    bf.flipBit(j);
	                }
	                else if (newValue > max) {
	                    double diff = newValue - max;
	                    newValue = max - diff;
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
