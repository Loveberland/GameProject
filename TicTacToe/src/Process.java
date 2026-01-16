import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Process {
        boolean xTurn = true;
        JButton[] btn;
        JButton btnNewGame;
        public Process(JButton[] btn, JButton btnNewGame) {
                this.btn = btn;
                this.btnNewGame = btnNewGame;
                ActionListener listen = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JButton btnClicked = (JButton) e.getSource();
                                if (btnClicked == btnNewGame) {
                                        restart();
                                        return;
                                }
                                if (btnClicked.getText().equals("")) {
                                        if (xTurn) {
                                                btnClicked.setText("X");
                                                btnClicked.setBackground(Color.RED);
                                        } else {
                                                btnClicked.setText("O");
                                                btnClicked.setBackground(Color.BLUE);
                                        }
                                        btnClicked.setFont(new Font("Arial", Font.BOLD, 40));
                                        
                                        if (checkWinner()) {
                                                String winer = xTurn ? "X" : "O";
                                                JOptionPane.showMessageDialog(null, "Player " + winer + " Win!!");
                                                restart();
                                        } else if (checkDraw()) {
                                                JOptionPane.showMessageDialog(null, "Draw!!");
                                                restart();
                                        } else {
                                                xTurn = !xTurn;
                                        }
                                }
                        }
                };
                for (JButton tmp : btn) tmp.addActionListener(listen);
                btnNewGame.addActionListener(listen);
        }

        public boolean checkWinner() {
                int[][] winCondition = {
                        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                        {0, 3, 6}, {1, 4, 7}, {2, 6, 8},
                        {0, 4, 8}, {2, 4, 6}
                };
                for (int[] condition : winCondition) {
                        String b1 = btn[condition[0]].getText();
                        String b2 = btn[condition[1]].getText();
                        String b3 = btn[condition[2]].getText();
                        if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) return true;
                }
                return false;
        }

        public boolean checkDraw() {
                for (JButton tmp : btn) {
                        if (tmp.getText().equals("")) return false;
                }
                return true;
        }

        public void restart() {
                for (JButton tmp : btn) {
                        tmp.setText("");
                        tmp.setBackground(new Color(230, 230, 230));
                }
                xTurn = true;
        }
}
