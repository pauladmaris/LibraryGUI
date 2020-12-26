package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Model.Domeniu;

import java.util.Scanner;

public class RepoDomenii {
    private List<Domeniu> domeniiList;
    private String fileName;

    //constr implicit
    public RepoDomenii(String fileName) {
        this.fileName = fileName;
        domeniiList = new ArrayList<>();
    }

    //constr cu param
    public RepoDomenii(List<Domeniu> domeniiList, String fileName) {
        this.domeniiList = domeniiList;
        this.fileName = fileName;
    }

    //returneaza lungimea listei de domenii
    public int getSize() {
        return domeniiList.size();
    }

    //citirea din fisier
    public void readFromFile_Domenii() {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            domeniiList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String string_id_domeniu = components[0].trim();
                String nume = components[1].trim();
                String cuvinteCheie = components[2].trim();
                int id = Integer.parseInt(string_id_domeniu);
                Domeniu Domeniu = new Domeniu(id,nume,cuvinteCheie);
                domeniiList.add(Domeniu);
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

        for (int i = 0; i < domeniiList.size(); i++) {
            bw.write(domeniiList.get(i).toStringForWriteToFile());
            bw.newLine();
        }
        bw.close();
    }

    //cautarea dupa id domeniu
    public int searchByIdDomeniu(int id) {
        for (int i = 0; i < domeniiList.size(); i++) {
            if (domeniiList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    
    //cautarea dupa nume domeniu
    public int searchByNumeDomeniu(String nume) {
        for (int i = 0; i < domeniiList.size(); i++) {
            if (nume.equals(domeniiList.get(i).getNume())) {
                return i;
            }
        }
        return -1;
    }

    //adaugare domeniu
    public void addDomeniu(Domeniu a) throws Exception {
        int position = searchByIdDomeniu(a.getId());
        if (position == -1) //if the object do not already exists in the list
        {
            domeniiList.add(a);
            writeToFile();
        } else
            throw new Exception("Domeniu exista deja !");
    }

    //actualizare domeniu
    public void updateDomeniu(Domeniu a) throws Exception {
        int position = searchByIdDomeniu(a.getId());
        if (position == -1) {
            throw new Exception("Domeniul nu exista!");
        } else {
            domeniiList.set(position, a);
            writeToFile();
        }
    }

    //stergere domeniu
    public void deleteDomeniu(Domeniu a) throws Exception {
        int position = searchByIdDomeniu(a.getId());
        if (position == -1) {
            throw new Exception("Domeniul nu exista!");
        } else {
            domeniiList.remove(position);
            writeToFile();
        }
    }

    //returneaza lista de domenii
    public List<Domeniu> getAll() {
        return domeniiList;
    }

    //returneaza un obiect de tip Domeniu
    public Domeniu getDomeniu(int position) {
        return domeniiList.get(position);
    }


}
