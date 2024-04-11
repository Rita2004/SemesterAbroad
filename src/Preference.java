// Preference.java
public class Preference {
    private Student student;
    private Destination destination;
    private int rank;

    public Preference(Student student, Destination destination, int rank) {
        this.student = student;
        this.destination = destination;
        this.rank = rank;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
