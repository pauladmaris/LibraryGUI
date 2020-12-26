package Model;


public class Editura {
	private int id;
	private String nume;
	private String categorii;
	private int an;
	
	//constr implicit
		public Editura() {
		   this.id = 0;
		   this.nume = "";
		   this.an = 2000;
		   this.categorii = "";
	   }
		
		//constr cu param
	   public Editura(int id, String nume, int an, String categorii) {
		   this.id = id;
		   this.nume = nume;
		   this.an = an;
		   this.categorii = categorii;
	   }
	   
	 //id-ul
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   // numele autorului
	   public String getNume() {
		   return nume;
	   }
	   public void setNume(String nume) {
		   this.nume = nume;
	   }
	   
	   // categoria
	   public String getCategorii() {
		   return categorii;
	   }
	   public void setCategorii(String categorii) {
		   this.categorii = categorii;
	   }
	   
	   // numarul de publicatii
	   public int getAn() {
		   return an;
	   }
	   public void setAn(int an) {
		   this.an = an;
	   }
	   
	   //scrierea in fisier
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + nume + ',' + categorii + ',' + String.valueOf(an);	 
	   }
}
