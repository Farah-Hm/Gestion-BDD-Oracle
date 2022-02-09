package model;

public class Fournisseur {

	private int code_fournisseur;
	private String nom_fournisseur;
	private int num_compte;
	private int num_tel;
	public Fournisseur(int code_fournisseur, String nom_fournisseur, int num_compte, int num_tel) {
		super();
		this.code_fournisseur = code_fournisseur;
		this.nom_fournisseur = nom_fournisseur;
		this.num_compte = num_compte;
		this.num_tel = num_tel;
	}
	public int getCode_fournisseur() {
		return code_fournisseur;
	}
	public void setCode_fournisseur(int code_fournisseur) {
		this.code_fournisseur = code_fournisseur;
	}
	public String getNom_fournisseur() {
		return nom_fournisseur;
	}
	public void setNom_fournisseur(String nom_fournisseur) {
		this.nom_fournisseur = nom_fournisseur;
	}
	public int getNum_compte() {
		return num_compte;
	}
	public void setNum_compte(int num_compte) {
		this.num_compte = num_compte;
	}
	public int getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(int num_tel) {
		this.num_tel = num_tel;
	}
	
}
