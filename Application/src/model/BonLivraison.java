package model;

public class BonLivraison {
private int num_bliv;
private String date_liv;
private int quantité;
public BonLivraison(int num_bliv, String date_liv, int quantite) {
	super();
	this.num_bliv = num_bliv;
	this.date_liv = date_liv;
	this.quantité = quantite;
}
public int getNum_bliv() {
	return num_bliv;
}
public void setNum_bliv(int num_bliv) {
	this.num_bliv = num_bliv;
}
public String getDate_liv() {
	return date_liv;
}
public void setDate_liv(String date_liv) {
	this.date_liv = date_liv;
}
public int getQuantité() {
	return quantité;
}
public void setQuantité(int quantité) {
	this.quantité = quantité;
}


}
