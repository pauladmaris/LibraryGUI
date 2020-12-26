import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Autori;
import Model.Autor;
import Repository.RepoAutori;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class ShowAutori extends JFrame {

	RepoAutori repo_autori = new RepoAutori("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Autori");
    private  Controller_Autori ctrl_autori = new Controller_Autori(repo_autori);
    
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAutori frame = new ShowAutori();
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
	public ShowAutori() {
		setTitle("Afisare Autori");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		ctrl_autori.readFromFile_Autori();
        List<Autor> listAutori = new ArrayList<>();
		listAutori = ctrl_autori.getAll();
		
		String[] columnNames = 
				{"ID",
                "Nume",
                "Nr publicatii",
                "Categorie"};
		
		Object[][] data = new Object[listAutori.size()+1][4];
		
		data[0][0] = "ID";
		data[0][1] = "Nume";
		data[0][2] = "Nr. publicatii";
		data[0][3] = "Categorie";
		
		for (int i = 1; i < listAutori.size()+1; i++) {
				data[i][0] = listAutori.get(i-1).getId();
				data[i][1] = listAutori.get(i-1).getNumeAutor();
				data[i][2] = listAutori.get(i-1).getNrPublicatii();
				data[i][3] = listAutori.get(i-1).getCategorie();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table.setBackground(new Color(224, 255, 255));
		contentPane.add(table, BorderLayout.CENTER);
		

		
		
		/*
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Autori"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		       line = br.readLine();
		    }
		    String everything = sb.toString();
		    textArea.setRows(100);
		    textArea.setText(everything);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
	}

}
