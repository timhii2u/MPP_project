package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import library_system.SystemController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnLogin;
	static Login window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JFrame getFrame() {
		return frame;
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(new Dimension(867, 489));
		frame.setMaximumSize(new Dimension(1500, 800));
		frame.getContentPane().setBackground(new Color(0, 0, 102));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblLoggingUsername = new JLabel("Username");
		lblLoggingUsername.setForeground(new Color(255, 255, 255));
		lblLoggingUsername.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 18));
		lblLoggingUsername.setBounds(308, 185, 115, 42);
		frame.getContentPane().add(lblLoggingUsername);

		JLabel lblLoggingpassword = new JLabel("Password");
		lblLoggingpassword.setForeground(new Color(255, 255, 255));
		lblLoggingpassword.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 18));
		lblLoggingpassword.setBounds(308, 240, 115, 48);
		frame.getContentPane().add(lblLoggingpassword);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Roboto", Font.PLAIN, 15));
		txtUsername.setBounds(468, 192, 214, 33);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(15);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 15));
		txtPassword.setBounds(468, 242, 214, 33);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(15);

		btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 0, 102));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				if(username.trim().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter Username");
					return;
				}else if(password.trim().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter Password");
					return;
				}
				SystemController sc = new SystemController();
				sc.loginModule(username, password);
				sc.login(username, password, window);
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});

		btnLogin.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\images\\Login.png"));
		btnLogin.setForeground(new Color(255, 255, 255));
//		btnLogin.setBackground(Color.GRAY);
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		btnLogin.setBounds(308, 341, 163, 59);
		frame.getContentPane().add(btnLogin);

		JLabel lblLibreryMangementSystem = new JLabel("Group 10 Library Mangement System");
		lblLibreryMangementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibreryMangementSystem.setForeground(new Color(255, 255, 255));
		lblLibreryMangementSystem.setBackground(SystemColor.activeCaption);
		lblLibreryMangementSystem.setFont(new Font("Century Schoolbook L", Font.BOLD, 32));
		lblLibreryMangementSystem.setBounds(42, 58, 798, 84);
		frame.getContentPane().add(lblLibreryMangementSystem);

		JLabel label = new JLabel(
				new ImageIcon(System.getProperty("user.dir")+ "\\src\\images\\book.png"));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(28, 151, 239, 196);
		frame.getContentPane().add(label);

		JLabel lblicon = new JLabel("");
		lblicon.setIcon(new ImageIcon(
				System.getProperty("user.dir")+ "\\src\\images\\PinClipart.com_iron-clipart_125005.png"));
		lblicon.setBounds(705, 217, 25, 27);
		frame.getContentPane().add(lblicon);

		JButton btnCancel = new JButton("Close");

		btnCancel.setBackground(new Color(0, 0, 102));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setIcon(
				new ImageIcon(System.getProperty("user.dir") + "\\src\\images\\download.png"));
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setHorizontalAlignment(SwingConstants.CENTER);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCancel.setBounds(538, 341, 144, 59);
		frame.getContentPane().add(btnCancel);

//		frame.setUndecorated(true);
	}
}
