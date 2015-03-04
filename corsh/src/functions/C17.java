package functions;

import java.util.Vector;

public class C17 extends AbstractFunction {
    private double[] o = new double[]{-0.628245703945122,	0.331024455127249,	0.402617203423807,	0.462742527496583,	-0.513329779137884,	0.288191632492259,	0.41479349370103,	0.916196063289011,	-0.427742767473712,	0.811971694633694,	-0.202953396286476,	0.786617208861492,	-0.583805982901842,	0.91666360939369,	-0.602135912772221,	0.503807046950863,	-0.196264987447976, -0.565579687152807,	0.540878947793462,	0.183666358669345,	-0.303576255198908,	-0.896405440407756,	-0.101939801890135,	-0.049819872322279,	0.434240825173134,	0.946552963504364,	-0.32578927683003,	-0.154255792477949,	0.577967633549953,	-0.573697797217518};
	private final double e = 0.0001;

    public Double f(Vector<Double> x) {
        double[] z;
		double f;

		//Status
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}

		//Function  
	    f = 0.0;

		for (int i = 0; i < x.size()-1; i++) {
			f = f + Math.pow((z[i] - z[i+1]),2);
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double h, g1, g2;

		//Status
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}
		   
		//Constraints  
	    h = 0.0;
		g1 = 1.0;
		g2 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			h = h + z[i] * Math.sin(4*Math.sqrt(Math.abs(z[i])));
			g1 = g1 * z[i];
			g2 = g2 + z[i];
		}

		h = Math.abs(h);

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if ((h - e) <= 0) {
			h = 0;
		}

		return (g1 + g2 + h)/3;
    }
}
