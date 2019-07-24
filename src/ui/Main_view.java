package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import library_system.Address;
import library_system.SystemController;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class Main_view extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	
	private JPanel sidepanel;
	private JPanel datapanel;
	private JPanel home_panel;
	private JPanel add_member_panel;
	private JPanel edit_member_panel;
	private JPanel add_book_panel;
	private JPanel add_copy_of_book_panel;
	private JPanel checkout_panel;
	private JPanel print_panel;
	
	private JButton btnHome;
	private JButton add_member_btn;
	private JButton edit_member_btn;
	private JButton add_book_btn;
	private JButton add_copy_of_book_btn;
	private JButton checkout_btn;
	private JButton print_btn;
	private JButton button;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_view frame = new Main_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public JPanel getDatapanel() {
		return datapanel;
	}



	public JPanel getHome_panel() {
		return home_panel;
	}



	public JButton getBtnHome() {
		return btnHome;
	}



	public JButton getAdd_member_btn() {
		return add_member_btn;
	}



	public JButton getEdit_member_btn() {
		return edit_member_btn;
	}



	public JButton getAdd_book_btn() {
		return add_book_btn;
	}



	public JButton getAdd_copy_of_book_btn() {
		return add_copy_of_book_btn;
	}



	public JButton getCheckout_btn() {
		return checkout_btn;
	}



	public JButton getPrint_btn() {
		return print_btn;
	}

	

	public Main_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 683, 300);
		setResizable(false);
		setSize(new Dimension(1000, 600));
		setMaximumSize(new Dimension(1500, 800));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		sidepanel = new JPanel();
		sidepanel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(sidepanel);
		sidepanel.setLayout(new GridLayout(8, 1, 0, 0));
		
		add_member_btn = new JButton("Add Member");
		add_member_btn.setBackground(Color.LIGHT_GRAY);
		add_member_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add_member_panel.removeAll();
				datapanel.removeAll();
				datapanel.add(add_member_panel);
				datapanel.repaint();
				datapanel.revalidate();
				add_member_panel.setLayout(null);
				setTitle("ADD MEMBER");
				AddMemeber am= new AddMemeber();
				am.addMember(add_member_panel);

			}
		});
		
		button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		sidepanel.add(button);
		sidepanel.add(add_member_btn);
		
		edit_member_btn = new JButton("Edit Member");
		edit_member_btn.setBackground(Color.LIGHT_GRAY);
		edit_member_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_member_panel.removeAll();
				datapanel.removeAll();
				datapanel.add(edit_member_panel);
				datapanel.repaint();
				datapanel.revalidate();
				edit_member_panel.setLayout(null);
				setTitle("EDIT MEMBER");
				GetMemberDetails gmd = new GetMemberDetails();
				gmd.showSearchForm(edit_member_panel);

				
			}
		});
		sidepanel.add(edit_member_btn);
		
		add_book_btn = new JButton("Add Book");
		add_book_btn.setBackground(Color.LIGHT_GRAY);
		add_book_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_book_panel.removeAll();
				datapanel.removeAll();
				datapanel.add(add_book_panel);
				datapanel.repaint();
				datapanel.revalidate();
				add_book_panel.setLayout(null);
				setTitle("ADD BOOK");
				AddBook ab = new AddBook();
				ab.addNewBook(add_book_panel);
			}
		});
		sidepanel.add(add_book_btn);
		
		add_copy_of_book_btn = new JButton("Add Copy of Book");
		add_copy_of_book_btn.setBackground(Color.LIGHT_GRAY);
		add_copy_of_book_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datapanel.removeAll();
				datapanel.add(add_copy_of_book_panel);
				datapanel.repaint();
				datapanel.revalidate();
				add_copy_of_book_panel.setLayout(null);
				setTitle("ADD COPY OF BOOK");
				CopyOfBook cp = new CopyOfBook();
				cp.addCopyOfBook(add_copy_of_book_panel);
			}
		});
		sidepanel.add(add_copy_of_book_btn);
		
		checkout_btn = new JButton("CheckOut");
		checkout_btn.setBackground(Color.LIGHT_GRAY);
		checkout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkout_panel.removeAll();

				datapanel.removeAll();
				datapanel.add(checkout_panel);
				datapanel.repaint();
				datapanel.revalidate();
				checkout_panel.setLayout(null);
				setTitle("CHECKOUT BOOK");
				SearchMember sm = new SearchMember();
				sm.showSearchForm(checkout_panel);
				
			}
		});
		sidepanel.add(checkout_btn);
		
		print_btn = new JButton("Print");
		print_btn.setBackground(Color.LIGHT_GRAY);
		print_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datapanel.removeAll();
				datapanel.add(print_panel);
				datapanel.repaint();
				datapanel.revalidate();
			}
		});
		sidepanel.add(print_btn);
		
		btnHome = new JButton("Logout");
		btnHome.setBackground(Color.LIGHT_GRAY);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login lg = new Login();
				lg.getFrame().setVisible(true);


			}
		});
		sidepanel.add(btnHome);
		
		datapanel = new JPanel();
		datapanel.setBackground(Color.WHITE);
		datapanel.setBorder(new TitledBorder(new LineBorder(new Color(124, 252, 0), 2), "Group 10 System", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 102)));
		splitPane.setRightComponent(datapanel);
		datapanel.setLayout(new CardLayout(0, 0));
		
		home_panel = new JPanel();
		home_panel.setBackground(Color.BLUE);
		FlowLayout fl_home_panel = (FlowLayout) home_panel.getLayout();
		datapanel.add(home_panel, "name_162156660107539");
		
		JLabel lblHome = new JLabel("WELCOME");
		lblHome.setBounds(new Rectangle(450, 50, 100, 40));
		lblHome.setForeground(Color.WHITE);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Dialog", Font.BOLD, 32));

		home_panel.add(lblHome);
		
		add_member_panel = new JPanel();
		add_member_panel.setBackground(Color.BLUE);
		datapanel.add(add_member_panel, "name_162527236909732");
		
		edit_member_panel = new JPanel();
		edit_member_panel.setBackground(Color.BLUE);
		datapanel.add(edit_member_panel, "name_162598448204522");
		
		add_book_panel = new JPanel();
		add_book_panel.setBackground(Color.BLUE);
		datapanel.add(add_book_panel, "name_162724649544112");
		
		add_copy_of_book_panel = new JPanel();
		add_copy_of_book_panel.setBackground(Color.BLUE);
		datapanel.add(add_copy_of_book_panel, "name_162772584627678");
		
		checkout_panel = new JPanel();
		checkout_panel.setBackground(Color.BLUE);
		datapanel.add(checkout_panel, "name_162822809002275");
		
		print_panel = new JPanel();
		print_panel.setBackground(Color.BLUE);
		datapanel.add(print_panel, "name_162873193932898");
	}
	

}
