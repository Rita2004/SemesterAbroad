import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClientGUI clientGUI = new ClientGUI();
                clientGUI.setSize(500, 300);
                clientGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                clientGUI.setVisible(true);
            }
        });
    }
}
