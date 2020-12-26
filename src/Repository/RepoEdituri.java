package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Model.Editura;

import java.util.Scanner;

public class RepoEdituri {
    private List<Editura> edituriList;
    private String fileName;

    //constr implicit
    public RepoEdituri(String fileName) {
        this.fileName = fileName;
        edituriList = new ArrayList<>();
    }

    //constr cu param
    public RepoEdituri(List<Editura> edituriList, String fileName) {
        this.edituriList = edituriList;
        this.fileName = fileName;
    }

    //returneaza lista de edituri
    public int getSize() {
        return edituriList.size();
    }

    //citire din fisier
    public void readFromFile_Edituri() {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            edituriList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String string_id_editura = components[0].trim();
                String nume = components[1].trim();
                String string_an = components[2].trim();
                String categorii = components[3].trim();
                int an = Integer.parseInt(string_an);
                int id = Integer.parseInt(string_id_editura);
                Editura editura = new Editura(id,nume,an,categorii);
                edituriList.add(editura);
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

        for (int i = 0; i < edituriList.size(); i++) {
            bw.write(edituriList.get(i).toStringForWriteToFile());
            bw.newLine();
        }
        bw.close();
    }

    //cautare editura dupa id
    public int searchByIdEditura(int id) {
        for (int i = 0; i < edituriList.size(); i++) {
            if (edituriList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    //adaugare editura    
    public void addEditura(Editura a) throws Exception {
        int position = searchByIdEditura(a.getId());
        if (position == -1) //if the object do not already exists in the list
        {
            edituriList.add(a);
            writeToFile();
        } else
            throw new Exception("Editura exista deja !");
    }

    //actualizare editura
    public void updateEditura(Editura a) throws Exception {
        int position = searchByIdEditura(a.getId());
        if (position == -1) {
            throw new Exception("Editura nu exista!");
        } else {
            edituriList.set(position, a);
            writeToFile();
        }
    }

    //stergere editura
    public void deleteEditura(Editura a) throws Exception {
        int position = searchByIdEditura(a.getId());
        if (position == -1) {
            throw new Exception("Editura nu exista!");
        } else {
            edituriList.remove(position);
            writeToFile();
        }
    }

    //returneaza lista de edituri
    public List<Editura> getAll() {
        return edituriList;
    }

    //returneaza un obiect de tip editura
    public Editura getEditura(int position) {
        return edituriList.get(position);
    }


}
