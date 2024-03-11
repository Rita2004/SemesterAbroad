import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneticAlgorithm {

    private List<Student> population;
    private List<Destination> destinations;

    public List<Student> getPopulation() {
        return population;
    }

    public GeneticAlgorithm(List<Student> population, List<Destination> destinations) {
        this.population = population;
        this.destinations = destinations;
    }

    public void evolve() {
        for (int generation = 0; generation < 100; generation++) {
            evaluateFitness();
            List<Student> parents = selectParents();
            List<Student> offspring = crossover(parents);
            mutate(offspring);
            population = offspring;
            updateAssignments();
        }
    }

    private void evaluateFitness() {
        for (Student student : population) {
            // Implement your fitness evaluation logic here
        }
    }

    private List<Student> selectParents() {
        List<Student> parents = new ArrayList<>();

        for (int i = 0; i < population.size(); i++) {
            int randomIndex1 = (int) (Math.random() * population.size());
            int randomIndex2 = (int) (Math.random() * population.size());

            Student candidate1 = population.get(randomIndex1);
            Student candidate2 = population.get(randomIndex2);

            // Select the fitter candidate
            Student selectedParent = (Math.random() < 0.5) ? candidate1 : candidate2;
            parents.add(selectedParent);
        }

        return parents;
    }

    private List<Student> crossover(List<Student> parents) {
        List<Student> offspring = new ArrayList<>();

        for (int i = 0; i < parents.size(); i += 2) {
            int crossoverPoint = (int) (Math.random() * parents.get(i).getPreferences().size());

            List<String> genes1 = new ArrayList<>(parents.get(i).getPreferences().subList(0, crossoverPoint));
            genes1.addAll(parents.get(i + 1).getPreferences().subList(crossoverPoint, parents.get(i + 1).getPreferences().size()));

            List<String> genes2 = new ArrayList<>(parents.get(i + 1).getPreferences().subList(0, crossoverPoint));
            genes2.addAll(parents.get(i).getPreferences().subList(crossoverPoint, parents.get(i).getPreferences().size()));

            offspring.add(new Student(-1, genes1));
            offspring.add(new Student(-1, genes2));
        }

        return offspring;
    }

    private void mutate(List<Student> offspring) {
        for (Student student : offspring) {
            for (int i = 0; i < student.getPreferences().size(); i++) {
                if (Math.random() < 0.1) {
                    Collections.swap(student.getPreferences(), i, (int) (Math.random() * student.getPreferences().size()));
                }
            }
        }
    }

    private void updateAssignments() {
        for (Student student : population) {
            List<String> preferences = student.getPreferences();
            if (!preferences.isEmpty()) {
                String assignedDestination = preferences.get(0);
                student.setAssignedDestination(assignedDestination);
            }
        }
    }
}
