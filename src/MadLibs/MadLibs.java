package MadLibs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MadLibs extends JFrame {
	private JTextField txtAjective;
	private JTextField txtColor;
	private JTextField txtVerb;
	private String message;
	JLabel lblMessage = new JLabel("Заполните пожайлуста поля");
	private JTextArea txtOutputArea = new JTextArea();

	public void newGame() {
		try {
			String color = txtColor.getText();
			String ajective = txtAjective.getText();
			String verb = txtVerb.getText();
			String history = color + " дракон " + verb + "  на " + ajective + " рыцаря.";
			txtOutputArea.setText(history);
		} catch (Exception e) {
			message = "вводи пожалуйста только текст";
		} finally {
			lblMessage.setText(message);
		}
		
	}

	public MadLibs() {
		setTitle("MadLibs Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMadlibsGame = new JLabel("Булат MadLibs Game");
		lblMadlibsGame.setBounds(119, 0, 436, 20);
		lblMadlibsGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadlibsGame.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblMadlibsGame);

		JLabel label = new JLabel("Прилагательное");
		label.setBounds(10, 31, 99, 42);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Цвет");
		label_1.setBounds(10, 66, 109, 20);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Глагол в прошедшем вермени");
		label_2.setBounds(278, 45, 163, 14);
		getContentPane().add(label_2);

		txtAjective = new JTextField();
		txtAjective.setBounds(119, 42, 149, 20);
		getContentPane().add(txtAjective);
		txtAjective.setColumns(10);

		txtColor = new JTextField();
		txtColor.setBounds(119, 66, 149, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);

		txtVerb = new JTextField();
		txtVerb.setBounds(441, 42, 96, 20);
		getContentPane().add(txtVerb);
		txtVerb.setColumns(10);

		txtOutputArea.setBounds(10, 134, 692, 204);
		getContentPane().add(txtOutputArea);

		JButton btnStart = new JButton("Генерировать!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnStart.setBounds(296, 100, 120, 23);
		getContentPane().add(btnStart);
		
		
		lblMessage.setBounds(278, 72, 263, 14);
		getContentPane().add(lblMessage);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MadLibs theGame = new MadLibs();
		// .newGame();
		theGame.setSize(800, 400);
		theGame.setVisible(true);

	}
}
