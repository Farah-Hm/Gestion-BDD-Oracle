package model;

public class Category {
private int num_cat;
private String categorie;
public Category(int code, String titre) {
	super();
	this.num_cat = code;
	this.categorie = titre;
}
public Category(String titre) {
	super();
	this.categorie = titre;
}
public int getNum_cat() {
	return num_cat;
}
public void setNum_cat(int num_cat) {
	this.num_cat = num_cat;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}

}
