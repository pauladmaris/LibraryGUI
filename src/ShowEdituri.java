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

import Controller.Controller_Carti;
import Controller.Controller_Editura;
import Model.Autor;
import Model.Editura;
import Repository.RepoCarti;
import Repository.RepoEdituri;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class ShowEdituri extends JFrame {

	RepoEdituri repo_edituri = new RepoEdituri("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Edituri");
    private  Controller_Editura ctrl_edituri = new Controller_Editura(repo_edituri);
    
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowEdituri frame = new ShowEdituri();
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
	public ShowEdituri() {
		setTitle("Afisare edituri");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ctrl_edituri.readFromFile_Edituri();
        List<Editura> listEdituri = new ArrayList<>();
		listEdituri = ctrl_edituri.getAll();
		
		String[] columnNames = 
				{"ID",
                "Nume",
                "An",
                "Categorii"};
		
		Object[][] data = new Object[listEdituri.size()+1][4];
		
		data[0][0] = "ID";
		data[0][1] = "Nume";
		data[0][2] = "An";
		data[0][3] = "Categorii";
		
		for (int i = 1; i < listEdituri.size()+1; i++) {
				data[i][0] = listEdituri.get(i-1).getId();
				data[i][1] = listEdituri.get(i-1).getNume();
				data[i][2] = listEdituri.get(i-1).getAn();
				data[i][3] = listEdituri.get(i-1).getCategorii();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table.setBackground(new Color(224, 255, 255));
		contentPane.add(table, BorderLayout.CENTER);
		
		/*
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Edituri"));
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