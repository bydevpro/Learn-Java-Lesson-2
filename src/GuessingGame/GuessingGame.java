package GuessingGame;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int tips;

	public void checkGuess() {
		String guessText = textGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			tips++;
			if (guess < theNumber) {
				message = guess + " меншье загаданного числа. Поробуй еще раз!";
			} else if (guess > theNumber) {
				message = guess + " больше загаданного числа. Попробуй еще раз!";
			} else {
				message = "Верно это " + guess + "!! \nПоздравляю! Вы угадали с " + tips + " попыток!";
			}
		} catch (Exception e) {
			message = "Пожалуйста введите только целое число от 1 до 100.";
		} finally {
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();
		}
	}

	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
	}

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Булат Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblHiloGuessing = new JLabel("Булат Hi-Lo Guessing Game");
		lblHiloGuessing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiloGuessing.setBounds(101, 26, 230, 23);
		getContentPane().add(lblHiloGuessing);

		JLabel label = new JLabel("Введите число от 1до 100:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(60, 84, 163, 29);
		getContentPane().add(label);

		textGuess = new JTextField();
		textGuess.setBounds(224, 89, 96, 20);
		getContentPane().add(textGuess);
		textGuess.setColumns(10);
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});

		JButton btnGuess = new JButton("Угадать!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(174, 168, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Введите число и нажмите кнопку Угадать!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 220, 416, 43);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);

	}
}
