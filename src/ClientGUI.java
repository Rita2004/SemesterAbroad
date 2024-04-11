import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClientGUI extends JFrame {
    private Server server;

    // GUI Components
    private JPanel inputPanel;
    private JTextField studentIdField;
    private JComboBox<String>[] preferenceComboBoxes;
    private JButton calculateButton;

    public ClientGUI() {
        super("Student Assignment Optimizer");
        server = new Server();

        initializeGUI();
    }

    private void initializeGUI() {
        // Setup input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2)); // 7 rows: 1 student ID + 5 preferences + 1 button
        setupInputComponents();

        // Setup button
        calculateButton = new JButton("Calculate Assignments");
        calculateButton.addActionListener(e -> calculateAssignments());

        // Add panels, button to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.CENTER);
    }

    private void setupInputComponents() {
        // Add student ID field
        JLabel studentIdLabel = new JLabel("Student ID:");
        inputPanel.add(studentIdLabel);
        studentIdField = new JTextField();
        inputPanel.add(studentIdField);

        // Add preference dropdown lists
        preferenceComboBoxes = new JComboBox[5];
        for (int i = 0; i < 5; i++) {
            JLabel preferenceLabel = new JLabel("Preference " + (i + 1) + ":");
            inputPanel.add(preferenceLabel);

            preferenceComboBoxes[i] = new JComboBox<>();
            for (Destination destination : server.getDestinations()) {
                preferenceComboBoxes[i].addItem(destination.getName());
            }
            inputPanel.add(preferenceComboBoxes[i]);
        }
    }

    private void calculateAssignments() {
        // Get student ID from the field
        int studentId;
        try {
            studentId = Integer.parseInt(studentIdField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Gather preferences for the student
        List<Preference> preferences = new ArrayList<>();
        for (JComboBox<String> comboBox : preferenceComboBoxes) {
            String selectedDestination = (String) comboBox.getSelectedItem();
            if (selectedDestination != null) {
                Destination destination = server.findDestinationByName(selectedDestination);
                if (destination != null) {
                    preferences.add(new Preference(new Student(studentId, ""), destination, 0)); // Rank not used in this context
                }
            }
        }

        // Calculate assignments based on preferences
        Assignment assignment = server.calculateAssignments(preferences);
        if (assignment != null) {
            displayAssignment(assignment);
        } else {
            JOptionPane.showMessageDialog(this, "Error calculating assignments!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayAssignment(Assignment assignment) {
        StringBuilder resultText = new StringBuilder("Assignments:\n");
        boolean foundAssignment = false;
    
        for (Student student : server.getStudents()) {
            Destination assignedDestination = assignment.getDestination(student);
            if (assignedDestination != null) {
                resultText.append(student.getName()).append(" is assigned to ").append(assignedDestination.getName()).append("\n");
                foundAssignment = true;
            }
        }
    
        if (!foundAssignment) {
            resultText.append("No assignments found for the submitted preferences.");
        }
    
        JOptionPane.showMessageDialog(this, resultText.toString(), "Assignment Result", JOptionPane.INFORMATION_MESSAGE);
    }
    

    public static void main(String[] args) {
        ClientGUI clientGUI = new ClientGUI();
        clientGUI.setSize(400, 300);
        clientGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientGUI.setVisible(true);
    }
}

