import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Destination implements Serializable {
    private int id;
    private String name;
    private int maxStudents;
    private List<Student> assignedStudents;

    public Destination(int id, String name, int maxStudents) {
        this.id = id;
        this.name = name;
        this.maxStudents = maxStudents;
        this.assignedStudents = new ArrayList<>();
    }

    boolean removeStudent(Student student){
        for(Student s: assignedStudents){
            if(s==student){
                assignedStudents.remove(student);
                return true;
            }
        }
        return false;
    }

    boolean addStudent(Student student){
        if(assignedStudents.size()<maxStudents){
            assignedStudents.add(student);
            return true;
        }
        return false;
    }

    public void setIndex(int id) {
        this.id = id;
    }

    public int getIndex() {
        return id;
    }

    public static List<Destination> getDefaultDestinations() {
        List<Destination> destinations = new ArrayList<>();

        destinations.add(new Destination(1,"Utrecht University", 4));
        destinations.add(new Destination(2,"Edinburgh University", 4));
        destinations.add(new Destination(3,"Imperial College London", 4));
        destinations.add(new Destination(4,"Arizona State University", 4));
        destinations.add(new Destination(5,"Marshall University", 4));
        destinations.add(new Destination(6,"Western Washington University", 4));
        destinations.add(new Destination(7,"Princeton University", 4));
        destinations.add(new Destination(8,"Cornell University", 4));
        destinations.add(new Destination(9,"University of Pennsylvania", 4));
        destinations.add(new Destination(10,"Stanford University", 4));

        return destinations;
    }
    boolean isFull(){
        return assignedStudents.size() == maxStudents;
    }

    public void setAssignedStudents(List<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    public String getName() {
        return name;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Destination other = (Destination) obj;
        return Objects.equals(name, other.name);
    }
}
