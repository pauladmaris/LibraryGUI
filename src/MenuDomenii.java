import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import Controller.Controller_Domeniu;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuDomenii extends JFrame {

    private Controller_Domeniu ctrl_domenii;
	Image image = null;
	private JPanel contentPane;
	private JTextField txtDomenii;
	private ShowDomenii showDomenii = new ShowDomenii();
	private AddDomeniu addDomeniu = new AddDomeniu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDomenii frame = new MenuDomenii();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuDomenii() {
		
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\backi.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		setResizable(false);
		setTitle("Domenii");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDomenii = new JTextField();
		txtDomenii.setText("Domenii");
		txtDomenii.setHorizontalAlignment(SwingConstants.CENTER);
		txtDomenii.setFont(new Font("Pristina", Font.BOLD, 39));
		txtDomenii.setEditable(false);
		txtDomenii.setColumns(10);
		txtDomenii.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtDomenii.setBackground(SystemColor.activeCaption);
		txtDomenii.setBounds(235, 82, 157, 54);
		contentPane.add(txtDomenii);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 461, 81, 40);
		contentPane.add(btnNewButton);
		JPanel j = new JPanelWithBackground(image);
		j.setBounds(0, 0, 690, 520);
		contentPane.add(j);
		j.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("2.Afisare");
		btnNewButton_3.setBounds(203, 324, 230, 54);
		j.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showDomenii.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(250, 250, 210));
		btnNewButton_3.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		
		JButton btnNewButton_3_1 = new JButton("1.Adauga");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDomeniu.setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnNewButton_3_1.setBackground(new Color(250, 250, 210));
		btnNewButton_3_1.setBounds(203, 239, 230, 54);
		j.add(btnNewButton_3_1);
	}

	public MenuDomenii(Controller_Domeniu ctrl_domenii2) {
		this.ctrl_domenii = ctrl_domenii2;
	}

}
