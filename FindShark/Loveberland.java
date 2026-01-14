import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Loveberland {
	JFrame f;
	JButton btn_next;
	JLabel lb;
	JTextField tf;
	JButton btn_l;
	JButton btn_r;
	JButton btn_new;
	ImageIcon blue300, orange300, img1, img2;
	boolean hasPlay = false;

	public Loveberland() {
		f = new JFrame("Find Tralalero Tralala");
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		btn_next = new JButton("Next game");
		btn_next.setPreferredSize(new Dimension(200, 100));
		lb = new JLabel("Score");
		lb.setPreferredSize(new Dimension(100, 100));
		tf = new JTextField("0");
		tf.setFont(new Font("Arial", Font.BOLD, 48));
		tf.setPreferredSize(new Dimension(100, 100));
		btn_l = new JButton();
		btn_l.setPreferredSize(new Dimension(200, 200));
		btn_r = new JButton();
		btn_r.setPreferredSize(new Dimension(200, 200));
		btn_new = new JButton("New game");
		btn_new.setPreferredSize(new Dimension(400, 100));

		f.setLayout(new FlowLayout());

		f.add(btn_next);
		f.add(lb);
		f.add(tf);
		f.add(btn_l);
		f.add(btn_r);
		f.add(btn_new);

		phase2();

		f.setVisible(true);
	}

	private void phase2() {
		try {
			blue300 = new ImageIcon("./blue300.png");
			orange300 = new ImageIcon("./orange300.png");
			img1 = new ImageIcon("./Bombardiro_Crocodillo.jpg");
			img2 = new ImageIcon("./Tralalero_Tralala.png");			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		btn_l.setIcon(blue300);
		btn_r.setIcon(orange300);
		phase3();
	}

	private void phase3() {
		ActionListener listen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				switch (random.nextInt(2)) {
					case 0 : 
						if (btn_l == (JButton)e.getSource() && !hasPlay) {
							btn_l.setIcon(img1);
							hasPlay = true;
						} else if (btn_r == (JButton)e.getSource() && !hasPlay) {
							btn_r.setIcon(img2);
							increaseScore();
							hasPlay = true;
						} else if (btn_next == (JButton)e.getSource()) {
							btn_l.setIcon(blue300);
							btn_r.setIcon(orange300);
							hasPlay = false;
						} else if (btn_new == (JButton)e.getSource()) {
							btn_l.setIcon(blue300);
							btn_r.setIcon(orange300);
							tf.setText("0");
							phase2();
						}
						break;
					case 1 : 
						if (btn_l == (JButton)e.getSource() && !hasPlay) {
							btn_l.setIcon(img2);
							increaseScore();
							hasPlay = true;
						} else if (btn_r == (JButton)e.getSource() && !hasPlay) {
							btn_r.setIcon(img1);
							hasPlay = true;
						} else if (btn_next == (JButton)e.getSource()) {
							btn_l.setIcon(blue300);
							btn_r.setIcon(orange300);
							hasPlay = false;
						} else if (btn_new == (JButton)e.getSource()) {
							btn_l.setIcon(blue300);
							btn_r.setIcon(orange300);
							tf.setText("0");
							phase2();
						}
						break;
				}
				
			}
		};
		//System.out.println("Debug");
		btn_l.addActionListener(listen);
		btn_r.addActionListener(listen);
		btn_next.addActionListener(listen);
		btn_new.addActionListener(listen);
	}

	private void increaseScore() {
		int tmp = Integer.parseInt(tf.getText());
		tmp++;
		tf.setText(String.valueOf(tmp));
	}
	
	public static void main(String[] args) {
		new Loveberland();
	}
}
