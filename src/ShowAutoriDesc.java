import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Autori;
import Controller.Controller_Carti;
import Model.Autor;
import Model.Carte;
import Repository.RepoAutori;
import Repository.RepoCarti;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class ShowAutoriDesc extends JFrame {

    RepoAutori repo_autori = new RepoAutori("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Autori");
    private  Controller_Autori ctrl_autori = new Controller_Autori(repo_autori);
    
	private JPanel contentPane;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ShowAutoriDesc frame = new ShowAutoriDesc();
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
	public ShowAutoriDesc() {
		initialize();
	}
	
	public void initialize() {
		setTitle("TABEL Autori in ordine descrescatoare dupa nr de publicatii");
		ctrl_autori.readFromFile_Autori();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
        List<Autor> listAutori = new ArrayList<>();
        ctrl_autori.sortareDesc(ctrl_autori.getAll());
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
		
		table_4 = new JTable(data,columnNames);
		table_4.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table_4.setBackground(new Color(224, 255, 255));
		contentPane.add(table_4, BorderLayout.CENTER);
	} 
}

