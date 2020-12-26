package Controller;

//import Model.Carte;
import Model.Editura;
//import Repository.RepoCarti;
import Repository.RepoEdituri;


import java.util.*;

public class Controller_Editura {
    private RepoEdituri repo;

    //cosntr cu param
    public Controller_Editura(RepoEdituri repo) {
        this.repo = repo;
    }

    //citirea din fisier
    public void readFromFile_Edituri() {
        repo.readFromFile_Edituri();
    }

    //adaugarea unei edituri
    public void addEditura(int id, String nume, int an, String categorii) {
    	Editura editura = new Editura(id,nume,an,categorii);
    	try {
            repo.addEditura(editura);
            System.out.println("Editura a fost adaugata!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //actualizarea unei edituri
    public void updateEditura(int id, String nume,int an, String categorii) {
    	Editura editura = new Editura(id,nume,an, categorii);
    	try {
            repo.updateEditura(editura);
            System.out.println("Editura a fost actualizata!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //returneaza lista cu editurile
    public List<Editura> getAll() {
        return repo.getAll();
    }


    //stergerea unei edituri
    public void deleteEditura(int id) throws Exception {
        int position = repo.searchByIdEditura(id);
        if (position != -1) {
            Editura Editura = new Editura(id, repo.getEditura(position).getNume(), repo.getEditura(position).getAn(), repo.getEditura(position).getCategorii());
            try {
                repo.deleteEditura(Editura);
                System.out.println("Editura a fost stearsa!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new Exception("Editura nu exista!");
        }
    }

}
