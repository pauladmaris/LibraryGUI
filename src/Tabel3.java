import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Carti;
import Controller.Controller_Domeniu;
import Model.Carte;
import Repository.RepoCarti;
import Repository.RepoDomenii;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class Tabel3 extends JFrame {

	RepoCarti repo_carti = new RepoCarti("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Carti");
    private  Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);
    
    RepoDomenii repo_domenii = new RepoDomenii("C:\\Users\\Paula\\eclipse-workspace\\Pb3GUI\\src\\Domenii");
    private  Controller_Domeniu ctrl_domenii = new Controller_Domeniu(repo_domenii);
    
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tabel3 frame = new Tabel3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Tabel3() {
		initialize("");
	}

	/**
	 * Create the frame.
	 */
	public Tabel3(String numeDomeniu) {
		initialize(numeDomeniu);
	}
	
	public void initialize(String numeDomeniu) {
		setTitle("TABEL Carti de la un Domeniu");
		ctrl_carti.readFromFile_Carti();
		ctrl_domenii.readFromFile_Domenii();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		
		String domeniuCuvinte = ctrl_domenii.getAll().get(ctrl_domenii.searchByNumeDomeniu(numeDomeniu)).getCuvinteCheie();
		
		String nume = numeDomeniu;
        List<Carte> listCartiDomeniu = new ArrayList<>();
		listCartiDomeniu = afisCartiDomeniu(ctrl_carti.getAll(),domeniuCuvinte);
		
		String[] columnNames = 
				{"ID",
                "Titlu",
                "Domeniu",
                "An",
                "Domeniu",
                "Descriere",
                "Cota"};
		
		Object[][] data = new Object[listCartiDomeniu.size()+1][8];
		
		data[0][0] = "ID";
		data[0][1] = "Titlu";
		data[0][2] = "Autor";
		data[0][3] = "An";
		data[0][4] = "Domeniu";
		data[0][5] = "Descriere";
		data[0][6] = "Cota";
		
		for (int i = 1; i < listCartiDomeniu.size()+1; i++) {
				data[i][0] = listCartiDomeniu.get(i-1).getId();
				data[i][1] = listCartiDomeniu.get(i-1).getTitlu();
				data[i][2] = listCartiDomeniu.get(i-1).getNumeAutor();
				data[i][3] = listCartiDomeniu.get(i-1).getAn();
				data[i][4] = listCartiDomeniu.get(i-1).getEditura();
				data[i][5] = listCartiDomeniu.get(i-1).getDescriere();
				data[i][6] = listCartiDomeniu.get(i-1).getCota();
		}
		
		table_1 = new JTable(data,columnNames);
		table_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table_1.setBackground(new Color(224, 255, 255));
		contentPane.add(table_1, BorderLayout.CENTER);
	}
	
	//afisarea cartilor de la un anumit Domeniu
    public static List<Carte> afisCartiDomeniu(List<Carte> cartiList, String domeniuCuvinte) {
    	List<Carte> listCarti = new ArrayList<>();
    	
    	String components[] = domeniuCuvinte.split("-");
        
        for (int i = 0; i < cartiList.size(); i++) {
        	int k = 0;
        	for (int j = 0; j < components.length; j++) {
            	String cuv = components[j];
                if (cartiList.get(i).getDescriere().contains(cuv)) {
                   k++;
                }
        	}
        	if (k != 0)
        		listCarti.add(cartiList.get(i));
        }
        
       return listCarti;   
    }
    
	

}