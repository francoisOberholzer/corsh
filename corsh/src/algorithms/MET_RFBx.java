package algorithms;

import general.BinaryFlag;
import general.RandFunctions;
import java.util.ArrayList;
import java.util.Vector;

import problems.AbstractProblem;

public class MET_RFBx extends AbstractAlgorithm {
	public double[] run(AbstractProblem funct, int maxEvaluations) {
		int numSteps = 1000;
		int dimension = funct.getDimension();
		int numWalks = dimension;
		double[] min = funct.getDomainsMin();
		double[] max = funct.getDomainsMax();
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
    	        return null;
    	    }
			
			//Initialize
			for(int i = 0; i < dimension; i++) {
	    	    double offset = RandFunctions.getRandom(0,1)*((max[i] - min[i])*0.5);
	    	    if (bf.isSet(i))
	    	       temp.add(max[i] - offset);
	            else
	    	       temp.add(min[i] + offset); 
	    	}
	        int randDim = (int)Math.floor(RandFunctions.getRandom(0,1)*dimension);
		    if (bf.isSet(randDim))
	            temp.set(randDim, max[randDim]);
	        else
	            temp.set(randDim, min[randDim]);
				
			//Walk
	        for(int i = 0; i < numSteps; i++) {
	        	steps.add(new Vector<Double>(dimension));
	        	for(int j = 0; j < dimension; j++) {
	        		steps.get(i).add(temp.get(j));
	        		smallRandomChange = (RandFunctions.getRandom(0,1)*(max[j]-min[j]) * 0.01);
	                
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
        
		double[] result = new double[2];
		
		result[0] = sumCrossings/numWalks;
		result[1] = 0.0;
		
        return result;
	}
	
	private static boolean validity(double in) {
		if(in < 0.000000001)
			return true;
		else
			return false;
	}
	
	public String getName() { 
		return "RFBx";
	}
}
