package model;

public class BonLivraison {
private int num_bliv;
private String date_liv;
private int quantit�;
public BonLivraison(int num_bliv, String date_liv, int quantite) {
	super();
	this.num_bliv = num_bliv;
	this.date_liv = date_liv;
	this.quantit� = quantite;
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
public int getQuantit�() {
	return quantit�;
}
public void setQuantit�(int quantit�) {
	this.quantit� = quantit�;
}


}
