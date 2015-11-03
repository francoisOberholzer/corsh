package parsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

public class Parse_DE_CHT_Francois {
	public static void main(String[] args) {
		String[] titlesInput = new String[7];
		String problem;
		String dimension;
		
		problem = "G01";
		dimension = "13D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G01");
		
		problem = "G02";
		dimension = "20D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G02");
		
		problem = "G03";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G03");
		
		problem = "G04";
		dimension = "5D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G04");
		
		problem = "G05";
		dimension = "4D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G05");
		
		problem = "G06";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G06");
		
		problem = "G07";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G07");
		
		problem = "G08";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G08");
		
		problem = "G09";
		dimension = "7D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G09");
		
		problem = "G10";
		dimension = "8D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G10");
		
		problem = "G11";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G11");
		
		problem = "G12";
		dimension = "3D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G12");
		
		problem = "G13";
		dimension = "5D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G13");
		
		problem = "G14";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G14");
		
		problem = "G15";
		dimension = "3D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G15");
		
		problem = "G16";
		dimension = "5D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G16");
		
		problem = "G17";
		dimension = "6D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G17");
		
		problem = "G18";
		dimension = "9D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G18");
		
		problem = "G19";
		dimension = "15D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G19");
		
		problem = "G20";
		dimension = "24D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G20");
		
		problem = "G21";
		dimension = "7D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G21");
		
		problem = "G22";
		dimension = "22D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G22");
		
		problem = "G23";
		dimension = "9D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G23");
		
		problem = "G24";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, "G24");
		
		problem = "C01";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C01";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C01";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C02";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C02";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C02";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C03";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C03";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C03";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C04";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C04";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C04";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C05";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C05";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C05";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C06";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C06";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C06";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C07";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C07";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C07";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C08";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C08";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C08";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C09";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C09";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C09";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C10";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C10";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C10";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C11";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C11";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C11";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C12";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C12";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C12";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C13";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C13";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C13";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C14";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C14";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C14";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C15";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C15";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C15";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C16";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C16";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C16";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C17";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C17";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C17";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C18";
		dimension = "2D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C18";
		dimension = "10D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
		
		problem = "C18";
		dimension = "30D";
		titlesInput[0] = "DE_NoCHT_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[1] = "DE_BrickWall_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[2] = "DE_PenaltyMean_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[3] = "DE_PenaltyMax_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[4] = "DE_PieceWiseStd_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[5] = "DE_PieceWisePOC_ON_" + problem + "_" + dimension + "_RAW.txt";
		titlesInput[6] = "DE_PieceWiseEpsilon_ON_" + problem + "_" + dimension + "_RAW.txt";
		parse(titlesInput, problem+"_"+dimension);
	}
	
	private static void parse(String[] titles, String problem) {
		//Input
		String line = null;
		
		try {
			PrintWriter writer = new PrintWriter("results_" + problem + ".csv");
			writer.println(problem + ", FeasibilityRate, MeanFitness, MeanViolation, BestFitness, ViolationForBestFitness");
			
			//For each CHT
			for(int i = 0; i < 7; i++) {			
				String title = titles[i];
				System.out.println("Attempting " + title + "...");
				double[] fitnesses = new double[30];
				double[] violations = new double[30];
				
				//Input
				FileReader fileReader = new FileReader(title);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				//Read each Line
				bufferedReader.readLine();
				int index = 0;
				while((line = bufferedReader.readLine()) != null) {
					line = line.replaceAll("\\s+", "");
					String[] parts = line.split(":");
					fitnesses[index] = Double.parseDouble(parts[0]);
					violations[index] = Double.parseDouble(parts[1]);
					index++;
	            }   
				
				//Setup for output
				double bestFitness = Double.MAX_VALUE;
				double bestViolation = Double.MAX_VALUE;
				for(int j = 0; j < 30; j++) {
					if(fitnesses[j] < bestFitness) {
						bestFitness = fitnesses[j];
						bestViolation = violations[j];
					}
				}
				Mean mn = new Mean();
				double feasibilityRate = 0;
				for(int j = 0; j < 30; j++) {
					if(violations[j] == 0) {
						feasibilityRate++;
					}
				}
				feasibilityRate = (feasibilityRate/30)*100;
				
				//Output
				writer.println(getCHT(i) + "," + feasibilityRate + "," + mn.evaluate(fitnesses, 0, 30) + "," + mn.evaluate(violations, 0, 30) + "," + bestFitness + "," + bestViolation);
				
	            bufferedReader.close();         
			}
			
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
	
	private static String getCHT(int i) {
		if(i == 0) {
			return "NoCHT";
		}
		else if(i == 1) {
			return "BrickWall";
		}
		else if(i == 2) {
			return "PenaltyMean";
		}
		else if(i == 3) {
			return "PenaltyMax";
		}
		else if(i == 4) {
			return "PieceWiseStd";
		}
		else if(i == 5) {
			return "PieceWisePOC";
		}
		else if(i == 6) {
			return "PieceWiseEpsilon";
		}
		return "";
	}
}