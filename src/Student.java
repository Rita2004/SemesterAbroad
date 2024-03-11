import java.util.List;

public class Student {
    private int studentId;
    private List<String> preferences;
    private List<String> selectedDestinations;
    private String assignedDestination;

    public Student(int studentId, List<String> preferences) {
        this.studentId = studentId;
        this.preferences = preferences;
    }

    public int getStudentId() {
        return studentId;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public List<String> getSelectedDestinations() {
        return selectedDestinations;
    }

    public void setSelectedDestinations(List<String> selectedDestinations) {
        this.selectedDestinations = selectedDestinations;
    }

    public String getAssignedDestination() {
        return assignedDestination;
    }

    public void setAssignedDestination(String assignedDestination) {
        this.assignedDestination = assignedDestination;
    }
}
