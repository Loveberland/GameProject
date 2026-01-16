import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Display {
        private JFrame mainFrame;
        private JButton[] btn = new JButton[9]; 
        private JButton btnNewstart;
        private JPanel topPanel, boardPanel;

        public Display() {
                initializeUI();
                SwingUtilities.invokeLater(this::showTutorial);
        }

        public void initializeUI() {
                mainFrame = new JFrame("Tic-Tac-Toe");
                mainFrame.setSize(1000, 1000);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout(10, 10));

                topPanel = new JPanel();
                btnNewstart = new JButton("New Game");
                btnNewstart.setFocusable(false);
                topPanel.add(btnNewstart);
                mainFrame.add(topPanel, BorderLayout.NORTH);

                boardPanel = new JPanel();
                boardPanel.setLayout(new GridLayout(3, 3, 15, 15));
                boardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
                for (int i = 0; i < 9; i++) {
                        btn[i] = new JButton();
                        btn[i].setBackground(new Color(192, 192, 192, 30));
                        btn[i].setFocusable(false);
                        boardPanel.add(btn[i]);
                }
                mainFrame.add(boardPanel, BorderLayout.CENTER);

                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
        }

        public void showTutorial() {
                JDialog dialog = new JDialog(mainFrame, "", true);
                dialog.setLayout(new BorderLayout());
                dialog.setSize(500, 600);

                JPanel tutorialPopup = new JPanel();
                tutorialPopup.setLayout(new BorderLayout(10, 10));
                tutorialPopup.setBorder(new EmptyBorder(20, 20, 20, 20));
                tutorialPopup.setBackground(Color.WHITE);
                String message = "<html><center>Decide who will<br>" +
                        "play as X and<br>" +
                        "who will play as<br>" +
                        "O. The player<br>" +
                        "with X takes the<br>" +
                        "first turn.</center></html>";
                JLabel txtLabel = new JLabel(message, SwingConstants.CENTER);
                txtLabel.setFont(new Font("Arial", Font.PLAIN, 50));
                tutorialPopup.add(txtLabel, BorderLayout.CENTER);

                JButton btnUnderstand = new JButton("understand");
                btnUnderstand.setFont(new Font("Arial", Font.PLAIN, 14));
                btnUnderstand.setFocusable(false);
                btnUnderstand.addActionListener(e -> dialog.dispose());

                JPanel btnPanel = new JPanel();
                btnPanel.setBackground(new Color(192, 192, 192, 30));
                btnPanel.add(btnUnderstand);
                tutorialPopup.add(btnPanel, BorderLayout.SOUTH);

                tutorialPopup.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                
                dialog.add(tutorialPopup);
                dialog.setLocationRelativeTo(mainFrame);
                dialog.setVisible(true);
        }
}
