import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Destination> destinations;
    private List<Student> students;

    public Server(List<Destination> destinations) {
        this.destinations = destinations;
        this.students = new ArrayList<>();
    }

    public void run() {
        // Implement server logic here
        // This can include handling requests from clients, recalculating assignments, etc.
    }

    public void handleStudentPreferences(int studentId, String preferences, List<String> selectedDestinations) {
        List<String> preferencesList = List.of(preferences.split(","));
        Student newStudent = new Student(studentId, preferencesList);
        newStudent.setSelectedDestinations(selectedDestinations);
        students.add(newStudent);
        System.out.println("Student " + studentId + " preferences submitted: " + preferences + ", selected destinations: " + selectedDestinations);

        // Implement logic to recalculate assignments and update GUI
    }

    // Add other methods as needed
}
