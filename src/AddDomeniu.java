import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Autori;
import Controller.Controller_Carti;
import Controller.Controller_Domeniu;
import Repository.RepoAutori;
import Repository.RepoCarti;
import Repository.RepoDomenii;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDomeniu extends JFrame {
	
	RepoDomenii repo_domenii = new RepoDomenii("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Domenii");
    private  Controller_Domeniu ctrl_domenii = new Controller_Domeniu(repo_domenii);

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDomeniu frame = new AddDomeniu();
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
	public AddDomeniu() {
		ctrl_domenii.readFromFile_Domenii();
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\background_img.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		setTitle("Adaugare domeniu");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIntroducetiDatelePentru = new JTextPane();
		txtpnIntroducetiDatelePentru.setBackground(new Color(224, 255, 255));
		txtpnIntroducetiDatelePentru.setFont(new Font("Sitka Small", Font.PLAIN, 19));
		txtpnIntroducetiDatelePentru.setBounds(50, 41, 361, 44);
		txtpnIntroducetiDatelePentru.setText("Introduceti datele pentru adaugare:");
		txtpnIntroducetiDatelePentru.setEditable(false);
		contentPane.add(txtpnIntroducetiDatelePentru);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtpnId.setText("ID:");
		txtpnId.setBounds(123, 147, 51, 28);
		contentPane.add(txtpnId);
		
		JTextPane txtpnTitlu = new JTextPane();
		txtpnTitlu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnTitlu.setText("Nume:");
		txtpnTitlu.setBounds(123, 204, 51, 28);
		contentPane.add(txtpnTitlu);
		
		JTextPane txtpnAutor = new JTextPane();
		txtpnAutor.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnAutor.setText("Descriere:");
		txtpnAutor.setBounds(97, 258, 77, 28);
		contentPane.add(txtpnAutor);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(212, 155, 96, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(212, 212, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 266, 96, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(textField.getText());
		        String nume = textField_1.getText();
		        String cuvinteCheie = textField_2.getText();
		        
                try {
                    ctrl_domenii.addDomeniu(id,nume,cuvinteCheie);
                } catch (Exception e) {
                	e.getMessage();
                }
                
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
		btnNewButton.setBounds(167, 436, 89, 44);
		contentPane.add(btnNewButton);
	}

}