package Controller;

import Model.Autor;
import Model.Domeniu;
import Repository.RepoDomenii;


import java.util.*;


public class Controller_Domeniu {
    private RepoDomenii repo;

    //constructor cu param.
    public Controller_Domeniu(RepoDomenii repo) {
        this.repo = repo;
    }

    //citirea din fisier
    public void readFromFile_Domenii() {
        repo.readFromFile_Domenii();
    }

    //adaugarea unui domeniu
    public void addDomeniu(int id, String nume, String cuvinteCheie) {
    	Domeniu Domeniu = new Domeniu(id,nume,cuvinteCheie);
    	try {
            repo.addDomeniu(Domeniu);
            System.out.println("Domeniul a fost adaugat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //returneaza lista cu toate domeniile
    public List<Domeniu> getAll() {
        return repo.getAll();
    }
    
    //cauta daca exista Domeniu cu acel nume
    public int searchByNumeDomeniu(String nume) {
        return repo.searchByNumeDomeniu(nume);
    }
    

}