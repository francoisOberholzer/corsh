package parsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

public class Parse_Metrics {
	public static void main(String[] args) {
		String[] titlesInput = new String[5];
		String problem;
		String dimension;
		
		problem = "G01";
		dimension = "13D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G01_Met");
		
		problem = "G02";
		dimension = "20D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G02_Met");
		
		problem = "G03";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G03_Met");
		
		problem = "G04";
		dimension = "5D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G04_Met");
		
		problem = "G05";
		dimension = "4D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G05_Met");
		
		problem = "G06";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G06_Met");
		
		problem = "G07";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G07_Met");
		
		problem = "G08";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G08_Met");
		
		problem = "G09";
		dimension = "7D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G09_Met");
		
		problem = "G10";
		dimension = "8D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G10_Met");
		
		problem = "G11";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G11_Met");
		
		problem = "G12";
		dimension = "3D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G12_Met");
		
		problem = "G13";
		dimension = "5D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G13_Met");
		
		problem = "G14";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G14_Met");
		
		problem = "G15";
		dimension = "3D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G15_Met");
		
		problem = "G16";
		dimension = "5D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G16_Met");
		
		problem = "G17";
		dimension = "6D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G17_Met");
		
		problem = "G18";
		dimension = "9D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G18_Met");
		
		problem = "G19";
		dimension = "15D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G19_Met");
		
		problem = "G20";
		dimension = "24D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G20_Met");
		
		problem = "G21";
		dimension = "7D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G21_Met");
		
		problem = "G22";
		dimension = "22D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G22_Met");
		
		problem = "G23";
		dimension = "9D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G23_Met");
		
		problem = "G24";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G24_Met");
		
		problem = "C01";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C01";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C01";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C02";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C02";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C02";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C03";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C03";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C03";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C04";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C04";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C04";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C05";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C05";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C05";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C06";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C06";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C06";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C07";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C07";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C07";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C08";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C08";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C08";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C09";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C09";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C09";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C10";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C10";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C10";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C11";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C11";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C11";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C12";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C12";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C12";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C13";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C13";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C13";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C14";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C14";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C14";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C15";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C15";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C15";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C16";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C16";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C16";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C17";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C17";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C17";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C18";
		dimension = "2D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C18";
		dimension = "10D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
		
		problem = "C18";
		dimension = "30D";
		titlesInput[0] = "FsR_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "FVC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "PiIZ001_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "PiIZ025_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "RFBx_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension+"_Met");
	}
	
	private static void parse(String[] titles, String problem) {
		//Input
		String line = null;
		
		try {
			PrintWriter writer = new PrintWriter("results_" + problem + ".csv");
			writer.println(problem + ", FsR, FVC, PiIZ001, PiIZ025, RFBx");
			double[] allMetrics = new double[5];
			
			//For each Metric
			for(int i = 0; i < 5; i++) {			
				String title = titles[i];
				System.out.println("Attempting " + title + "...");
				double[] metrics = new double[30];
				
				//Input
				FileReader fileReader = new FileReader(title);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				//Read each Line
				bufferedReader.readLine();
				int index = 0;
				while((line = bufferedReader.readLine()) != null) {
					line = line.replaceAll("\\s+", "");
					String[] parts = line.split(":");
					metrics[index] = Double.parseDouble(parts[3]);
					index++;
	            }   
				
				//Setup for output
				Mean mn = new Mean();
				allMetrics[i] = mn.evaluate(metrics, 0, 30);

	            bufferedReader.close();         
			}
			
			writer.println(" ," + allMetrics[0] + "," + allMetrics[1] + "," + allMetrics[2] + "," + allMetrics[3] + "," + allMetrics[4]);
			
			System.out.println("Finished");
			writer.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + problem + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + problem + "'");                  
        }
	}
}