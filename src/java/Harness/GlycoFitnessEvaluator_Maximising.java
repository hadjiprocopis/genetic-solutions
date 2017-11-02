import java.lang.Math;

import org.jgap.DefaultFitnessEvaluator;

/* maximises the function by reversing the objective */
public class GlycoFitnessEvaluator_Maximising extends DefaultFitnessEvaluator {
	public boolean isFitter(double a_fitness_value1, double a_fitness_value2){
		return a_fitness_value1 > a_fitness_value2;
	}
}
