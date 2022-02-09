package model;

public class Product {
private int code_pro;
private String designation;
private int qte_stock;
private String date_stock;
private String type;
private int seuil;
private String categorie;


public Product(int code, String designation, int qte_stock, String date_stock, String type, int seuil,String titre) {
	super();
	this.code_pro = code;
	this.designation = designation;
	this.qte_stock = qte_stock;
	this.date_stock = date_stock;
	this.type = type;
	this.seuil = seuil;
	this.categorie = titre;
}

public int getCode_pro() {
	return code_pro;
}

public void setCode_pro(int code_pro) {
	this.code_pro = code_pro;
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public String getDate_stock() {
	return date_stock;
}
public void setDate_stock(String date_stock) {
	this.date_stock = date_stock;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}


public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getQte_stock() {
	return qte_stock;
}
public void setQte_stock(int qte_stock) {
	this.qte_stock = qte_stock;
}
public int getSeuil() {
	return seuil;
}
public void setSeuil(int seuil) {
	this.seuil = seuil;
}


}
