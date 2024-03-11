import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentGenerator {

    public static List<Student> generateStudents(int numberOfStudents, List<Destination> destinations) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= numberOfStudents; i++) {
            int numberOfPreferences = random.nextInt(5) + 1; // Random value between 1 and 5
            List<String> preferences = generateRandomPreferences(destinations, numberOfPreferences);

            students.add(new Student(i, preferences));
        }

        return students;
    }

    private static List<String> generateRandomPreferences(List<Destination> destinations, int numberOfPreferences) {
        List<String> preferences = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfPreferences; i++) {
            Destination randomDestination = destinations.get(random.nextInt(destinations.size()));
            preferences.add(randomDestination.getName());
        }

        return preferences;
    }
}
