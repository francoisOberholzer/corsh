package general;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Created by David on 2015-11-05.
 *
 * Used by constrained DEs to print every population, each generation.
 *
 * Print ALL the things!!
 */
public class ProgressionPrinter {

    private int runNumber;
    private int dimensions;
    private String deName;
    private String problemName;
    private String csvString;

    public ProgressionPrinter(int _runNumber, int _dimensions, String _deName, String _problemName){
        runNumber=_runNumber;
        dimensions=_dimensions;
        deName=_deName;
        problemName=_problemName;
        csvString="";
    }

    public void saveGeneration(ArrayList<Vector<Double>> population){
        csvString += population.toString()+ "\n";
    }

    public void printRun(){
        try {
            String dims = ""+dimensions;
            if(dims.length()==1){
                dims = "0"+ dims;
            }
            String run = ""+runNumber;
            if(run.length()==1){
                run = "0"+ run;
            }
            PrintWriter writer = new PrintWriter(deName + "_ON_" + problemName + "_IN_" + dims +"_RUN" + run+ ".csv");

            writer.print(csvString);

            writer.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Error file not found.");
            return;
        }
    }
}
