import java.lang.Math;

import org.jgap.Chromosome;
import org.jgap.IChromosome;
import org.jgap.FitnessFunction;

public class GlycoFitnessFunction extends FitnessFunction {
	private static final double	R13 = (1/3),
					R23 = (2/3),
					R43 = (4/3);

	public static String solutuionToString(IChromosome a_chromosome){
		double	E1, E2, E3, ET;
		double	l1, l2, l3, x11, x12, x21, x22, x31, x32;
		l1 = ((Double )(a_chromosome.getGene(0).getAllele())).doubleValue();
		l2 = ((Double )(a_chromosome.getGene(1).getAllele())).doubleValue();
		l3 = ((Double )(a_chromosome.getGene(2).getAllele())).doubleValue();
		x11 = ((Double )(a_chromosome.getGene(3).getAllele())).doubleValue();
		x21 = ((Double )(a_chromosome.getGene(4).getAllele())).doubleValue();
		x31 = 4.0 - x11 - x21;

		x12 = ((Double )(a_chromosome.getGene(5).getAllele())).doubleValue();
		x22 = ((Double )(a_chromosome.getGene(6).getAllele())).doubleValue();
		x32 = 4.0 - x12 - x22;

		double	L1 = l1 * l1, L2 = l2 * l2, L3 = l3 * l3;
		double	L1L2 = Math.sqrt(L1+L2), L1L3 = Math.sqrt(L1+L3),
			L1L2L3 = Math.sqrt(L1+L2+L3), L2L3 = Math.sqrt(L2+L3),
			X11 = Math.sqrt(x11), X12 = Math.sqrt(x12), X21 = Math.sqrt(x21),
			X22 = Math.sqrt(x22), X31 = Math.sqrt(x31), X32 = Math.sqrt(x32);
		E1 = R23*l1
			+ R13*(2*L1L2-l2)
			+ R13*L1L3
			+ R23*(2*L1L2L3 - L2L3)
			- l1*(X11+X12);
		E2 = R23*l2
			+ R13*(2*L1L2-l1)
			+ R13*L2L3
			+ R23*(2*L1L2L3-L1L3)
			- l2*(X21+X22);
		E3 = R13*(L1L3-l1)
			+ R13*(L2L3-l2)
			+ R43*(L1L2L3-L1L2)
			- l3*(X31+X32);
		ET = E1*E1 + E2*E2 + E3*E3;
		String	ret = "";
		ret = "l1="+l1+"\n"+"l2="+l2+"\n"+"l3="+l3+"\n"
			+"x11="+x11+"\n"+"x12="+x12+"\n"+"x21="+x21+"\n"
			+"x22="+x22+"\n"+"x31="+x31+"\n"+"x32="+x32+"\n"
			+"E1="+E1+"\n"+"E2="+E2+"\n"+"E3="+E3+"\n"+"ET="+ET;
		return ret;
	}
	public double evaluate(IChromosome a_chromosome){
		double	E1, E2, E3, ET;
		double	l1, l2, l3, x11, x12, x21, x22, x31, x32;
		l1 = ((Double )(a_chromosome.getGene(0).getAllele())).doubleValue();
		l2 = ((Double )(a_chromosome.getGene(1).getAllele())).doubleValue();
		l3 = ((Double )(a_chromosome.getGene(2).getAllele())).doubleValue();
		x11 = ((Double )(a_chromosome.getGene(3).getAllele())).doubleValue();
		x21 = ((Double )(a_chromosome.getGene(4).getAllele())).doubleValue();
		x31 = 4.0 - x11 - x21;
		if( x31 < 0.0 ) return 1000000000.0;

		x12 = ((Double )(a_chromosome.getGene(5).getAllele())).doubleValue();
		x22 = ((Double )(a_chromosome.getGene(6).getAllele())).doubleValue();
		x32 = 4.0 - x12 - x22;
		if( x32 < 0.0 ) return 1000000000.0;

		double	L1 = l1 * l1, L2 = l2 * l2, L3 = l3 * l3;
		double	L1L2 = Math.sqrt(L1+L2), L1L3 = Math.sqrt(L1+L3),
			L1L2L3 = Math.sqrt(L1+L2+L3), L2L3 = Math.sqrt(L2+L3),
			X11 = Math.sqrt(x11), X12 = Math.sqrt(x12), X21 = Math.sqrt(x21),
			X22 = Math.sqrt(x22), X31 = Math.sqrt(x31), X32 = Math.sqrt(x32);
		E1 = R23*l1
			+ R13*(2*L1L2-l2)
			+ R13*L1L3
			+ R23*(2*L1L2L3 - L2L3)
			- l1*(X11+X12);
		E2 = R23*l2
			+ R13*(2*L1L2-l1)
			+ R13*L2L3
			+ R23*(2*L1L2L3-L1L3)
			- l2*(X21+X22);
		E3 = R13*(L1L3-l1)
			+ R13*(L2L3-l2)
			+ R43*(L1L2L3-L1L2)
			- l3*(X31+X32);
		ET = E1*E1 + E2*E2 + E3*E3;
		return ET;
	}
}
