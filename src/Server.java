// Server.java
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Student> students;
    private List<Destination> destinations;

    public Server() {
        students = new ArrayList<>();
        destinations = new ArrayList<>();

        // Initialize your students and destinations here (Replace with your data)

        // Create 10 destinations
        for (int i = 1; i <= 10; i++) {
            destinations.add(new Destination(i, "Destination" + i,  4));
        }

        // Create 40 students
        for (int i = 1; i <= 40; i++) {
            students.add(new Student(i, "Student" + i));
        }
    }


    public Assignment calculateAssignments(List<Preference> preferences) {
        return GeneticAlgorithm.calculate(preferences, students, destinations);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public Destination findDestinationByName(String name) {
        for (Destination destination : destinations) {
            if (destination.getName().equals(name)) {
                return destination;
            }
        }
        return null; // Return null if the destination is not found
    }
}
