package general;

import problems.*;
import algorithms.*;

public class StartGraphs {
	public static void main(String[] args) {
		MET_FVC algorithm = new MET_FVC();
		AbstractProblem[] problems = null;	
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
		
		for(int i = 0; i < 78; i++) {
			double[][] result = algorithm.runGraph(problems[i]);
			Print.printFVC(problems[i].getName(), result);
		}
	}
}
