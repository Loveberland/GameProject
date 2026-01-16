import javax.swing.*;
import java.awt.*;

public class Display extends Table {
        JFrame mainFrame;
        JButton btnNewGame;

        public Display() {
                initializeMainFrame();
                tutorialPopup();
        }

        public Display(int number) {
                initializeMainFrame();
        }

        public void initializeMainFrame() {
                mainFrame = new JFrame("Tic-Tac-Toe");
                mainFrame.setSize(1000, 1000);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setLayout(new BorderLayout());

                JPanel topPanel = new JPanel();
                topPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

                btnNewGame = new JButton("New Game");
                btnNewGame.setFont(new Font("Arial", Font.PLAIN, 24));
                btnNewGame.setFocusable(true);
                btnNewGame.setPreferredSize(new Dimension(200, 40));

                topPanel.add(btnNewGame);
                mainFrame.add(topPanel, BorderLayout.NORTH);

                JPanel boardPanel = new JPanel();
                boardPanel.setLayout(new GridLayout(3, 3, 50, 50));
                boardPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
                for (int i = 0; i < 9; i++) {
                        super.btnBoard[i] = new JButton();
                        super.btnBoard[i].setBackground(new Color(230, 230, 230));
                        super.btnBoard[i].setFocusable(false);
                        boardPanel.add(btnBoard[i]);
                }

                mainFrame.add(boardPanel, BorderLayout.CENTER);

                mainFrame.setVisible(true);
        }

        public void tutorialPopup() {
                JDialog popup = new JDialog(mainFrame, "Tutorial", true);
                popup.setSize(500, 600);
                popup.setLayout(new BorderLayout());
                
                String msg = "<html><center>Decide who will<br>" +
                        "play as X and<br>" +
                        "who will play as<br>" +
                        "O. The player<br>" +
                        "with X takes the<br>" +
                        "first turn.</center></html>";
                JLabel txt = new JLabel(msg, SwingConstants.CENTER);
                txt.setFont(new Font("Arial", Font.PLAIN, 50));
                popup.add(txt, BorderLayout.CENTER);

                JButton btnUnderstand = new JButton("Understand");
                btnUnderstand.setFont(new Font("Arial", Font.PLAIN, 30));
                btnUnderstand.setFocusable(false);
                btnUnderstand.addActionListener(e -> {
                        popup.dispose();
                        new Process(super.btnBoard, btnNewGame);
                });

                JPanel btnPanel = new JPanel();
                btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
                btnPanel.add(btnUnderstand);

                popup.add(btnPanel, BorderLayout.SOUTH);
                popup.setLocationRelativeTo(mainFrame);

                popup.setVisible(true);
        }
}
