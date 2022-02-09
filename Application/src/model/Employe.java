package model;

public class Employe {
private int code_emp;
private String nom_emp;
private String prenom_emp;
private String grade_emp;
private String fonction;
private String intitulé_dep;
public Employe(int code_emp, String nom_emp, String prenom_emp, String grade_emp, String fonction, String intitule) {
	super();
	this.code_emp = code_emp;
	this.nom_emp = nom_emp;
	this.prenom_emp = prenom_emp;
	this.grade_emp = grade_emp;
	this.fonction = fonction;
	this.intitulé_dep= intitule;
}
public int getCode_emp() {
	return code_emp;
}
public void setCode_emp(int code_emp) {
	this.code_emp = code_emp;
}
public String getNom_emp() {
	return nom_emp;
}
public void setNom_emp(String nom_emp) {
	this.nom_emp = nom_emp;
}
public String getPrenom_emp() {
	return prenom_emp;
}
public void setPrenom_emp(String prenom_emp) {
	this.prenom_emp = prenom_emp;
}
public String getGrade_emp() {
	return grade_emp;
}
public void setGrade_emp(String grade_emp) {
	this.grade_emp = grade_emp;
}
public String getFonction() {
	return fonction;
}
public void setFonction(String fonction) {
	this.fonction = fonction;
}
public String getIntitulé_dep() {
	return intitulé_dep;
}
public void setIntitulé_dep(String intitulé_dep) {
	this.intitulé_dep = intitulé_dep;
}



}
