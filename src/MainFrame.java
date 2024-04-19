import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    JLabel title, name, preferencesLabel, label;
    JTextArea textid, textname;
    JButton submit;
    private final JTextArea preferencesTextArea;
    private final JLabel inputErrorLabel;

    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,700);
        this.getContentPane().setBackground(Color.decode("#b8c9d1"));
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        title = new JLabel("STUDENT ASSIGNMENT");
        title.setBounds(100, 10, 500, 100);
        title.setFont(new Font("", Font.BOLD, 28));
        this.add(title);

        name = new JLabel("Name:");
        name.setBounds(100,50,300,100);
        name.setFont(new Font("Verdana", Font.BOLD, 17));
        this.add(name);

        textname = new JTextArea();
        textname.setBounds(100, 115, 170, 25);
        textname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textname.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(textname);

        preferencesLabel = new JLabel("Preferences:");
        preferencesLabel.setBounds(100, 150, 300, 25);
        preferencesLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        this.add(preferencesLabel);

        preferencesTextArea = new JTextArea();
        preferencesTextArea.setBounds(100, 185, 170, 25);
        preferencesTextArea.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(preferencesTextArea);

        label = new JLabel("<html>Example: 2 5 7 (Use spaces to seperate destination indexes)</html>");
        label.setBounds(100, 190, 900, 100);
        label.setFont(new Font("Verdana", Font.PLAIN, 17));
        this.add(label);

        inputErrorLabel = new JLabel();
        inputErrorLabel.setForeground(Color.decode("#ba0606"));
        inputErrorLabel.setBounds(100, 220, 200, 25);
        this.add(inputErrorLabel);

        submit = new JButton("Submit");
        submit.setBounds(140, 260, 100, 35);
        submit.setBackground(Color.decode("#8D89A6"));
        submit.setFont(new Font("Verdana", Font.PLAIN, 17));
        submit.setForeground(Color.white);
        this.add(submit);

        List<Destination> destinations = Destination.getDefaultDestinations();

        String destinationsText = "";
        for (Destination destination : destinations) {
            destinationsText += " " + destination.getIndex() + ". " + destination.getName() + "\n";
        }

        JTextArea destinationsTextArea = new JTextArea(destinationsText);
        destinationsTextArea.setEditable(false);
        destinationsTextArea.setBounds(100, 330, 400, 270);
        destinationsTextArea.setFont(new Font("Verdana", Font.PLAIN, 17));
        destinationsTextArea.setBackground(Color.decode("#b8c9d1"));
        this.add(destinationsTextArea);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();

                String name = textname.getText();
                String input = preferencesTextArea.getText();
                String[] preferencesInput = input.split("[\\s]+");

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Please fill name field.");
                } else if (preferencesInput.length != 3) {
                    inputErrorLabel.setText("Please enter exactly 3 preferences.");
                } else {
                    List<Destination> preferences = new ArrayList<>();
                    boolean validInput = true;

                    for (String preference: preferencesInput) {
                        try {
                            int index = Integer.parseInt(preference) - 1;
                            if (index < 0 || index >= destinations.size() || preferences.contains(destinations.get(index))) {
                                validInput = false;
                                break;
                            }
                            preferences.add(destinations.get(index));
                        } catch (NumberFormatException ex) {
                            validInput = false;
                            break;
                        }
                    }
                    if (!validInput) {
                        inputErrorLabel.setText("Enter numbers in range 1-10");
                    } else {
                        student.setName(name);
                        student.setPreferences(preferences);
                        Client client = new Client("localhost", 2004, student);
                        inputErrorLabel.setText("");
                        MainFrame.this.setVisible(false);
                    }

                }
            }
        });
        this.setVisible(true);
    }
}
