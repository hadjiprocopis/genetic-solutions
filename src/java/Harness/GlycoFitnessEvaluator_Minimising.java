import java.lang.Math;

import org.jgap.DefaultFitnessEvaluator;

public class GlycoFitnessEvaluator_Minimising extends DefaultFitnessEvaluator {
	public boolean isFitter(double a_fitness_value1, double a_fitness_value2){
		return a_fitness_value1 < a_fitness_value2;
	}
}
