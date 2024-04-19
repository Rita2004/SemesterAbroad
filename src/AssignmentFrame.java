import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AssignmentFrame extends JFrame {
    JTable table;

    public AssignmentFrame(List<Assignment> bestAssignment){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 650);
        this.getContentPane().setBackground(Color.decode("#b8c9d1"));
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        String[] columnNames = {"Student", "Assigned Destination"};

        if(bestAssignment != null) {
            Object[][] data = new Object[bestAssignment.size()][2];
            for (int i = 0; i < bestAssignment.size(); i++) {
                data[i][0] = bestAssignment.get(i).getStudent().getName();
                data[i][1] = bestAssignment.get(i).getDestination().getName();
            }

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table = new JTable(model);
            table.setBounds(100, 150, 600, 350);
            table.setFont(new Font("Arial", Font.PLAIN, 16));
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
            table.setRowHeight(25);
            table.setFillsViewportHeight(true);
            table.setBackground(Color.decode("#f2edf2"));

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(100, 150, 600, 350);

            this.add(scrollPane);
        }
        this.setVisible(true);
    }
}
