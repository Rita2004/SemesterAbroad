import java.util.HashMap;
import java.util.Map;

public class Assignment implements Comparable<Assignment> {
    private Map<Student, Destination> studentAssignments;

    public Assignment() {
        this.studentAssignments = new HashMap<>();
    }

    public Map<Student, Destination> getStudentAssignments() {
        return studentAssignments;
    }

    public void setStudentAssignments(Map<Student, Destination> studentAssignments) {
        this.studentAssignments = studentAssignments;
    }

    public void addAssignment(Student student, Destination destination) {
        this.studentAssignments.put(student, destination);
    }

    public Destination getDestination(Student student) {
        return this.studentAssignments.get(student);
    }

    @Override
    public int compareTo(Assignment other) {
        int fitnessThis = GeneticAlgorithm.calculateFitness(this);
        int fitnessOther = GeneticAlgorithm.calculateFitness(other);
        return Integer.compare(fitnessThis, fitnessOther);
    }
}
