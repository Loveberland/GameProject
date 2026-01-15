import javax.swing.*;
import java.awt.*;

public class Display {
        private JFrame mainFrame;
        private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, btnRestart, btnStartGame;

        public Display() {
                // Create main frame
                mainFrame = new JFrame("Tic-Tac-Toe");
                mainFrame.setSize(800, 800);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setLayout(null);

                // Create button for tell user how to play this game
                btnStartGame = new JButton("");

                mainFrame.setVisible(true);
        }
}
