import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create destinations
        List<Destination> destinations = createDestinations();

        // Create the server
        Server server = new Server(destinations);

        // Connect GUI to the server
        ClientGUI clientGUI = new ClientGUI(server);

        // Run the server
        server.run();
    }

    private static List<Destination> createDestinations() {
        List<Destination> destinations = new ArrayList<>();
        for (String university : Destination.UNIVERSITY_LIST) {
            // You can randomly choose maxStudents between 1 and 5
            int maxStudents = (int) (Math.random() * 5) + 1;
            Destination destination = new Destination(university, maxStudents);
            destinations.add(destination);
        }
        return destinations;
    }
}
