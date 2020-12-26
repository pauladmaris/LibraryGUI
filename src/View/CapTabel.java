package View;


public class CapTabel {
    public static void afisCartiAutor_sus() {
        System.out.println();
        System.out.println("======================================================================");
        System.out.format("| %10s | %-22s | %5s | %-20s |\n", "ID carte", "Titlu", "Anul","Editura");
        System.out.println("======================================================================");
    }

    public static void afisCartiAutor_jos() {
        System.out.println("======================================================================");
        System.out.println();
    }


    public static void afisCartiEditura_sus() {
        System.out.println();
        System.out.println("======================================================================");
        System.out.format("| %10s | %-22s | %5s | %-20s |\n", "ID carte", "Titlu", "Anul", "Nume autor");
        System.out.println("======================================================================");
    }

    public static void afisCartiEditura_jos() {
        System.out.println("======================================================================");
        System.out.println();
    }

    public static void afisCartiDomeniu_sus() {
        System.out.println();
        System.out.println("====================================================================================");
        System.out.format("| %10s | %-22s | %-20s | %-20s |\n", "ID carte", "Titlu", "Nume autor", "Editura");
        System.out.println("====================================================================================");
    }

    public static void afisCartiDomeniu_jos() {
        System.out.println("====================================================================================");
        System.out.println();
    }


    public static void afisCarti_total_sus() {
        System.out.println();
        System.out.println("==============================================================================================================================================================================");
        System.out.format("| %10s | %-20s | %-20s | %5s | %-20s | %-67s | %-10s |\n", "ID carte","Titlu","Nume autor","Anul","Editura","Descriere","Cota");

        System.out.println("==============================================================================================================================================================================");
    }

    public static void afisCarti_total_jos() {
        System.out.println("==============================================================================================================================================================================");
        System.out.println();
    }

    public static void afisAutori_total_sus() {
        System.out.println();
        System.out.println("==============================================================================");
        System.out.format("| %10s | %-20s | %15s | %-20s |\n", "ID autor", "Nume", "Nr publicatii", "Categorie");


        System.out.println("==============================================================================");
    }

    public static void afisAutori_total_jos() {
        System.out.println("==============================================================================");
        System.out.println();
    }
    
    public static void afisEdituri_total_sus() {
        System.out.println();
        System.out.println("=============================================================================================");
        System.out.format("| %10s | %-20s | %-5s | %-45s |\n", "ID editura", "Nume", "An", "Categorii");

        System.out.println("=============================================================================================");
    }

    public static void afisEdituri_total_jos() {
        System.out.println("=============================================================================================");
        System.out.println();
    }

    public static void afisDomenii_total_sus() {
        System.out.println();
        System.out.println("========================================================================================================================");
        System.out.format("| %10s | %-20s | %-80s |\n", "ID domeniu", "Nume", "Cuvinte cheie");


        System.out.println("========================================================================================================================");
    }

    public static void afisDomenii_total_jos() {
        System.out.println("========================================================================================================================");
        System.out.println();
    }

}

