import java.lang.Math;
import org.jgap.*;
import org.jgap.impl.*;

public class FindSolutionsToSetOfEquations {
	public static final int MAX_ALLOWED_EVOLUTIONS = 500;

	public static void main(String[] args) throws Exception {
		Configuration conf = new DefaultConfiguration();
		FitnessFunction myFunc = new GlycoFitnessFunction();
		FitnessEvaluator myEvaluator = new GlycoFitnessEvaluator_Minimising();
		conf.setFitnessFunction(myFunc);
		conf.resetProperty(Configuration.PROPERTY_FITEVAL_INST);
		conf.setFitnessEvaluator(myEvaluator);

		Gene[] sampleGenes = new Gene[7];
		int	i = 0, iter;
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 10.0); // l1
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 10.0); // l2
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 10.0); // l3
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 4.0); // x11
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 4.0); // x21
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 4.0); // x12
		sampleGenes[i++] = new DoubleGene(conf, 0.0, 4.0); // x22
		// x31 and x32 are calculated as 4.0 - x11 - x21 (the constraints)
		Chromosome sampleChromosome = new Chromosome(conf, sampleGenes );

		conf.setSampleChromosome( sampleChromosome );
		conf.setPopulationSize( 500 );
		                             
		Genotype population = Genotype.randomInitialGenotype(conf);
		IChromosome bestSolutionSoFar, currentSolution;

		for (iter=1;iter<=MAX_ALLOWED_EVOLUTIONS;iter++) {
			population.evolve();
			currentSolution = population.getFittestChromosome();
/*			if( iter % 100 == 0 ){
				System.out.println("Current solution at iter "+iter+" of "+MAX_ALLOWED_EVOLUTIONS+" a fitness value of " +
					currentSolution.getFitnessValue()
				);
				System.out.println(GlycoFitnessFunction.solutuionToString(currentSolution));
			}
*/
		}
		bestSolutionSoFar = population.getFittestChromosome();
		System.out.println("Starting solution with a fitness value of " +
			bestSolutionSoFar.getFitnessValue()
		);
		System.out.println(GlycoFitnessFunction.solutuionToString(bestSolutionSoFar));
		System.out.println("End solution.");
	}
}
