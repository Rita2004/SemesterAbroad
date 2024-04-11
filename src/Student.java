import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Preference> preferences;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.preferences = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void addPreference(Preference preference) {
        this.preferences.add(preference);
    }
}
