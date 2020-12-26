package Model;

public class Autor {
	private int id;
	private String nume_autor;
	private int nr_publicatii;
	private String categorie;
	
	//constr implicit
	   public Autor() {
		   this.id = 0;
		   this.nume_autor = "";
		   this.nr_publicatii = 0;
		   this.categorie = "";
	   }
	   
	   //constr cu param
	   public Autor(int id, String nume_autor, int nr_publicatii, String categorie) {
		   this.id = id;
		   this.nume_autor = nume_autor;
		   this.nr_publicatii = nr_publicatii;
		   this.categorie = categorie;
	   }
	 
	   //id-ul
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   // numele autorului
	   public String getNumeAutor() {
		   return nume_autor;
	   }
	   public void setNumeAutor(String nume) {
		   this.nume_autor = nume;
	   }
	   
	   // categoria
	   public String getCategorie() {
		   return categorie;
	   }
	   public void setCategorie(String categorie) {
		   this.categorie = categorie;
	   }
	   
	   // numarul de publicatii
	   public int getNrPublicatii() {
		   return nr_publicatii;
	   }
	   public void setNrPublicatii(int nr) {
		   this.nr_publicatii = nr;
	   }
	   
	   //scrierea in fisier
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + nume_autor + ',' + String.valueOf(nr_publicatii) + ',' + categorie;	 
	   }
}
