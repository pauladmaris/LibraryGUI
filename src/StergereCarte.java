import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Carti;
import Repository.RepoCarti;

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
import javax.swing.JComboBox;

public class StergereCarte extends JFrame {
	
	RepoCarti repo_carti = new RepoCarti("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Carti");
    private  Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);

	private JPanel contentPane;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StergereCarte frame = new StergereCarte();
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
	public StergereCarte() {
		
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\background_img.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		ctrl_carti.readFromFile_Carti();
		
		setTitle("Stergere carte");
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
		txtpnIntroducetiDatelePentru.setBounds(29, 55, 360, 51);
		txtpnIntroducetiDatelePentru.setText("Alegeti id-ul cartii pentru stergere:");
		txtpnIntroducetiDatelePentru.setEditable(false);
		contentPane.add(txtpnIntroducetiDatelePentru);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtpnId.setText("ID:");
		txtpnId.setBounds(103, 168, 51, 28);
		contentPane.add(txtpnId);
		
		String[] string = new String[ctrl_carti.getAll().size()];
		for (int i = 0; i < ctrl_carti.getAll().size(); i++)
		{
			string[i] = String.valueOf(ctrl_carti.getAll().get(i).getId());
		}
        JComboBox comboBox = new JComboBox(string);
        comboBox.setSelectedIndex(0);
		
		
		comboBox.setBackground(new Color(240, 255, 240));
		comboBox.setBounds(219, 168, 51, 28);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sterge");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(comboBox.getSelectedItem().toString());
		        
                try {
                    ctrl_carti.deleteCarte(id);
                } catch (Exception e) {
                	e.getMessage();
                }
                
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
		btnNewButton.setBounds(140, 283, 114, 44);
		contentPane.add(btnNewButton);
		

	}
	
}