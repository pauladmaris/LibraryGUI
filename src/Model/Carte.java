package Model;


public class Carte {
	   private int id;
	   private String titlu;  
	   private String nume_autor;	 
	   private int an;	 
	   private String editura;	
	   private String descriere; 
	   private String cota; 
	   
	   //constr implicit
	   public Carte() {
		   this.id = 0;
		   this.titlu = "";
		   this.nume_autor = "";
		   this.an = 1900;
		   this.editura = "";
		   this.descriere = "";
		   this.cota = "";
	   }
	   
	   //constr cu param
	   public Carte(int id,String titlu, String nume_autor, int an, String editura, String descriere, String cota) {
		   this.id = id;
		   this.titlu = titlu;
		   this.nume_autor = nume_autor;
		   this.an = an;
		   this.editura = editura;
		   this.descriere = descriere;
		   this.cota = cota;
	   }
	   
	   //id-ul
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   // titlul cartii
	   public String getTitlu() {
		   return titlu;
	   }
	   public void setTitlu(String titlu) {
		   this.titlu = titlu;
	   }
	   
	   // numele autorului
	   public String getNumeAutor() {
		   return nume_autor;
	   }
	   public void setNumeAutor(String nume) {
		   this.nume_autor = nume;
	   }
	   
	   // editura
	   public String getEditura() {
		   return editura;
	   }
	   public void setEditura(String editura) {
		   this.editura = editura;
	   }
	   
	   //anul
	   public int getAn() {
		   return an;
	   }
	   public void setAn(int an) {
		   this.an = an;
	   }
	   
	   // descrierea
	   public String getDescriere() {
		   return descriere;
	   }
	   public void setDescriere(String desc) {
		   this.descriere = desc;
	   }
	   
	   // cota
	   public String getCota() {
		   return cota;
	   }
	   public void setCota(String cota) {
		   this.cota = cota;
	   }
	   
	   //scrierea in fisier
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + titlu + ',' + nume_autor + ',' + String.valueOf(an) + ',' + editura + ',' + descriere + ',' + cota;
	    }
	   
}
