package View;

import Model.*;

import java.util.List;

public class CorpTabel {
	
	//afisarea cartilor de la un anumit autor
    public static void afisCartiAutor(List<Carte> cartiList, String numeAutor) {
  
        for (int i = 0; i < cartiList.size(); i++) {
                if (numeAutor.equals(cartiList.get(i).getNumeAutor())) {
                    System.out.format("| %10s | %-22s | %5s | %-20s |\n", cartiList.get(i).getId(),cartiList.get(i).getTitlu(),cartiList.get(i).getAn(),cartiList.get(i).getEditura());
                }
            
        }
    }
    
    //afisarea cartilor de la o anumita editura
    public static void afisCartiEditura(List<Carte> cartiList, String editura) {
    	  
        for (int i = 0; i < cartiList.size(); i++) {
            
                if (editura.equals(cartiList.get(i).getEditura())) {
                	System.out.format("| %10s | %-22s | %5s | %-20s |\n", cartiList.get(i).getId(),cartiList.get(i).getTitlu(),cartiList.get(i).getAn(),cartiList.get(i).getNumeAutor());
                }    
        }
    }
    
    //afisarea cartilor de la un anumit domeniu
    public static void afisCartiDomeniu(List<Carte> cartiList, String domeniuCuvinte) {
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
        		System.out.format("| %10s | %-22s | %-20s | %-20s |\n", cartiList.get(i).getId(),cartiList.get(i).getTitlu(),cartiList.get(i).getNumeAutor(),cartiList.get(i).getEditura());
        }
    }
    
    //afisarea cartilor
    public static void afisCarti_total(List<Carte> cartiList){
        for (int i = 0; i < cartiList.size(); i++)
            System.out.format("| %10s | %-20s | %-20s | %5s | %-20s | %-67s | %10s |\n",cartiList.get(i).getId(),cartiList.get(i).getTitlu(),cartiList.get(i).getNumeAutor(),cartiList.get(i).getAn(),cartiList.get(i).getEditura(),cartiList.get(i).getDescriere(),cartiList.get(i).getCota());

    }

    //afisarea autorilor
    public static void afisAutori_total(List<Autor> autoriList){
        for (int i = 0; i < autoriList.size(); i++)
            System.out.format("| %10s | %-20s | %15s | %-20s |\n",autoriList.get(i).getId(),autoriList.get(i).getNumeAutor(),autoriList.get(i).getNrPublicatii(),autoriList.get(i).getCategorie());
    }
    
    //afisarea editurilor
    public static void afisEdituri_total(List<Editura> edituriList){
        for (int i = 0; i < edituriList.size(); i++)
            System.out.format("| %10s | %-20s | %5s | %-45s |\n", edituriList.get(i).getId(),edituriList.get(i).getNume(),edituriList.get(i).getAn(),edituriList.get(i).getCategorii());

    }

    //afisarea domeniilor
    public static void afisDomenii_total(List<Domeniu> domeniiList){
        for (int i = 0; i < domeniiList.size(); i++)
            System.out.format("| %10s | %-20s | %-80s |\n",domeniiList.get(i).getId(),domeniiList.get(i).getNume(),domeniiList.get(i).getCuvinteCheie());
    }
}

