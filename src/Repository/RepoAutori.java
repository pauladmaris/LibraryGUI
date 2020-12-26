package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Model.Autor;

import java.util.Scanner;

public class RepoAutori {
    private List<Autor> autoriList;
    private String fileName;

    //constructor implicit

    public RepoAutori(String fileName) {
        this.fileName = fileName;
        autoriList = new ArrayList<>();
    }

    //constructor cu param
    public RepoAutori(List<Autor> autoriList, String fileName) {
        this.autoriList = autoriList;
        this.fileName = fileName;
    }

    //dimensiunea listei cu autori
    public int getSize() {
        return autoriList.size();
    }

    //citirea din fisier
    public void readFromFile_Autori() {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            autoriList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String string_id_autor = components[0].trim();
                String nume_autor = components[1];
                String categorie = components[3].trim();
                String string_nr_pub = components[2].trim();
                int nr_publicatii = Integer.parseInt(string_nr_pub);
                int id = Integer.parseInt(string_id_autor);
                Autor autor = new Autor(id,nume_autor,nr_publicatii,categorie);
                autoriList.add(autor);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Eroare in citirea din fisier!");
        }
    }

    //scrierea in fisier
    public void writeToFile() throws IOException {
        File fileOutput = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutput);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for (int i = 0; i < autoriList.size(); i++) {
            bw.write(autoriList.get(i).toStringForWriteToFile());
            bw.newLine();
        }
        bw.close();
    }

    //cautare autor dupa id
    public int searchByIdAutor(int id) {
        for (int i = 0; i < autoriList.size(); i++) {
            if (autoriList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    //adauga un autor
    public void addAutor(Autor a) throws Exception {
        int position = searchByIdAutor(a.getId());
        if (position == -1) //if the object do not already exists in the list
        {
            autoriList.add(a);
            writeToFile();
        } else
            throw new Exception("Autorul exista deja !");
    }

    //actualizare autor
    
    public void updateAutor(Autor a) throws Exception {
        int position = searchByIdAutor(a.getId());
        if (position == -1) {
            throw new Exception("Autorul nu exista!");
        } else {
            autoriList.set(position, a);
            writeToFile();
        }
    }
    
    //schimbare intre pozitiile autorilor
    public void schimbareAutori(Autor a, Autor b) throws Exception {
        int positionA = searchByIdAutor(a.getId());
        int positionB = searchByIdAutor(b.getId());
        
        autoriList.set(positionA, b);
        autoriList.set(positionB, a);
        //writeToFile();
        
    }

    
    //returneaza lista cu toti autorii
    public List<Autor> getAll() {
        return autoriList;
    }

    //returneaza Autor dupa pozitie
    public Autor getAutor(int position) {
        return autoriList.get(position);
    }


}
