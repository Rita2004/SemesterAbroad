import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private List<Destination> preferences;
    private Destination assignedDest;

    public Student() {
        preferences = new ArrayList<>();
    }

    public Student(String name) {
        this.name = name;
        preferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPreference(Destination destination) {
        this.preferences.add(destination);
    }

    public List<Destination> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Destination> preferences) {
        this.preferences = preferences;
    }

    public Destination getAssignedDest() {
        return assignedDest;
    }

    public void setAssignedDest(Destination assignedDest) {
        this.assignedDest = assignedDest;
    }
}
