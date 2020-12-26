import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.border.TitledBorder;

import Controller.Controller_Autori;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;

public class MenuTabele extends JFrame {

	Image image = null;
	private JPanel contentPane;
	private JTextField txtAutori;
	private ShowAutoriDesc showAutoriDesc = new ShowAutoriDesc();
	private TableCartiAutor tabel1 = new TableCartiAutor();
	private TableCartiEditura tabel2 = new TableCartiEditura();
	private TableCartiDomeniu tabel3 = new TableCartiDomeniu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTabele frame = new MenuTabele();
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
	public MenuTabele() {
		
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\chr2_back.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		setTitle("Tabele");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAutori = new JTextField();
		txtAutori.setText("Autori");
		txtAutori.setHorizontalAlignment(SwingConstants.CENTER);
		txtAutori.setFont(new Font("Pristina", Font.BOLD, 39));
		txtAutori.setEditable(false);
		txtAutori.setColumns(10);
		txtAutori.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtAutori.setBackground(SystemColor.activeCaption);
		txtAutori.setBounds(258, 73, 157, 54);
		contentPane.add(txtAutori);
		

		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 469, 81, 40);
		contentPane.add(btnNewButton);
		JPanel j = new JPanelWithBackground(image);
		j.setBounds(0, 0, 690, 520);
		contentPane.add(j);
		j.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("1.Tabel cu cartile unui autor");
		btnNewButton_3.setBounds(157, 173, 346, 54);
		j.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabel1.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(250, 250, 210));
		btnNewButton_3.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		
		JButton btnNewButton_4 = new JButton("4.Tabel cu autorii in ordine descrescatoare");
		btnNewButton_4.setBounds(157, 417, 346, 61);
		j.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAutoriDesc.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(250, 250, 210));
		btnNewButton_4.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		
		JButton btnNewButton_3_1 = new JButton("2.Tabel cu cartile de la o editura");
		btnNewButton_3_1.setBounds(157, 255, 346, 54);
		j.add(btnNewButton_3_1);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabel2.setVisible(true);
			}
		});
		btnNewButton_3_1.setBackground(new Color(250, 250, 210));
		btnNewButton_3_1.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnNewButton_3_1.setBackground(new Color(250, 250, 210));
		btnNewButton_3_1.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		
		JButton btnNewButton_3_5 = new JButton("3.Tabel cu cartile dintr-un domeniu");
		btnNewButton_3_5.setBounds(157, 338, 346, 54);
		j.add(btnNewButton_3_5);
		btnNewButton_3_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabel3.setVisible(true);
			}
		});
		btnNewButton_3_5.setBackground(new Color(250, 250, 210));
		btnNewButton_3_5.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnNewButton_3_5.setBackground(new Color(250, 250, 210));
		btnNewButton_3_5.setFont(new Font("Poor Richard", Font.PLAIN, 23));
	}

}