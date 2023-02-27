import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Game {
	// global variables
	boolean start = true;
	int attempts = 0;
	int points = 0;
	int result = (int) (Math.random() * (101) + 0);

	public Game() {
		JFrame f = new JFrame("Number Guessing Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 550);
		f.getContentPane().setBackground(Color.BLACK);

		// points to be shown
		JLabel l1 = new JLabel("Points");
		l1.setForeground(Color.CYAN);
		l1.setBounds(120, 50, 150, 30);
		l1.setFont(new Font("Serif", Font.PLAIN, 30));
		f.add(l1);

		JLabel l2 = new JLabel(Integer.toString(points));
		l2.setForeground(Color.CYAN);
		l2.setBounds(250, 50, 150, 30);
		l2.setFont(new Font("Serif", Font.PLAIN, 30));
		f.add(l2);

		// no. of attempts
		JLabel a1 = new JLabel("Attempts");
		a1.setForeground(Color.CYAN);
		a1.setBounds(120, 90, 150, 30);
		a1.setFont(new Font("Serif", Font.PLAIN, 30));
		f.add(a1);

		JLabel a2 = new JLabel(Integer.toString(attempts));
		a2.setForeground(Color.CYAN);
		a2.setBounds(250, 90, 150, 30);
		a2.setFont(new Font("Serif", Font.PLAIN, 30));
		f.add(a2);

		// guess
		JLabel l3 = new JLabel("Enter your guess !");
		l3.setForeground(Color.green);
		l3.setBounds(80, 180, 300, 30);
		l3.setFont(new Font("Serif", Font.PLAIN, 18));
		f.add(l3);

		// input text box
		JTextField jtf = new JTextField("0");
		jtf.setBackground(Color.lightGray);
		jtf.setForeground(Color.black);
		jtf.setBounds(80, 250, 90, 40);
		jtf.setFont(new Font("Serif", Font.PLAIN, 30));
		f.add(jtf);

		// check button
		JButton b1 = new JButton("Check");
		b1.setBounds(195, 260, 150, 30);
		b1.setBackground(Color.green);
		b1.setFont(new Font("Serif", Font.BOLD, 25));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String in = jtf.getText();
				int input = Integer.parseInt(in);

				attempts++;
				a2.setText(Integer.toString(attempts));

				if (input == result) {
					l3.setText("Your guess is correct !! You won !!");
					points = 100 - attempts * 5;
					l2.setText(Integer.toString(points));
				} else if (input < result && result - input > 10) {
					l3.setText("Your guessed number is smaller");
				} else if (input < result && result - input < 10) {
					l3.setText("Increase your guess a little");
				} else if (input > result && input - result > 10) {
					l3.setText("Your guessed number is larger");
				} else if (input > result && input - result < 10) {
					l3.setText("Decrease your guess a little");
				}

			}
		});
		f.add(b1);

		// quit game functionality
		JButton b2 = new JButton("Quit Game");
		b2.setBounds(30, 370, 150, 30);
		b2.setBackground(Color.red);
		b2.setFont(new Font("Serif", Font.BOLD, 20));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		f.add(b2);

		// restart game functionality
		JButton b3 = new JButton("Restart Game");
		b3.setBounds(200, 370, 160, 30);
		b3.setBackground(Color.white);
		b3.setFont(new Font("Serif", Font.BOLD, 20));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				points = 0;
				attempts = 0;
				result = (int) (Math.random() * (101) + 0);

				l2.setText("0");
				a2.setText("0");
				l3.setText("Enter your guess !!");
				jtf.setText("0");
			}
		});
		f.add(b3);

		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		Game g = new Game();
	}
}