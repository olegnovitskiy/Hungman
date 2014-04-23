import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_MainMenu implements ActionListener {
	private JFrame frame;
	private JLabel Welcome;
	private JButton StartBtn;
	private JButton QuitBtn;
	private ImageIcon background;
	private JPanel imagePanel;

	public static void main(String[] args) {
		GUI_MainMenu x = new GUI_MainMenu();
		x.WelcomeMenu();
	}

	public void WelcomeMenu() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(new Dimension(300,300));
		frame.setLayout(new FlowLayout());
		frame.setTitle("Evil Hangman Game");

		// set Background Image
		background = new ImageIcon("Welcome.jpg");
		JLabel label = new JLabel(background);

		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);

		imagePanel.setLayout(new FlowLayout());

		frame.getLayeredPane().setLayout(null);

		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(background.getIconWidth(), background.getIconHeight());
		frame.setResizable(false);

		// add componants to the frame
		Welcome = new JLabel("Welcome to Evil Hangman!");
		Welcome.setForeground(Color.red);
		StartBtn = new JButton("Start Game");
		StartBtn.setForeground(Color.red);
		QuitBtn = new JButton("Quit");
		QuitBtn.setForeground(Color.red);

		StartBtn.addActionListener(this);
		QuitBtn.addActionListener(this);

		frame.add(Welcome);
		frame.add(StartBtn);
		frame.add(QuitBtn);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartBtn) {
			// when the user start to play game, the main menu should be
			// invisible.
			frame.setVisible(false);
			// the user should play game on the GuessMenu
			new GUI_GuessMenu(frame);
		} else {
			System.exit(0);
		}
	}
}