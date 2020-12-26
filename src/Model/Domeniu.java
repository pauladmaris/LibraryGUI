package Model;


public class Domeniu {
	private int id;
	private String nume;
	private String cuvinteCheie;
	
	//constr implicit
		public Domeniu() {
		   this.id = 0;
		   this.nume = "";
		   this.cuvinteCheie = "";
	   }
		//constr cu param
	   public Domeniu(int id, String nume, String cuvinteCheie) {
		   this.id = id;
		   this.nume = nume;
		   this.cuvinteCheie = cuvinteCheie;
	   }
	   
	   //id-ul
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   // numele domeniului
	   public String getNume() {
		   return nume;
	   }
	   public void setNume(String nume) {
		   this.nume = nume;
	   }
	   
	   // cuvintele cheie
	   public String getCuvinteCheie() {
		   return cuvinteCheie;
	   }
	   public void setCuvinteCheie(String cuvinteCheie) {
		   this.cuvinteCheie = cuvinteCheie;
	   }
	   
	   //scrierea in fisier
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + nume + ',' + cuvinteCheie;	 
	   }
}
