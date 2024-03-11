import java.util.Arrays;
import java.util.List;

public class Destination {

    public static final List<String> UNIVERSITY_LIST = Arrays.asList(
            "University of Edinburgh",
            "Peking University",
            "University of Zurich",
            "University of California, Los Angeles (UCLA)",
            "Sorbonne University (Paris)",
            "University of Hong Kong",
            "University of Sydney",
            "Kyoto University",
            "London School of Economics and Political Science (LSE)",
            "Carnegie Mellon University"
    );

    private String name;
    private int maxStudents;
    private int availableSeats;

    public Destination(String name, int maxStudents) {
        this.name = name;
        this.maxStudents = maxStudents;
        this.availableSeats = maxStudents;
    }

    public String getName() {
        return name;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void decreaseAvailableSeats() {
        // Implement logic to decrease available seats when a student is assigned
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
}
