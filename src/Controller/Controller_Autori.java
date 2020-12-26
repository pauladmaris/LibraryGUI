package Controller;

import Model.Autor;
import Model.Carte;
import Repository.RepoAutori;


import java.util.*;

public class Controller_Autori {
    private RepoAutori repo;

    //constructor cu param
    public Controller_Autori(RepoAutori repo) {
        this.repo = repo;
    }

    //citire din fisier
    public void readFromFile_Autori() {
        repo.readFromFile_Autori();
    }

    //adaugare autor
    public void addAutor(int id, String nume_autor,int nr_publicatii,String categorie) {
    	Autor autor = new Autor(id,nume_autor,nr_publicatii,categorie);
    	try {
            repo.addAutor(autor);
            System.out.println("Autorul a fost adaugat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //returnreaza lista de autori
    public List<Autor> getAll() {
        return repo.getAll();
    }
    

    //ordonare descrescatoare dupa nr de publicatii
	public void sortareDesc(List<Autor> autoriList){
		boolean ok;				 
		do { 
		   ok = true;
		   for (int i = 0; i < autoriList.size() - 1; i++)
		     if (autoriList.get(i).getNrPublicatii() < autoriList.get(i+1).getNrPublicatii()){ 
		    	 Autor aux = autoriList.get(i);		//schimbarea intre autori
		    	 Autor aux1 = autoriList.get(i+1);	
		    	 try {
		    		 	repo.schimbareAutori(aux,aux1);
			        } catch (Exception e) {
			            System.out.println(e.getMessage());
			        }
				 ok = false;
			}
		}
	   while (!ok);
	 }

}
