import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ClientGUI {

    private Server server;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField studentIdField;
    private JComboBox<String>[] destinationComboBoxes;

    public ClientGUI(Server server) {
        this.server = server;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Student Assignment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12, 2));

        JLabel studentIdLabel = new JLabel("Enter Student ID:");
        studentIdField = new JTextField();
        mainPanel.add(studentIdLabel);
        mainPanel.add(studentIdField);

        destinationComboBoxes = new JComboBox[5];
        for (int i = 0; i < 5; i++) {
            JLabel destinationLabel = new JLabel("Choose " + (i + 1) + " university:");
            destinationComboBoxes[i] = new JComboBox<>(Destination.UNIVERSITY_LIST.toArray(new String[0]));

            mainPanel.add(destinationLabel);
            mainPanel.add(destinationComboBoxes[i]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = Integer.parseInt(studentIdField.getText());
                String preferences = "";
                for (int i = 0; i < 5; i++) {
                    preferences += destinationComboBoxes[i].getSelectedItem() + ",";
                }
                preferences = preferences.substring(0, preferences.length() - 1); // Remove the trailing comma

                server.handleStudentPreferences(studentId, preferences, null); // Modify parameters as needed
            }
        });

        mainPanel.add(submitButton);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Add other methods as needed
}
