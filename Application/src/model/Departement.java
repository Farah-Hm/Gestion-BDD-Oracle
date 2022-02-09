package model;

public class Departement {
private int code_dep;
private String intitulé_dep;
private String nom_chef;
private String prenom_chef;

public Departement(int code_dep, String intitule, String nom_chef, String prenom_chef) {
	super();
	this.code_dep = code_dep;
	this.intitulé_dep = intitule;
	this.nom_chef = nom_chef;
	this.prenom_chef = prenom_chef;
}
public int getCode_dep() {
	return code_dep;
}
public void setCode_dep(int code_dep) {
	this.code_dep = code_dep;
}

public String getIntitulé_dep() {
	return intitulé_dep;
}
public void setIntitulé_dep(String intitulé_dep) {
	this.intitulé_dep = intitulé_dep;
}
public String getNom_chef() {
	return nom_chef;
}
public void setNom_chef(String nom_chef) {
	this.nom_chef = nom_chef;
}
public String getPrenom_chef() {
	return prenom_chef;
}
public void setPrenom_chef(String prenom_chef) {
	this.prenom_chef = prenom_chef;
}

}
