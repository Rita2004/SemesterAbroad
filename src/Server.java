import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients;
    private List<Destination> destinations;
    private int port;
    private boolean isRunning;
    private List<Student> students;

    private GeneticAlgorithm geneticAlgorithm;
    private List<Assignment> bestAssignment;


    private AssignmentFrame assignmentFrame;
    public Server(int port) {
        this.port = port;
        clients = new ArrayList<>();
        destinations = Destination.getDefaultDestinations();
        students = new ArrayList<>();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            isRunning = true;
            System.out.println("Server started on port " + port);

            while (isRunning) { // listen constantly to connected clients
                Socket socket = serverSocket.accept();
                System.out.println("Client connected " + socket.getInetAddress());
                ClientHandler clientHandler = new ClientHandler(socket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start(); // start a thread for each student
            }
        } catch (IOException e) {
            System.err.println("Error start " + e.getMessage());
        }
    }

    public void initializeGeneticAlgorithm() {
        this.geneticAlgorithm = new GeneticAlgorithm(this.students, this.destinations, 
        100, 250, 0.8, 0.1);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void genetic() {
        if (assignmentFrame != null) {
            assignmentFrame.dispose();  // Close the previous AssignmentFrame
        }
        initializeGeneticAlgorithm();
        bestAssignment = geneticAlgorithm.run();
        assignmentFrame = new AssignmentFrame(bestAssignment);
    }

    public List<Assignment> getAssignments() {
        return this.bestAssignment;
    }

    public static void main(String[] args) {
        Server server = new Server(2004);
        server.start();
    }
}
